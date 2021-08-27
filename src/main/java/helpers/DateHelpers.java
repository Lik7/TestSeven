package helpers;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class DateHelpers {

    //Метод добавляет n дней к текущей дате
    public Integer getDayOfMonthTodayPlusNDays(int n) {
        LocalDate todayDayPlusNDays = LocalDate.now().plusDays(n);
        int dayOfMonthTodayPlusNDays = todayDayPlusNDays.get(ChronoField.DAY_OF_MONTH);
        System.out.println(dayOfMonthTodayPlusNDays);
        return dayOfMonthTodayPlusNDays;
    }
}

