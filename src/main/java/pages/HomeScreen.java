package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.menu.Sidebar;

import static java.lang.Thread.sleep;


public class HomeScreen {
    private AndroidDriver driver;

    public HomeScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(className = "android.widget.ImageButton")
    private MobileElement menuBtn;//кнопка Меню

    @AndroidFindBy(className = "android.widget.ImageButton")
    private MobileElement nameTitle;//имя в боковом меню

    @Step("Нажимаю кнопку Боковое меню")
    public Sidebar clickMenuBtn() {

        menuBtn.click();
        try {
            if (!nameTitle.isDisplayed()) {
                sleep(2000);
                menuBtn.click();
            }
        } catch (Exception e) {

        }
        return new Sidebar(driver);
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}