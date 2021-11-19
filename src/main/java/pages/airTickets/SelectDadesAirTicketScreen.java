package pages.airTickets;

import enums.Dates;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SelectDadesAirTicketScreen {
    AndroidDriver driver;

    public SelectDadesAirTicketScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'" + localDate + "')]") //***ДОПИСАТЬ***
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'ноя')]")
    private MobileElement departureDateField;//поле Дата вылета туда

    @AndroidFindBy(id = "ru.s7.android:id/originCity")
    private MobileElement departureCity;//поле город вылета

    @AndroidFindBy(id = "ru.s7.android:id/destinationCity")
    private MobileElement arrivalCity;//поле город прилета

    @AndroidFindBy(id = "ru.s7.android:id/tvTitle")
    private MobileElement searchField;//поле Поиск

    @AndroidFindBy(id = "ru.s7.android:id/rlBackground")
    private MobileElement searchBtn;//кнопка Найти

    @AndroidFindBy(id = "ru.s7.android:id/btn_done")
    private MobileElement doneBtnInCalendar;//кнопка Готово в календаре

    /*@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'₽')]")
    private List <MobileElement> ticketBlock;//поле Билет

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Прямой']")
    private List <MobileElement> ticketBlock2;//поле Билет

    @AndroidFindBy(id="ru.s7.android:id/btnNext")
    private MobileElement nextBtn;//кнопка Далее

    @AndroidFindBy(id = "ru.s7.android:id/circleFrame")
    private List<MobileElement> addPassengerBtn;//кнопка Добавить пассажира

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Оплатить сейчас']")
    private MobileElement paymentTypePayNowBtn;//тип оплаты Оплатить сейчас

    @AndroidFindBy(id = "ru.s7.android:id/btnChoosePaymentType")
    private MobileElement methodsOfPaymentBtn;//кнопка Способы оплаты на экране Оплата

    @AndroidFindBy(id = "ru.s7.android:id/paymentCardName")
    private List<MobileElement> methodsOfPaymentList;//список способов оплаты

    @AndroidFindBy(id = "ru.s7.android:id/etPaymentCardCVV")
    private MobileElement CVVField;//поле CVV/CVC2

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'ru.s7.android:id/btnNext')and @text=\"Оплатить\"]")
    private MobileElement payBtn; //кнопка Оплатить  */


    String switchLocatorID = "ru.s7.android:id/agree";

    @Step("Тап в поле Аэропорт вылета")
    public void clickDepartureCity() {
        departureCity.click();
    }

    @Step("Выбираю аэропорт вылета")
    public void selectAirportOfDeparture() {
        searchField.click();
        WebElement searchFieldIsFocused = driver.findElement(By.id("ru.s7.android:id/search_src_text"));
        searchFieldIsFocused.clear();
        searchFieldIsFocused.sendKeys("led");
        WebElement airportOfDeparture = driver.findElement(By.id("ru.s7.android:id/originCity"));
        airportOfDeparture.click();
    }

    @Step("Тап в поле Аэропорт прилета")
    public void clickArrivalCity() {
        arrivalCity.click();
    }

    @Step("Выбираю аэропорт прилета")
    public void selectAirportOfArrival() {
        searchField.click();
        WebElement searchFieldIsFocused = driver.findElement(By.id("ru.s7.android:id/search_src_text"));
        searchFieldIsFocused.sendKeys("dme");
        WebElement airportOfDeparture = driver.findElement(By.id("ru.s7.android:id/originCity"));
        airportOfDeparture.click();
    }

    @Step("Тап в поле Дата вылета")
    public void clickDepartureDate() {
        AndroidElement departureDate = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + getMonthNameFormatMMM() + "')]"));
        departureDate.click();
        //departureDateField.click();
    }

    @Step("Задаю даты вылета и прилета")
    public void selectDepartureArrivalDates() {
        Dates dates = Dates.DAYS;
        dates.startTomorrow();
        dates.finishInWeek();
        doneBtnInCalendar.click();
    }
/*
    @Step("Нажимаю кнопку Найти")
    public void clickSearchBtn(){
        searchBtn.click();
    }*/

    @Step("Нажимаю кнопку Найти")
    public SelectCostAirTicketScreen clickSearchBtn() {
        searchBtn.click();
        return new SelectCostAirTicketScreen(driver);
    }

   /* @Step("Выбор билета")
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
        int i = addPassengerBtn.size();
        addPassengerBtn.get(i).click();
    }

    @Step("Выбираю способ оплаты")
    public void selectMethodOfPayment() {
        Waits waits = new Waits();
        if(waits.elementIsDispXPathLocator("//android.widget.TextView[@text='Оплатить сейчас']")){
            paymentTypePayNowBtn.click();
        }
        Swipes sp = new Swipes();
        sp.swipeUpToElement("//android.widget.RelativeLayout[@resource-id='ru.s7.android:id/btnChoosePaymentType']");
        methodsOfPaymentBtn.click();
        MobileElement mobileElement = methodsOfPaymentList.get(1);
        mobileElement.click();
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
        Swipes sp = new Swipes();
        sp.swipeUpToElement("//android.widget.Switch[@resource-id='ru.s7.android:id/agree']");
        sw.switchON(switchLocatorID);
    }

    @Step("Нажимаю кнопку Оплатить")
    public void tapPayBtn() {
        payBtn.click();
    }*/

    private static String getMonthNameFormatMMM() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM");
        LocalDateTime dateTime = LocalDateTime.now();
        String selectedReceiptDate = dateTime.format(formatter);
        //System.out.println("Test - " + selectedReceiptDate);
        return selectedReceiptDate;
    }

}

