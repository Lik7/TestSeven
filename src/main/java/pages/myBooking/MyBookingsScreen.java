package pages.myBooking;

import helpers.ElementIsMissing;
import helpers.Waits;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//Экран с карточками броней (все брони)
public class MyBookingsScreen {
    AndroidDriver driver;

    public MyBookingsScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ru.s7.android:id/btnOptionsMenu")
    private WebElement editTripBtn;//кнопка Редактировать в карточке трипа

    @AndroidFindBy(id = "ru.s7.android:id/btnDelete")
    private WebElement deleteTripBtn;//кнопка Удалить в списке Действия с путешествием

    @AndroidFindBy(id = "ru.s7.android:id/yes")
    private WebElement confirmDeleteTripBtn;//кнопка Удалить в pop-up Удалить путешествие

    @AndroidFindBy(id = "ru.s7.android:id/btnAdd")
    private WebElement addTripBtn;//кнопка Добавить путешествие

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='ru.s7.android:id/btnText' and @text='Купить билет']")
    private WebElement bayTripBtn;//кнопка Купить билет

    //@AndroidFindBy(id = "ru.s7.android:id/tvDestination")
    //private WebElement cityInBookingCard; //поле с названием города в карточке брони

    String bayTripBtnXpathLocator = "//android.widget.TextView[@resource-id='ru.s7.android:id/btnText' and @text='Купить билет']";

    //Waits waits = new Waits();

    @Step("Удаляю первую бронь")
    public void deleteOneTrip() {
        editTripBtn.click();
        deleteTripBtn.click();
        confirmDeleteTripBtn.click();
    }

    @Step("Удаляю все брони")
    public void deleteAllTrips() {
        if (!ElementIsMissing.elementIsDispXPathLocator(bayTripBtnXpathLocator)) {
            int count = 0;
            while (count < 10 && !ElementIsMissing.elementIsDispXPathLocator(bayTripBtnXpathLocator)) {
                deleteOneTrip();
                ++count;
            }
        }
    }

/*    @Step("Перехожу на экран деталей брони")
    public DetailSpecBookingScreen clickCityInBookingCard(){
        cityInBookingCard.click();
        return new DetailSpecBookingScreen(driver);
    }*/
}
