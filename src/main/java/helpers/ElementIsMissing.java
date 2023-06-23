package helpers;

import base.Driver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ElementIsMissing {
    private static AppiumDriver driver = Driver.getDriver();

    //возвращает true если элемент отображается, возвращает false если не отображается
    private static boolean elementIsDisp(String locator) {
        Driver.driverTimeout_1sec();
        boolean b = true;
        if (driver.findElements(By.xpath(locator)).size() == 0) {
            b = false;
        }
        Driver.driverTimeoutDefault();
        return b;
    }

    //возвращает true если текст есть на экране
    private static boolean checkShowText(String text) {
        boolean bool = true;
        if (!driver.getPageSource().contains(text)) {
            bool = false;
        }
        return bool;
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

    public static boolean textIsDisp(String text) {
        return checkShowText(text);
    }
}
//  wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.id("link"))));

/*
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        WebElement foo = wait.until(driver -> {
            return driver.findElement(By.xpath(xPathLocator));
        });
        wait.until(ExpectedConditions.visibilityOf(homeBottom));


                try {
            driver.getPageSource().contains(text);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
*/