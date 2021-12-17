package pages;

import helpers.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.menu.Sidebar;
import pages.myBooking.DetailOfBookingScreen;

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

    @AndroidFindBy(id = "ru.s7.android:id/tvDestination")
    private MobileElement cityInBookingCard; //поле с названием города в карточке брони

    //Waits wait = new Waits();

    @Step("Нажимаю кнопку Боковое меню")
    public Sidebar clickMenuBtn() {
        try {
            sleep(3000);
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

    @Step("Перехожу на экран деталей брони")
    public DetailOfBookingScreen clickCityInBookingCard() {
        try {
            sleep(2000);
            //if (!wait.elementIsDispClassName("android.widget.ImageButton")) {
            if (!Waits.elementIsDispXPathLocator("//android.widget.ImageButton[@content-desc='Open navigation drawer']")) {
                driver.navigate().back();
            }
            cityInBookingCard.click();

            /*if (!Waits.elementIsDispIDLocator("ru.s7.android:id/design_menu_item_text")) {
                cityInBookingCard.click();
            }*/
        } catch (Exception e) {

        }
        //cityInBookingCard.click();
        return new DetailOfBookingScreen(driver);
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}