package base;

import helpers.AllureScreenShooter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.util.FileUtils;
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
import static com.sun.deploy.cache.Cache.copyFile;
import static org.apache.logging.log4j.core.util.FileUtils.*;

@Listeners(AllureScreenShooter.class)

public class BaseTest {
    //protected AndroidDriver driver;
    protected AppiumDriver driver;
    protected HomeScreen homeScreen;

    @BeforeClass
    public void setUpDriver() {
        //AppiumServer.startServer();
        //AppiumServer.startServerCMD();
        //AppiumServerManager.stopServerCMD();
        AppiumServerManager.getAppiumLocalServer();
        driver = Driver.getDriver();
        homeScreen = new HomeScreen(driver);
        //driver.startRecordingScreen();
    }

    @AfterClass
    public void teardown() {
        sleep(3000);
        //driver.closeApp();
        //ControlApp.terminateApp();
        AppiumServerManager.stopServer();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            DateFormat dateFormat = new SimpleDateFormat("dd_MM-HH_mm_ss");
            Calendar cal = Calendar.getInstance();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
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

/* ОСТАНОВКА ПРИЛОЖЕНИЯ
    @Step("Terminate app")
    public AppDriver terminateApp() {
        Logger.log();
        String appID = null;
        if (driver != null) {
            try {
                if (driver instanceof AndroidDriver) {
                    appID = (String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE);
                } else if (driver instanceof IOSDriver) {
                    appID = String.valueOf(driver.getCapabilities().getCapability(IOSMobileCapabilityType.BUNDLE_ID));
                } else
                    Assert.fail(createAssertionLog("unknown driver type"));
                if (appID != null)
                    ((InteractsWithApps) driver).terminateApp(appID);
            } catch (Exception e) {
                Logger.logError(e.getMessage());
            }
        }
        return this;
    }
 */
