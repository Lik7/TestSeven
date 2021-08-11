package pages.rentalCar;

import helpers.HideKeyboardIfVisible;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static base.BaseSetup.setUpDriver;

public class RentalCar {

    private AndroidDriver driver;

    public RentalCar(AndroidDriver driver) {
        this.driver = setUpDriver();
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
    private MobileElement selectBtn;

    @AndroidFindBy(id = "ru.s7.android:id/tvPickUpDate")
    private MobileElement selectedReceiptDate;//для проверки: выбранная дата получения

    @AndroidFindBy(id = "ru.s7.android:id/tvPickUpTime")
    private MobileElement selectedReceiptTime;//для проверки: выбранное время получения

    @AndroidFindBy(id = "ru.s7.android:id/tvDropOfDate")
    private MobileElement selectedReturnDate;//для проверки: выбранная дата возврата

    @AndroidFindBy(id = "ru.s7.android:id/tvDropOfTime")
    private MobileElement selectedReturnTime;//для проверки: выбранное время возврата

    private int todayDayInt;
    //private String todayDayString = Integer.toString(todayDayInt);

    HideKeyboardIfVisible hideKeyboardIfVisible = new HideKeyboardIfVisible();

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
    }

    @Step("Выбор даты получения")
    public void selectDateReceiptOfCar() {
        getTodayDateDay();
        String todayDayString = Integer.toString(todayDayInt);
        //System.out.println("todayDayInt:" + todayDayInt);
        //System.out.println("todayDayString:" + todayDayString);
        WebElement startDate = driver.findElement(By.xpath("//android.widget.TextView[@text=" + "'" + todayDayString + "'" + "]"));
        startDate.click();
    }

    @Step("Выбор даты возврата")
    public void selectDateReturnOfCar() {
        int daysInCurrentMonth = java.time.LocalDate.now().lengthOfMonth();//кол-во дней в тек. месяце
        getTodayDateDay();
        if (todayDayInt == daysInCurrentMonth) {
            todayDayInt = 1;
        } else todayDayInt += 1;
        String todayDayString = Integer.toString(todayDayInt);
        WebElement finishDate = driver.findElement(By.xpath("//android.widget.TextView[@text=" + "'" + todayDayString + "'" + "]"));
        finishDate.click();
    }

    @Step("Ввод времени получения")
    public void setTimeOfReceipt(String time) {
        slidersReceiptReturn.get(0).sendKeys(time);
    }

    @Step("Нажимаю кнопку Выбрать в календаре")
    public void clickSelectBtn(){
        selectBtn.click();
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


    private Integer getTodayDateDay() {
        DateFormat dateFormat = new SimpleDateFormat("d");
        Calendar cal = Calendar.getInstance();
        return todayDayInt = Integer.parseInt(dateFormat.format(cal.getTime()));
    }

}