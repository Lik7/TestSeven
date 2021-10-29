package enums;

import base.Driver;
import helpers.DateSelected;
import helpers.Swipes;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.temporal.ChronoField;

public enum Dates {
    DAYS(0, 1, 5,7);

    private int today;
    private int tomorrow;
    private int addFiveDays;
    private int inWeek;

    Dates(int today, int tomorrow, int addFiveDays, int inWeek) {
        this.today = today;
        this.tomorrow = tomorrow;
        this.addFiveDays = addFiveDays;
        this.inWeek = inWeek;
    }

    public int today() {
        return today;
    }

    public int tomorrow() {
        return tomorrow;
    }

    public int addFiveDays() {
        return addFiveDays;
    }

    public int getInWeek() {
        return inWeek;
    }


}
