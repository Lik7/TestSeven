package helpers;

import base.Driver;
import enums.Dates;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class DateSelected {

    private AndroidDriver driver = Driver.getDriver();
    Swipes swipe = new Swipes();

    private int todayDayInt = java.time.LocalDate.now().get(ChronoField.DAY_OF_MONTH); // число сегодня в int

    //метод в календаре выбирает начальную дату
    public void tapDayStartInCalendar(Integer CountDay) {
        String todayDayString = Integer.toString(todayDayInt + CountDay);//плюс дней от сегодня
        String xPathLocator = "//android.widget.TextView[@text=" + "'" + todayDayString + "'" + "]";
        //System.out.println("todayDayInt:" + todayDayInt);
        //System.out.println("todayDayString:" + todayDayString);
        swipe.swipeUpToElement(xPathLocator, 3, 300, 0.65, 0.4);

        WebElement startDate = driver.findElement(By.xpath(xPathLocator));
        startDate.click();
    }

    //метод в календаре выбирает конечную дату
    public void tapDayFinishInCalendar(Integer CountDay) {
        String todayDayString = Integer.toString(todayDayInt + CountDay);//плюс дней от сегодня
        String xPathLocator = "//android.widget.TextView[@text=" + "'" + todayDayString + "'" + "]";
        swipe.swipeUpToElement(xPathLocator, 3, 300, 0.65, 0.4);
        WebElement finishDate = driver.findElement(By.xpath(xPathLocator));
        if (!finishDate.isDisplayed()||!finishDate.isSelected()) {
            swipe.swipe(300, 0.65, 0.4);
        }
        finishDate.click();
    }

    //Метод добавляет n дней к текущей дате
    public Integer getDayOfMonthTodayPlusNDays(int n) {
        LocalDate todayDayPlusNDays = LocalDate.now().plusDays(n);
        int dayOfMonthTodayPlusNDays = todayDayPlusNDays.get(ChronoField.DAY_OF_MONTH);
        System.out.println(dayOfMonthTodayPlusNDays);
        return dayOfMonthTodayPlusNDays;
    }
}

