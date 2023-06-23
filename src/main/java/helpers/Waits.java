package helpers;

import base.Driver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Waits {

    //private static AndroidDriver driver = Driver.getDriver();
    private static AppiumDriver driver = Driver.getDriver();

    //Ожидание нужного элемента
    /*public WebElement waitForElementPresent(By by, long timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeoutInSecond);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }*/

    public static void
    waitForElementPresent(String xPathLocator, long timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutInSecond));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPathLocator)));
    }

    //Ожидание нужного элемента
    public void waitElement(String xPathLocator) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        int count = 0;
        int i = 5;
        while (driver.findElements(By.xpath(xPathLocator)).size() == 0 && count < i) {
            try {
                driver.manage().timeouts().wait(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++count;
        }
        if (count == i) {
            System.out.println("Элемент " + xPathLocator + " не найден");
        }
        driver.manage().timeouts().implicitlyWait(Driver.getWaitSec(), TimeUnit.SECONDS);
    }

    // Ожидание исчезновения элемента в секундах с заданным текстом
    public static void waitMissingElementWitchText(String text, Integer sec) {
        int i = sec * 2;

        while (ElementIsMissing.textIsDisp(text) && i > 0) {
            try {
                sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            i--;
        }

    }
}

//RemoteWebElement carousel = (RemoteWebElement) wait.until(presenceOfElementLocated(AppiumBy.accessibilityId("Carousel")));