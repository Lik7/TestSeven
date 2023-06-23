package helpers;

import base.BaseTest;
import base.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class HideKeyboardIfVisible {
    private AppiumDriver driver = Driver.getDriver();

    private boolean isKeyboardShown;

    //метод закрывает клавиатуру если она открыта
    public void hideKeyboardIfVisible() {
        // isKeyboardShown = driver.isKeyboardShown();
        if (isKeyboardShown = true) {
            driver.navigate().back();
        }
    }
}
