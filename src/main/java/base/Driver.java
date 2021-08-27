package base;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AndroidDriver driver;
    private static String url = "http://127.0.0.1:4723/wd/hub";

    private static void initDriver() {

        try {
            if (driver == null) {
                //url = new URL("http://127.0.0.1:4723/wd/hub");
                driver = new AndroidDriver(new URL(url), new Capabilities().getCapabilities());
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
}

