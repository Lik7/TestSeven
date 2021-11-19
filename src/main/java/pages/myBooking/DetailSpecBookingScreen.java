package pages.myBooking;

import generalActions.pay.Pay;
import helpers.Swipes;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

//экран деталей конкретной брони
public class DetailSpecBookingScreen {
    AndroidDriver driver;

    public DetailSpecBookingScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    String fieldAeroexpress = "//android.widget.TextView[contains(@resource-id,\"ru.s7.android:id/twTitle\") and @text=\"Аэроэкспресс\"]";
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"ru.s7.android:id/twTitle\") and @text=\"Аэроэкспресс\"]")
    private MobileElement fieldAeroexpressInBannerAE;//поле с текстом Аэроэкспресс в баннере АЕ

    @AndroidFindBy(id = "ru.s7.android:id/btnNext")
    private MobileElement safeBtn;//кнопка Сохранить/Далее

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"ru.s7.android:id/btnNext\") and @text=\"Оплатить\"]")
    private MobileElement payBtn;//кнопка Оплатить на экране оплаты

    @Step("Тап по баннеру АЕ")
    public void clickFieldAEInBannerAE() {
        Swipes swipe = new Swipes();
        swipe.swipeUpToElement(fieldAeroexpress);
        fieldAeroexpressInBannerAE.click();
    }

    @Step("Тап по кнопке Сохранить / Далее")
    public void clickSafeBtn(){
        safeBtn.click();
    }

    @Step("Заполняю реквизиты оплаты банковской картой")
    public void fillPaymentDetails(){
        Pay pay = new Pay(driver);
        pay.selectMethodOfPayment(1);
        pay.fillCVVField();
        pay.onSwitchAgreeToTerms();
    }

    @Step("Нажимаю кнопку Оплатить")
    public void tapPayBtn() {
        payBtn.click();
    }
}
