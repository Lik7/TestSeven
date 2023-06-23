package generalActions.pay;

import helpers.Scroll;
import helpers.Swipes;
import helpers.Switch;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//заполнение экрана оплаты
public class PayScreen {
    AndroidDriver driver;

    public PayScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    Swipes swipe = new Swipes();

    @AndroidFindBy(id = "ru.s7.android:id/btnChoosePaymentType")
    private WebElement methodsOfPaymentBtn;//кнопка Способы оплаты на экране Оплата

    @AndroidFindBy(id = "ru.s7.android:id/paymentCardName")
    private List<WebElement> methodsOfPaymentList;//список способов оплаты

    @AndroidFindBy(id = "ru.s7.android:id/etPaymentCardCVV")
    private WebElement CVVField;//поле CVV/CVC2

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'ru.s7.android:id/btnNext')and @text=\"Оплатить\"]")
    private WebElement payBtn; //кнопка Оплатить

    String switchLocatorID = "ru.s7.android:id/agree";


    @Step("Выбираю способ оплаты банковской картой")
    public void selectMethodOfPaymentIsCard() {
        Scroll.scrollToElementDown("//android.widget.EditText[@resource-id='ru.s7.android:id/paymentCardName']", 3);
        selectMethodOfPayment(1);
    }

    @Step("Заполняю поле CVV/CVC2")
    public void fillCVVField() {

        //String df = "//android.widget.TextView[@resource-id='ru.s7.android:id/etPaymentCardCVV']";
        Scroll.scrollToElementDown("//android.widget.EditText[@resource-id='ru.s7.android:id/etPaymentCardCVV']", 10);
        CVVField.sendKeys("123");
    }

    @Step("Включаю свич согласия с условиями")
    public void onSwitchAgreeToTerms() {
        Switch sw = new Switch();
        swipe.swipeDown();
        sw.switchON(switchLocatorID);
    }

    @Step("Нажимаю кнопку Оплатить")
    public void tapPayBtn() {
        payBtn.click();
    }

    @Step("Заполняю реквизиты оплаты банковской картой. Карта сохранена в приложении")
    public void paySavedBankCard() {
        selectMethodOfPaymentIsCard();
        fillCVVField();
        onSwitchAgreeToTerms();
        //tapPayBtn();
    }


    //метод выбирает способ оплаты из списка карт
    private void selectMethodOfPayment(Integer i) {
        methodsOfPaymentBtn.click();
        WebElement WebElement = methodsOfPaymentList.get(i);
        WebElement.click();
    }
}
