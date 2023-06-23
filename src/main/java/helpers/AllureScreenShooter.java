package helpers;

import base.BaseTest;
import base.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для снятия скриншотов Allure.
 */
public class AllureScreenShooter extends ExitCodeListener {

    BaseTest bt = new BaseTest();
    public void onTestFailure(ITestResult testResult) {
        super.onTestFailure(testResult);
        //AndroidDriver driver = Driver.getDriver();
        AppiumDriver driver = Driver.getDriver();
        takePhoto(driver);
        logCaseStep(testResult);
        exceptedResult(testResult);
    }

    @Attachment(value = "Failed screenshots are as follows:", type = "image/png")
    public byte[] takePhoto(WebDriver driver) {
        byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screenshotAs;
    }

    /**
     * Print test steps
     *
     * @param testResult
     */
    //---*****---ПОКА НЕ ИСПОЛЬЗУЕТСЯ
    @Attachment(value = "The steps are as follows:")
    public String logCaseStep(ITestResult testResult) {
        String step = "steps";
        return step;
    }

    /**
     * Print test steps
     *
     * @param testResult
     */
    //---*****---ПОКА НЕ ИСПОЛЬЗУЕТСЯ
    @Attachment(value = "The expected result is as follows:")
    public String exceptedResult(ITestResult testResult) {
        String result = "Show query result";
        return result;
    }

    @Attachment(value = "Record video screen", type = "video/mp4")
    public static byte[] attachRecord(String mp4) {

        System.out.println("mp4 -->" + mp4);
        Path content = Paths.get(mp4);
        InputStream is = null;
        try {
            is = Files.newInputStream(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is2ByeteArray(is);
    }

    private static byte[] is2ByeteArray(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while (true) {
            try {
                if (!((rc = is.read(buff, 0, 100)) > 0)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            baos.write(buff, 0, rc);
        }
        return baos.toByteArray();
    }
}
