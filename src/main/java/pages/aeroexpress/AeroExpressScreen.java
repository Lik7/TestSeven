package pages.aeroexpress;

import enums.Dates;
import helpers.DateSelected;
import helpers.Swipes;
import helpers.Switch;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AeroExpressScreen {

    private AndroidDriver driver;

    public AeroExpressScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ru.s7.android:id/tvStartDate")
    private MobileElement thereField;//поле Туда

    @AndroidFindBy(id = "ru.s7.android:id/tvEndDate")
    private MobileElement backField;//поле Обратно

    @AndroidFindBy(id = "ru.s7.android:id/btnSave")
    private MobileElement choiceOfPassengersBtn;//кнопка К выбору пассажиров

    @AndroidFindBy(id = "ru.s7.android:id/btnNext")
    private MobileElement nextBtn;//кнопка Далее на экране Пассажиры

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Имя латиницей']")
    private MobileElement nameInContactField; //поле Имя латиницей в блоке Контакты

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Фамилия латиницей']")
    private MobileElement surnameInContactField; //поле Фамилия латиницей в блоке Контакты

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Телефон']")
    private MobileElement telephoneInContactField; //поле Телефон в блоке Контакты

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email']")
    private MobileElement emailInContactField; //поле Email в блоке Контакты

    @AndroidFindBy(id = "ru.s7.android:id/btnChoosePaymentType")
    private MobileElement methodsOfPaymentBtn;//кнопка Способы оплаты на экране Оплата

    @AndroidFindBy(id = "ru.s7.android:id/paymentCardName")
    private List<MobileElement> methodsOfPaymentList;//список способов оплаты

    @AndroidFindBy(id = "ru.s7.android:id/etPaymentCardCVV")
    private MobileElement CVVField;//поле CVV/CVC2

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'ru.s7.android:id/btnNext')and @text=\"Оплатить\"]")
    private MobileElement payBtn; //кнопка Оплатить


    DateSelected dateSelected = new DateSelected();

    String switchLocatorID = "ru.s7.android:id/agree";

    @Step("Тап в поле Туда")
    public void tapThereBtn() {
        thereField.click();
    }

    @Step("Выбор даты получения")
    public void selectDateThere(Integer n) {
        dateSelected.tapDayStartInCalendar(n);
    }

    @Step("Выбор даты возврата")
    public void selectDateBack(Integer n) {
        dateSelected.tapDayFinishInCalendar(n);
    }

    @Step("Нажать кнопку К выбору пассажиров")
    public void clickChoiceOfPassengersBtn() {
        choiceOfPassengersBtn.click();
    }

    @Step("Нажать кнопку Далее на экране Пассажиры")
    public void clickNextBtn() {
        nextBtn.click();
    }

    @Step("Заполняю поле Имя")
    public void fillNameInContactField() {
        nameInContactField.sendKeys("Ivan");
    }

    @Step("Заполняю поле Фамилия")
    public void fillSurnameInContactField() {
        surnameInContactField.sendKeys("Petrov");
    }

    @Step("Заполняю поле Телефон")
    public void fillTelephoneInContactField() {
        telephoneInContactField.sendKeys("+375295586849");
    }

    @Step("Заполняю поле Email")
    public void fillEmailInContactField() {
        emailInContactField.sendKeys("kanst2016@gmail.com");
    }

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

    @Step("Нажимаю кнопку Оплатить")
    public void tapPayBtn() {
        payBtn.click();
    }

}
