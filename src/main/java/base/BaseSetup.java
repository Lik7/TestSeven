package base;

import helpers.AllureScreenShooter;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@Listeners(AllureScreenShooter.class)

public class BaseSetup {
    private static AndroidDriver driver = null;
    //private AppiumDriver<MobileElement> driver;
    //private static URL url;
    //protected static HomeScreen homeScreen;

    @BeforeClass
    public static AndroidDriver setUpDriver() {
        //public void setUpDriver() {
        try {
            if (driver == null) {
                //url = new URL("http://127.0.0.1:4723/wd/hub");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), new Capabilities().getCapabilities());
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                //homeScreen = new HomeScreen(driver);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

/*    @BeforeMethod
    public void goHome() {
        homeScreen = new HomeScreen(driver);
        //driver.get(link);
    }*/

    @AfterClass
    public void teardown() {
        driver.closeApp();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
            Calendar cal = Calendar.getInstance();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + dateFormat.format(cal.getTime()) + ".png"));
        }
    }
}
