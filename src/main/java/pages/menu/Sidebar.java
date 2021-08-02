package pages.menu;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static base.BaseSetup.setUpDriver;

public class Sidebar {
    //private AndroidDriver driver;
    private AndroidDriver driver = setUpDriver();

    private WebElement menuTransferBtn = driver.findElement(By.id("ru.s7.android:id/navTransfer"));//кнопка Меню - трансфер

    @Step ("Нажимаю кнопку Трансфер в боковом меню")
    public void clickMenuTransferBtn(){
        menuTransferBtn.click();
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }
}
