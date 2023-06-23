package pages.rentalCar;

import enums.Days;
import helpers.DateSelected;
import helpers.HideKeyboardIfVisible;
import helpers.Swipes;
import helpers.Waits;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.temporal.ChronoField;
import java.util.List;

//import static base.BaseTest.setUpDriver;

public class RentalCarScreen {

    private AndroidDriver driver;

    public RentalCarScreen(AndroidDriver driver) {
        //this.driver = setUpDriver();
        this.driver = driver;
        //PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ru.s7.android:id/tvPickupLocation")
    private WebElement placeOfReceiptField;//поле Место получения

    @AndroidFindBy(id = "ru.s7.android:id/tvReturnLocation")
    private WebElement placeOfReturnField;//поле Место возврата

    @AndroidFindBy(id = "ru.s7.android:id/scReturnSamePlace")
    private WebElement returnInSamePlaceSwitch;//свич Возврат там же

    @AndroidFindBy(id = "ru.s7.android:id/tvPickUpDateLabel")
    private WebElement dateOfReceiptField;//поле Дата получения

    @AndroidFindBy(id = "ru.s7.android:id/etLocation")
    private WebElement searchFromField;//поле Откуда на экране выбора Локации

    @AndroidFindBy(id = "ru.s7.android:id/seekBar")
    private List<WebElement> slidersReceiptReturn;//слайдеры времени на экране календаря

    @AndroidFindBy(id = "ru.s7.android:id/btnSave")
    private WebElement selectBtn;//Кнопка Выбрать в календаре

    @AndroidFindBy(id = "ru.s7.android:id/rlBackground")
    private WebElement searchBtn;//Кнопка Найти на экране формы аренды авто

    @AndroidFindBy(id = "ru.s7.android:id/tvPickUpDate")
    private WebElement selectedReceiptDate;//для проверки: выбранная дата получения

    @AndroidFindBy(id = "ru.s7.android:id/tvPickUpTime")
    private WebElement selectedReceiptTime;//для проверки: выбранное время получения

    @AndroidFindBy(id = "ru.s7.android:id/tvDropOfDate")
    private WebElement selectedReturnDate;//для проверки: выбранная дата возврата

    @AndroidFindBy(id = "ru.s7.android:id/tvDropOfTime")
    private WebElement selectedReturnTime;//для проверки: выбранное время возврата

    @AndroidFindBy(id = "ru.s7.android:id/message")
    private WebElement messageDateNotSelected;//для проверки: выбранное время возврата

    private int todayDayInt = java.time.LocalDate.now().get(ChronoField.DAY_OF_MONTH); // число сегодня в int

    HideKeyboardIfVisible hideKeyboardIfVisible = new HideKeyboardIfVisible();
    DateSelected dateSelected = new DateSelected();

    @Step("Тап в поле Место получения")
    public void clickPlaceOfReceiptField() {
        placeOfReceiptField.click();
    }

    @Step("Ввод локации")
    public void enterFromLocation(String fromValue) {
        searchFromField.clear();
        searchFromField.sendKeys(fromValue);
        //driver.navigate().back();
        hideKeyboardIfVisible.hideKeyboardIfVisible();
        WebElement pointFromField = driver.findElement(By.xpath("//android.widget.TextView[@text='Пулково']"));
        pointFromField.click();
    }

    @Step("Тап в поле Дата получения")
    public void clickDateOfReceiptField() {
        dateOfReceiptField.click();
        //slidersReceiptReturn.get(0).isDisplayed();//тоже рабочий вариант
        Waits waits = new Waits();
        //waits.waitForElementPresent(By.id("ru.s7.android:id/seekBar"), 5);
    }

    @Step("Выбор даты получения")
    public void selectDateReceiptOfCar() {
        dateSelected.tapDayStartInCalendar(Days.TOMORROW);
    }

    @Step("Выбор даты возврата")
    public void selectDateReturnOfCar(Integer n) {
        dateSelected.tapDayFinishInCalendar(Days.IN_FIVE_DAYS);
    }

    @Step("Ввод времени получения")
    public void setTimeOfReceipt(String time) {
        slidersReceiptReturn.get(0).sendKeys(time);
    }

    @Step("Проверка отображения поп-ап, что дата не выбрана")
    public boolean checkMessageDateNotSelected() {
        return messageDateNotSelected.isDisplayed();
    }


    @Step("Нажимаю кнопку Выбрать в календаре")
    public void clickSelectBtn() {
        selectBtn.click();
    }

    @Step("Нажимаю кнопку Найти на экране формы аренды авто")
    public BuyOrBookCarScreen clickSearchBtn() {
        searchBtn.click();
        return new BuyOrBookCarScreen(driver);
    }

    public String getSelectedReceiptDate() {
        return selectedReceiptDate.getText();
    }

    public String getSelectedReceiptTime() {
        return selectedReceiptTime.getText();
    }

    public String getSelectedReturnDate() {
        return selectedReturnDate.getText();
    }

    public String getSelectedReturnTime() {
        return selectedReturnTime.getText();
    }

    public String getPlaceOfReceiptField() {
        return placeOfReceiptField.getText();
    }

}
