package base;

import helpers.AllureScreenShooter;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.home.HomeScreen;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import static com.codeborne.selenide.Selenide.sleep;

@Listeners(AllureScreenShooter.class)

public class BaseTest extends BaseScreen{
    private AndroidDriver driver;
    protected HomeScreen homeScreen;

    @BeforeClass
    public void setUpDriver() {
        AppiumServer.startServer();
       // driver = Driver.getDriver();
        //homeScreen = new HomeScreen(driver);
        driver.startRecordingScreen();
    }

    @AfterClass
    public void teardown() {
        sleep(3000);
        driver.closeApp();
        AppiumServer.stopServer();
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

/*    @AfterMethod
    public void recVideo(ITestResult testResult) throws IOException {
        String video = driver.stopRecordingScreen();
        DateFormat dateFormat = new SimpleDateFormat("dd_MM-HH_mm");
        Calendar cal = Calendar.getInstance();
        byte[] decode = Base64.getDecoder().decode(video);
        FileUtils.writeByteArrayToFile(new File("videoRecTests\\" + testResult.getName() + "-" + dateFormat.format(cal.getTime()) + ".mp4"), decode);
        String mp4 = "videoRecTests\\" + testResult.getName() + "-" + dateFormat.format(cal.getTime()) + ".mp4";
        AllureScreenShooter.attachRecord(mp4);
    }*/
}
