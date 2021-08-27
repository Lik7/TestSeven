package base;

import helpers.AllureScreenShooter;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomeScreen;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import static com.codeborne.selenide.Selenide.sleep;

@Listeners(AllureScreenShooter.class)

public class BaseTest {
    private  AndroidDriver driver;
    protected HomeScreen homeScreen;

    @BeforeClass
    public void setUpDriver() {
        AppiumServer.startServer();
        driver = Driver.getDriver();
        homeScreen = new HomeScreen(driver);
    }

    @AfterClass
    public  void teardown() {
        sleep(3000);
        driver.closeApp();
        AppiumServer.stopServer();
    }

    @AfterMethod
    public  void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            DateFormat dateFormat = new SimpleDateFormat("dd_MM-HH_mm_ss");
            Calendar cal = Calendar.getInstance();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + dateFormat.format(cal.getTime()) + ".png"));
        }
    }
}
