package helpers;

import base.BaseSetup;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

/**
 * Класс для снятия скриншотов Allure.
 */
public class AllureScreenShooter extends ExitCodeListener {

    public void onTestFailure(ITestResult testResult) {
        super.onTestFailure(testResult);
        BaseSetup bt = (BaseSetup) testResult.getInstance();
        //WebDriver driver = bt.setUpDriver();
        AndroidDriver driver = bt.setUpDriver();
        takePhoto(driver);
        //logCaseStep(testResult);
        //exceptedResult(testResult);
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
}