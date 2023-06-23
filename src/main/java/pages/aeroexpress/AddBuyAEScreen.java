package pages.aeroexpress;

import generalActions.pay.PayScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddBuyAEScreen {

    private AndroidDriver driver;

    public AddBuyAEScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ru.s7.android:id/btnNext")
    private WebElement safeBtn;//кнопка Сохранить/Далее

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"ru.s7.android:id/btnNext\") and @text=\"Оплатить\"]")
    private WebElement payBtn;//кнопка Оплатить на экране оплаты

    @AndroidFindBy(id ="ru.s7.android:id/yes")
    private WebElement OKBtn;//кнопка ОК в поп-ап результата


    @Step("Тап по кнопке Сохранить / Далее")
    public void clickSafeBtn() {
        safeBtn.click();
    }

    @Step("Заполняю реквизиты оплаты банковской картой")
    public void fillPaymentDetails() {
        PayScreen payScreen = new PayScreen(driver);
        payScreen.selectMethodOfPaymentIsCard();
        payScreen.fillCVVField();
        payScreen.onSwitchAgreeToTerms();
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
