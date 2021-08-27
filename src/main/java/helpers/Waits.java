package helpers;

import base.BaseTest;
import base.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    //Ожидание нужного элемента
    public WebElement waitForElementPresent(By by, long timeoutInSecond) {
//        WebDriverWait wait = new WebDriverWait(BaseTest.setUpDriver(), timeoutInSecond);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeoutInSecond);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
