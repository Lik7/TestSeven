package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Enter {
    private AppiumDriver driver;

    public Enter(AppiumDriver driver) {
        this.driver = driver;
    }

    //    private AppiumDriver driver = new BaseSetup().getDriver();

    //private WebElement loginField = driver.findElement(By.id("ru.s7.android:id/squareButtonsLayout"));
    //private WebElement loginField = (WebElement) driver.findElement(By.id("ru.s7.android:id/squareButtonsLayout"));
    private WebElement loginField = driver.findElement(By.id("ru.s7.android:id/squareButtonsLayout"));
    private WebElement loginFieldIsFocused = driver.findElement(By.id("ru.s7.android:id/etLogin"));
    private WebElement passwordField = driver.findElement(By.id("ru.s7.android:id/etPassword"));
    private WebElement passwordFieldIsFocused = driver.findElement(By.id("ru.s7.android:id/etPassword"));
    private WebElement enterBtn = driver.findElement(By.id("ru.s7.android:id/back"));


    public void enterLogin() {
        loginField.click();
        loginFieldIsFocused.sendKeys("123");
    }

    public void enterPassword() {
        passwordField.click();
        passwordFieldIsFocused.sendKeys("12345");
    }

    public void tapEnterBtn() {
        enterBtn.click();
    }

}
