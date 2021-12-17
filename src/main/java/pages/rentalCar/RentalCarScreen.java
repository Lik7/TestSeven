package pages.rentalCar;

import helpers.DateSelected;
import helpers.HideKeyboardIfVisible;
import helpers.Swipes;
import helpers.Waits;
import io.appium.java_client.MobileElement;
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
    private MobileElement placeOfReceiptField;//поле Место получения

    @AndroidFindBy(id = "ru.s7.android:id/tvReturnLocation")
    private MobileElement placeOfReturnField;//поле Место возврата

    @AndroidFindBy(id = "ru.s7.android:id/scReturnSamePlace")
    private MobileElement returnInSamePlaceSwitch;//свич Возврат там же

    @AndroidFindBy(id = "ru.s7.android:id/tvPickUpDateLabel")
    private MobileElement dateOfReceiptField;//поле Дата получения

    @AndroidFindBy(id = "ru.s7.android:id/etLocation")
    private MobileElement searchFromField;//поле Откуда на экране выбора Локации

    @AndroidFindBy(id = "ru.s7.android:id/seekBar")
    private List<MobileElement> slidersReceiptReturn;//слайдеры времени на экране календаря

    @AndroidFindBy(id = "ru.s7.android:id/btnSave")
    private MobileElement selectBtn;//Кнопка Выбрать в календаре

    @AndroidFindBy(id = "ru.s7.android:id/rlBackground")
    private MobileElement searchBtn;//Кнопка Найти на экране формы аренды авто

    @AndroidFindBy(id = "ru.s7.android:id/tvPickUpDate")
    private MobileElement selectedReceiptDate;//для проверки: выбранная дата получения

    @AndroidFindBy(id = "ru.s7.android:id/tvPickUpTime")
    private MobileElement selectedReceiptTime;//для проверки: выбранное время получения

    @AndroidFindBy(id = "ru.s7.android:id/tvDropOfDate")
    private MobileElement selectedReturnDate;//для проверки: выбранная дата возврата

    @AndroidFindBy(id = "ru.s7.android:id/tvDropOfTime")
    private MobileElement selectedReturnTime;//для проверки: выбранное время возврата

    @AndroidFindBy(id = "ru.s7.android:id/message")
    private MobileElement messageDateNotSelected;//для проверки: выбранное время возврата

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
        waits.waitForElementPresent(By.id("ru.s7.android:id/seekBar"), 5);
    }

    @Step("Выбор даты получения")
    public void selectDateReceiptOfCar() {
        dateSelected.tapDayStartInCalendar(0);
    }

    @Step("Выбор даты возврата")
    public void selectDateReturnOfCar(Integer n) {
        dateSelected.tapDayFinishInCalendar(n);
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
