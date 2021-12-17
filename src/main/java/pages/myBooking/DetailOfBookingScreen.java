package pages.myBooking;

import helpers.Swipes;
import helpers.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.aeroexpress.AddBuyAEScreen;
import pages.insurance.InsuranceScreen;

//экран деталей конкретной брони
public class DetailOfBookingScreen {
    AndroidDriver driver;

    public DetailOfBookingScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"ru.s7.android:id/twTitle\") and @text=\"Аэроэкспресс\"]")
    private MobileElement fieldAeroexpressInBannerAE;//поле с текстом Аэроэкспресс в баннере АЕ

    @AndroidFindBy(id = "ru.s7.android:id/flAeroexpressIcon")
    private MobileElement aeroexpressIcon;//иконка АЕ в купленном баннере

    @AndroidFindBy(xpath = "//*[@resource-id='ru.s7.android:id/pnrLabel']")
    private MobileElement bookingText;//текст Бронь:

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Спокойствие в поездке']")
    private MobileElement peaceInTripText;//название блока Спокойствие в поездке

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Страховка от невыезда']")
    private MobileElement notLeavingInsName;//название Страховка от невыезда

    Swipes swipe = new Swipes();

    //элемент в уже купленном продукте
    String fieldAeroexpress = "//android.widget.TextView[contains(@resource-id,\"ru.s7.android:id/twTitle\") and @text=\"Аэроэкспресс\"]";
    String AEIconID = "ru.s7.android:id/flAeroexpressIcon";
    //String fieldNotLeavingIns = "android.widget.TextView[contains(@resource-id,'ru.s7.android:id/tvProductName') and @text=\"Страховка от невыезда\"]";

    @Step("Тап по баннеру АЕ")
    public AddBuyAEScreen fieldAEInBannerAEClick() {
        //Swipes swipe = new Swipes();
        swipe.scrollToElementDown(fieldAeroexpress, 10);
        fieldAeroexpressInBannerAE.click();
        return new AddBuyAEScreen(driver);
    }

    @Step("Проверяю, что АЕ добавлен в бронь")
    public boolean aeroexpressIconIsDisp() {
        swipe.scrollUpDownToElement(3, "//*[@resource-id='ru.s7.android:id/flAeroexpressIcon']", "//*[@resource-id='ru.s7.android:id/pnrLabel']");
        return Waits.elementIsDispIDLocator(AEIconID);
    }

    @Step("Скролл до названия блока Спокойствие в поезке")
    public void scrollToPeaceInTripText() {
        swipe.scrollDownUpToElement("//android.widget.TextView[@text='Спокойствие в поездке']", 5);
    }

    @Step("Скролл в слайдере страховок")
    public void swipeToInsSlider() {
        swipe.swipeRightLeftToElement("//android.widget.TextView[@text='Страховка от невыезда']");
    }

    @Step("Тап по баннеру Страховка от невыезда")
    public InsuranceScreen notLeavingInsNameClick() {
        notLeavingInsName.click();
        return new InsuranceScreen(driver);
    }

    @Step("Проверяю, что страховка куплена")
    public boolean payedInsuranceIsDisp(String insurance) {
        String fieldPayedInsurance = "android.widget.TextView[contains(@resource-id,'ru.s7.android:id/tvProductName') and @text='" + insurance + "']";
        return Waits.elementIsDispIDLocator(fieldPayedInsurance);
    }
}