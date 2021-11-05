package helpers;

import base.Driver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

    private AndroidDriver driver = Driver.getDriver();


    //Ожидание нужного элемента
    public WebElement waitForElementPresent(By by, long timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeoutInSecond);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitElement(String xPathLocator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = 0;
        while (driver.findElements(By.xpath(xPathLocator)).size() == 0 && count < 2) {
            try {
                driver.manage().timeouts().wait(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++count;
        }
    }

    //проверка отображается ли элемент на экране
    public boolean elementIsDisp(String xPathLocator) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean b = true;
        if (driver.findElements(By.xpath(xPathLocator)).size() == 0) {
            b = false;
        }
        driver.manage().timeouts().implicitlyWait(Driver.getWaitSec(), TimeUnit.SECONDS);
        return b;
    }

}