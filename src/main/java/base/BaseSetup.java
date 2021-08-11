package base;

import helpers.AllureScreenShooter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
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

import static com.codeborne.selenide.Selenide.sleep;

@Listeners(AllureScreenShooter.class)

public class BaseSetup {
    private static AndroidDriver driver = null;
    //private AppiumDriver<MobileElement> driver;
    //private static URL url;
    //protected static HomeScreen homeScreen;
    private static AppiumServer appiumServer = new AppiumServer();

    @BeforeClass
    public static AndroidDriver setUpDriver() {

        try {
            //AppiumServer appiumServer = new AppiumServer();
            //appiumServer.stopServer();

            if (!appiumServer.serverIsRunning()) {
                appiumServer.startServer();
            } else {
                System.out.println("Appium Server already running on Port: " + appiumServer.port);
            }

            if (driver == null) {
                //url = new URL("http://127.0.0.1:4723/wd/hub");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), new Capabilities().getCapabilities());
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    @AfterClass
    public void teardown() {
        sleep(3000);
        driver.closeApp();
        appiumServer.stopServer();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            DateFormat dateFormat = new SimpleDateFormat("dd_MM-HH_mm_ss");
            Calendar cal = Calendar.getInstance();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + dateFormat.format(cal.getTime()) + ".png"));
        }
    }
}
