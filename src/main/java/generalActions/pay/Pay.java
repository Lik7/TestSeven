package generalActions.pay;

import helpers.Swipes;
import helpers.Switch;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Pay {
    AndroidDriver driver;

    public Pay(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ru.s7.android:id/btnChoosePaymentType")
    private MobileElement methodsOfPaymentBtn;//кнопка Способы оплаты на экране Оплата

    @AndroidFindBy(id = "ru.s7.android:id/paymentCardName")
    private List<MobileElement> methodsOfPaymentList;//список способов оплаты

    @AndroidFindBy(id = "ru.s7.android:id/etPaymentCardCVV")
    private MobileElement CVVField;//поле CVV/CVC2

    /*@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'ru.s7.android:id/btnNext')and @text=\"Оплатить\"]")
    private MobileElement payBtn; //кнопка Оплатить*/

    String switchLocatorID = "ru.s7.android:id/agree";


    @Step("")
    public void clickMethodsOfPaymentBtn() {
        methodsOfPaymentBtn.click();
    }

    @Step("Выбираю способ оплаты")
    public void selectMethodOfPayment(Integer i) {
        methodsOfPaymentBtn.click();
        MobileElement mobileElement = methodsOfPaymentList.get(i);
        mobileElement.click();
    }

    @Step("Заполняю поле CVV/CVC2")
    public void fillCVVField() {
        Swipes sp = new Swipes();
        //String df = "//android.widget.TextView[@resource-id='ru.s7.android:id/etPaymentCardCVV']";
        sp.swipeUpToElement("//android.widget.EditText[@resource-id='ru.s7.android:id/etPaymentCardCVV']");
        CVVField.sendKeys("123");
    }

    @Step("Включаю свич согласия с условиями")
    public void onSwitchAgreeToTerms() {
        Switch sw = new Switch();
        Swipes sp = new Swipes();
        sp.swipeUpToElement("//android.widget.Switch[@resource-id='ru.s7.android:id/agree']");
        sw.switchON(switchLocatorID);
    }

/*    @Step("Нажимаю кнопку Оплатить")
    public void tapPayBtn() {
        payBtn.click();
    }*/
}
