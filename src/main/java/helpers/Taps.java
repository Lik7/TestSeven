package helpers;

import base.BaseSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import static base.BaseSetup.setUpDriver;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Taps {

    //private AppiumDriver<MobileElement> driver;
    private AndroidDriver driver = setUpDriver();

    private int x = driver.manage().window().getSize().getWidth();//ширина экрана
    private int y = driver.manage().window().getSize().getHeight();//высота экрана

    //тап по координатами в процентах от ширины\высоты экрана
    public void tap(int xx, int yy) {

        new TouchAction(driver)
                .press(point(x / xx, y / yy))
                .release()
                .perform();
    }
}
