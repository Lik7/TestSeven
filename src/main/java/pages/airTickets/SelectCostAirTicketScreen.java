package pages.airTickets;

import base.BaseScreen;
import generalActions.pay.PayScreen;
import helpers.Scroll;
import helpers.Swipes;
import helpers.Switch;
import helpers.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectCostAirTicketScreen extends BaseScreen {

    AndroidDriver driver;

    public SelectCostAirTicketScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ru.s7.android:id/rlBackground")
    private MobileElement searchBtn;//кнопка Найти

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'₽')]")
    private List<MobileElement> ticketBlock;//поле Билет

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Прямой']")
    private List<MobileElement> ticketBlock2;//поле Билет

    @AndroidFindBy(id = "ru.s7.android:id/btnNext")
    private MobileElement nextBtn;//кнопка Далее

    @AndroidFindBy(id = "ru.s7.android:id/nameText")
    private List<MobileElement> passengerNameField;//поле с именем пассажира

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Оплатить сейчас']")
    private MobileElement paymentTypePayNowBtn;//тип оплаты Оплатить сейчас

    @AndroidFindBy(id = "ru.s7.android:id/btnChoosePaymentType")
    private MobileElement methodsOfPaymentBtn;//кнопка Способы оплаты на экране Оплата

    @AndroidFindBy(id = "ru.s7.android:id/paymentCardName")
    private List<MobileElement> methodsOfPaymentList;//список способов оплаты

    @AndroidFindBy(id = "ru.s7.android:id/etPaymentCardCVV")
    private MobileElement CVVField;//поле CVV/CVC2

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'ru.s7.android:id/btnNext')and @text=\"Оплатить\"]")
    private MobileElement payBtn; //кнопка Оплатить

    String switchLocatorID = "ru.s7.android:id/agree";


    @Step("Выбор билета")
    public void selectTicket(){
        int i = ticketBlock.size();
        //ticketBlock.get(i-1).click();
        ticketBlock2.get(0).click();
        searchBtn.click();
    }

    @Step("Нажимаю кнопку Далее")
    public void clickNextBtn(){
        nextBtn.click();
    }

    @Step("Добавляю пассажира")
    public void clickAddPassengerBtn(){
        int i = passengerNameField.size();
        passengerNameField.get(0).click();
    }

    @Step("Выбираю способ оплаты")
    public PayScreen selectMethodOfPayment() {
        //Waits waits = new Waits();
        if(Waits.elementIsDispXPathLocator("//android.widget.TextView[@text='Оплатить сейчас']")){
            paymentTypePayNowBtn.click();
        }
        return new PayScreen(driver);
        /*Swipes sp = new Swipes();
        sp.scrollToElementDown("//android.widget.RelativeLayout[@resource-id='ru.s7.android:id/btnChoosePaymentType']", 10);
        methodsOfPaymentBtn.click();
        MobileElement mobileElement = methodsOfPaymentList.get(1);
        mobileElement.click();*/
    }

    @Step("Заполняю поле CVV/CVC2")
    public void fillCVVField() {
        //Swipes sp = new Swipes();
        //String df = "//android.widget.TextView[@resource-id='ru.s7.android:id/etPaymentCardCVV']";
        //sp.swipeUpToElement("//android.widget.EditText[@resource-id='ru.s7.android:id/etPaymentCardCVV']");
        CVVField.sendKeys("123");
    }

    @Step("Включаю свич согласия с условиями")
    public void onSwitchAgreeToTerms() {
        Switch sw = new Switch();
        //Swipes sp = new Swipes();
        Scroll.scrollToElementDown("//android.widget.Switch[@resource-id='ru.s7.android:id/agree']", 10);
        sw.switchON(switchLocatorID);
    }

    @Step("Нажимаю кнопку Оплатить")
    public void tapPayBtn() {
        payBtn.click();
    }

}
