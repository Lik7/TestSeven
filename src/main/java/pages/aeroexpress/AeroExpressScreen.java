package pages.aeroexpress;

import base.BaseScreen;
import enums.Days;
import generalActions.pay.PayScreen;
import helpers.DateSelected;
import helpers.Switch;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import java.util.List;

//экран АЕ из бокового меню
public class AeroExpressScreen extends BaseScreen {

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

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='ru.s7.android:id/tvSuccessTitle' and @text='Оплачено']")
    private MobileElement valueTitleStatus; //текст статуса

    @AndroidFindBy(id = "ru.s7.android:id/tvBookingNumber")
    private MobileElement bookingNumberField; //строка с номером брони

    @AndroidFindBy(id = "ru.s7.android:id/btnGoToTrip")
    private MobileElement goToMyS7Btn; //кнопка Перейти в My S7


    DateSelected dateSelected = new DateSelected();

    String switchLocatorID = "ru.s7.android:id/agree";
    private String bookingNumberOfAE = null;

    @Step("Тап в поле Туда")
    public void tapThereBtn() {
        thereField.click();
    }

/*    @Step("Выбор даты получения")
    public void selectDateThere(Integer n) {
        dateSelected.tapDayStartInCalendar(n);
    }  */

    @Step("Выбор даты возврата")
    public void selectDateBack(Integer n) {
        dateSelected.tapDayFinishInCalendar(Days.IN_FIVE_DAYS);
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
        nameInContactField.clear();
        nameInContactField.sendKeys("Ivan");
    }

    @Step("Заполняю поле Фамилия")
    public void fillSurnameInContactField() {
        surnameInContactField.clear();
        surnameInContactField.sendKeys("Petrov");
    }

    @Step("Заполняю поле Телефон")
    public void fillTelephoneInContactField() {
        telephoneInContactField.clear();
        telephoneInContactField.sendKeys("+375295586849");
    }

    @Step("Заполняю поле Email")
    public void fillEmailInContactField() {
        emailInContactField.click();
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
        scroll.scrollToElementDown("//android.widget.EditText[@resource-id='ru.s7.android:id/etPaymentCardCVV']", 5);
        CVVField.sendKeys("123");
    }

    @Step("Включаю свич согласия с условиями")
    public void onSwitchAgreeToTerms() {
        Switch sw = new Switch();
        //Swipes sp = new Swipes();
        scroll.scrollToElementDown("//android.widget.Switch[@resource-id='ru.s7.android:id/agree']", 5);
        sw.switchON(switchLocatorID);
    }

    @Step("Заполняю реквизиты оплаты банковской картой")
    public void fillPaymentDetails(){
        PayScreen payScreen = new PayScreen(driver);
        payScreen.selectMethodOfPaymentIsCard();
        payScreen.fillCVVField();
        payScreen.onSwitchAgreeToTerms();
    }

    @Step("Нажимаю кнопку Оплатить")
    public void tapPayBtn() {
        payBtn.click();
    }

    @Step("Нажимаю кнопку Перейти в My S7")
    public TripAEScreen clickGoToMyS7Btn() {
        goToMyS7Btn.click();
        return new TripAEScreen(driver);
    }

    private void setBookingNumberField() {
        String bn = bookingNumberField.getText();
        bookingNumberOfAE = bn.substring(bn.indexOf("(")+1, bn.indexOf(")"));
    }

    public String getValueStatus() {
        return valueTitleStatus.getText();
    }

    public String getBookingNumberOfAE() {
        setBookingNumberField();
        return bookingNumberOfAE;
    }

}
