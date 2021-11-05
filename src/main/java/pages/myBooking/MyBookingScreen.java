package pages.myBooking;

import helpers.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MyBookingScreen {
    AndroidDriver driver;

    public MyBookingScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ru.s7.android:id/btnOptionsMenu")
    private MobileElement editTripBtn;//кнопка Редактировать в карточке трипа

    @AndroidFindBy(id = "ru.s7.android:id/btnDelete")
    private MobileElement deleteTripBtn;//кнопка Удалить в списке Действия с путешествием

    @AndroidFindBy(id = "ru.s7.android:id/yes")
    private MobileElement confirmDeleteTripBtn;//кнопка Удалить в pop-up Удалить путешествие

    @AndroidFindBy(id = "ru.s7.android:id/btnAdd")
    private MobileElement addTripBtn;//кнопка Добавить путешествие

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='ru.s7.android:id/btnText' and @text='Купить билет']")
    private MobileElement bayTripBtn;//кнопка Купить билет

    String bayTripBtnXpathLocator = "//android.widget.TextView[@resource-id='ru.s7.android:id/btnText' and @text='Купить билет']";

    Waits waits = new Waits();

    //метод удаляет трип
    public void deleteOneTrip() {
        editTripBtn.click();
        deleteTripBtn.click();
        confirmDeleteTripBtn.click();
    }

    //метод удаляет все трипы
    public void deleteAllTrips() {
        if (!waits.elementIsDisp(bayTripBtnXpathLocator)) {
            int count = 0;
            while (count < 10 && !waits.elementIsDisp(bayTripBtnXpathLocator)) {
                deleteOneTrip();
                ++count;
            }
        }
    }

}
