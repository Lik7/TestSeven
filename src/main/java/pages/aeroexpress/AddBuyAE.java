package pages.aeroexpress;

import generalActions.pay.Pay;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class AddBuyAE {

    private AndroidDriver driver;

    public AddBuyAE(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ru.s7.android:id/btnNext")
    private MobileElement safeBtn;//кнопка Сохранить/Далее

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"ru.s7.android:id/btnNext\") and @text=\"Оплатить\"]")
    private MobileElement payBtn;//кнопка Оплатить на экране оплаты

    @AndroidFindBy(id ="ru.s7.android:id/yes")
    private MobileElement OKBtn;//кнопка ОК в поп-ап результата


    @Step("Тап по кнопке Сохранить / Далее")
    public void clickSafeBtn() {
        safeBtn.click();
    }

    @Step("Заполняю реквизиты оплаты банковской картой")
    public void fillPaymentDetails() {
        Pay pay = new Pay(driver);
        pay.selectMethodOfPaymentIsCard();
        pay.fillCVVField();
        pay.onSwitchAgreeToTerms();
    }

    @Step("Нажимаю кнопку Оплатить")
    public void tapPayBtn() {
        payBtn.click();
    }

    @Step("Нажимаю кнопку ОК в поп-ап результата покупки АЕ")
    public void clickOkBtn(){
        OKBtn.click();
    }
}
