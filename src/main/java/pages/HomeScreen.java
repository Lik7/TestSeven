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

    @Step("Нажимаю кнопку Боковое меню")
    public Sidebar clickMenuBtn() {
      /*  try {
            sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean b = menuBtn.isDisplayed();
        System.out.println(b);
        if(!menuBtn.isDisplayed()){
            driver.navigate().back();
        }*/
        menuBtn.click();
        return new Sidebar(driver);
    }
}