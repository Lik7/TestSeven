package base;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AndroidDriver driver;
    private static String url = "http://127.0.0.1:4723/wd/hub";
    private static int waitSec = 45;

    private static void initDriver() {
        try {
            if (driver == null) {
                driver = new AndroidDriver(new URL(url), new Capabilities().getCapabilities());
                driver.manage().timeouts().implicitlyWait(waitSec, TimeUnit.SECONDS);
            }
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver getDriver() {
        initDriver();
        return driver;
    }

    public static int getWaitSec() {
        return waitSec;
    }

    public static AndroidDriver driverTimeout_1sec() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return driver;
    }
    public static AndroidDriver driverTimeoutDefault() {
        driver.manage().timeouts().implicitlyWait(waitSec, TimeUnit.SECONDS);
        return driver;
    }
}

