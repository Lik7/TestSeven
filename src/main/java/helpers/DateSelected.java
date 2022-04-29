package helpers;

import base.BaseScreen;
import enums.Days;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;

public class DateSelected extends BaseScreen {

    @AndroidFindBy(id = "ru.s7.android:id/iv_calendar_item_icon")
    private List<MobileElement> selectedDateIcon;

    //метод в календаре выбирает начальную дату
    public void tapDayStartInCalendar(Days days) {
        String todayDayString = Integer.toString(getDayOfMonthTodayPlusNDays(days.getDay()));//плюс дней от сегодня
        String xPathLocator = "//android.widget.TextView[@text=" + "'" + todayDayString + "'" + "]";

        System.out.println("День выезда, выбранная в календаре: " + todayDayString);
        WebElement startDate = driver.findElement(By.xpath(xPathLocator));
        startDate.click();
    }

    //метод в календаре выбирает конечную дату
    public void tapDayFinishInCalendar(Days days) {
        String todayDayString = Integer.toString(getDayOfMonthTodayPlusNDays(days.getDay()));//плюс дней от сегодня
        String xPathLocator = "//android.widget.TextView[@text=" + "'" + todayDayString + "'" + "]";

        System.out.println("День возврата, выбранная в календаре: " + todayDayString);
        if (selectedDateIcon.size() == 1) {
            swipe.swipeDown();
            WebElement finishDate = driver.findElement(By.xpath(xPathLocator));
            finishDate.click();
        }
    }

    //Метод добавляет n дней к текущей дате и возвращает число день месяца
    private Integer getDayOfMonthTodayPlusNDays(int n) {
        LocalDate todayDayPlusNDays = LocalDate.now().plusDays(n);
        int dayOfMonthTodayPlusNDays = todayDayPlusNDays.get(ChronoField.DAY_OF_MONTH);
        //System.out.println("День из метода dayOfMonthTodayPlusNDays :" + dayOfMonthTodayPlusNDays);
        return dayOfMonthTodayPlusNDays;
    }

}

