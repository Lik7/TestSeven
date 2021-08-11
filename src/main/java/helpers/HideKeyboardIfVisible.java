package helpers;

import base.BaseSetup;
import io.appium.java_client.android.AndroidDriver;

public class HideKeyboardIfVisible {
    private AndroidDriver driver= BaseSetup.setUpDriver();

    private boolean isKeyboardShown;

    //метод закрывает клавиатуру если она открыта
    public void hideKeyboardIfVisible() {
        isKeyboardShown = driver.isKeyboardShown();
        if (isKeyboardShown = true) {
            //driver.navigate().back();
            driver.hideKeyboard();
        }
    }
}
