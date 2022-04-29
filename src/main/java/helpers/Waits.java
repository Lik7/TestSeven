package helpers;

import base.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

    private static AndroidDriver driver = Driver.getDriver();

    //Ожидание нужного элемента
    /*public WebElement waitForElementPresent(By by, long timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeoutInSecond);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }*/

    public static void
    waitForElementPresent(String xPathLocator, long timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeoutInSecond);
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

    //возвращает true если элемент отображается, возвращает false если не отображается
    private static boolean elementIsDisp(String locator) {
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Driver.driverTimeout_1sec();
        boolean b = true;
        if (driver.findElements(By.xpath(locator)).size() == 0) {
            b = false;
        }
        //driver.manage().timeouts().implicitlyWait(Driver.getWaitSec(), TimeUnit.SECONDS);
        Driver.driverTimeoutDefault();
        return b;
    }

    //проверка отображается ли элемент на экране через xPath локатор
    public static boolean elementIsDispXPathLocator(String xPathLocator) {
        return elementIsDisp(xPathLocator);
    }

    //проверка отображается ли элемент на экране через ID локатор
    public static boolean elementIsDispIDLocator(String idLocator) {
        return elementIsDisp("//*[@resource-id='" + idLocator + "']");
    }

    //проверка отображается ли элемент на экране через ClassName локатор
    public static boolean elementIsDispClassName(String classNameLocator) {
        return elementIsDisp(classNameLocator);
    }

}