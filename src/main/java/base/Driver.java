package base;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    //private static AndroidDriver driver;
    private static AppiumDriver driver;
    private static String url = "http://127.0.0.1:4723/wd/hub";
    //private static String url = "http://127.0.0.1:4723/";
    private static long waitSec = 25;

    private static void initDriver() {
        try {
            if (driver == null) {
                driver = new AppiumDriver(new URL(url), new Capabilities().getCapabilities());
                driver.executeScript("plugin: setWaitTimeout", ImmutableMap.of("timeout", 60000 , "intervalBetweenAttempts", 1000 ));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSec));
            }
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AppiumDriver getDriver() {
        initDriver();
        return driver;
    }

    public static int getWaitSec() {
        return (int) waitSec;
    }

    public static AppiumDriver driverTimeout_1sec() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return driver;
    }
    public static AppiumDriver driverTimeoutDefault() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSec));
        return driver;
    }
}

