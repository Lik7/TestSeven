package pages;

import helpers.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.menu.Sidebar;
import pages.myBooking.DetailSpecBookingScreen;

import static java.lang.Thread.sleep;


public class HomeScreen {
    private AndroidDriver driver;

    public HomeScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //@AndroidFindBy(className = "android.widget.ImageButton")
    //private MobileElement menuBtn;//кнопка Меню

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    private MobileElement menuBtn;//кнопка Меню

    @AndroidFindBy(className = "android.widget.ImageButton")
    private MobileElement nameTitle;//имя в боковом меню

    @AndroidFindBy(id = "ru.s7.android:id/design_menu_item_text")
    private MobileElement menuEl;//элемент меню для проверки открыто ли уже меню

    //Waits wait = new Waits();

    @Step("Нажимаю кнопку Боковое меню")
    public Sidebar clickMenuBtn() {
        try {
            sleep(2000);
            //if (!wait.elementIsDispClassName("android.widget.ImageButton")) {
            if (!Waits.elementIsDispXPathLocator("//android.widget.ImageButton[@content-desc='Open navigation drawer']")) {
                driver.navigate().back();
            }
            menuBtn.click();

            if (!Waits.elementIsDispIDLocator("ru.s7.android:id/design_menu_item_text")) {
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