package pages.menu;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static base.BaseSetup.setUpDriver;

public class Sidebar {
    //private AndroidDriver driver;
    private AndroidDriver driver = setUpDriver();

    private WebElement menuTransferBtn = driver.findElement(MobileBy.id("ru.s7.android:id/navTransfer"));//кнопка Меню - трансфер
    private WebElement menuAutoBtn = driver.findElement(MobileBy.id("ru.s7.android:id/navAuto"));//кнопка Меню - авто

    @Step ("Нажимаю кнопку Трансфер в боковом меню")
    public void clickMenuTransferBtn(){
        menuTransferBtn.click();
    }

    @Step ("Нажимаю кнопку Трансфер в боковом меню")
    public void clickMenuAutoBtn(){
        menuAutoBtn.click();
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }
}
