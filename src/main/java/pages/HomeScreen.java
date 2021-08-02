package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.menu.Sidebar;

import static base.BaseSetup.setUpDriver;

public class HomeScreen {
    //private AndroidDriver driver;
    private AndroidDriver driver = setUpDriver();

/*    public HomeScreen(AndroidDriver driver) {
        this.driver = driver;
    }*/

    //driver = new BaseSetup().setUpDriver();
    /*public LogIn(AndroidDriver driver) {
        this.driver = driver;
    }*/

    //private WebElement enterBtn = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView"));
    //private WebElement enterBtn = driver.findElement(By.id("ru.s7.android:id/btnProfile"));//кнопка Войти
    private WebElement menuBtn = driver.findElement(By.className("android.widget.ImageButton"));//кнопка Меню

        @Step("Нажимаю кнопку Боковое меню")
        public void clickMenuBtn() {
            menuBtn.click();
        }
/*    @Step("Нажимаю кнопку Боковое меню")
    public Sidebar clickMenuBtn() {
        menuBtn.click();
        return new Sidebar(driver);
    }*/

    public AndroidDriver getDriver() {
        return driver;
    }
}