package pages.home;

import base.BaseScreen;
import base.Driver;
import helpers.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.myBooking.DetailOfBookingScreen;

import static java.lang.Thread.sleep;


public class HomeScreen extends BaseScreen {

    //@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    //private MobileElement menuBtn;//кнопка Меню

    @AndroidFindBy(className = "android.widget.ImageButton")
    private MobileElement nameTitle;//имя в боковом меню

    @AndroidFindBy(id = "ru.s7.android:id/design_menu_item_text")
    private MobileElement menuEl;//элемент меню для проверки открыто ли уже меню

    @AndroidFindBy(id = "ru.s7.android:id/tvDestination")
    private MobileElement cityInBookingCard; //поле с названием города в карточке брони

    //Waits wait = new Waits();

/*    @Step("Нажимаю кнопку Боковое меню")
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
    }*/

    @Step("Перехожу на экран деталей брони")
    public DetailOfBookingScreen clickCityInBookingCard() {
        try {
            sleep(8000);
            //if (!wait.elementIsDispClassName("android.widget.ImageButton")) {
//            if (!Waits.elementIsDispXPathLocator("//android.widget.ImageButton[@content-desc='Open navigation drawer']")) {
//                driver.navigate().back();
//            }
            driver.navigate().back();
            cityInBookingCard.click();

            /*if (!Waits.elementIsDispIDLocator("ru.s7.android:id/design_menu_item_text")) {
                cityInBookingCard.click();
            }*/
        } catch (Exception e) {

        }
        return new DetailOfBookingScreen(driver);
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    //public class BottomNavigationMenu {

    @AndroidFindBy(id = "ru.s7.android:id/page_1")
    private MobileElement homeBottom;//кнопка Главная

    @AndroidFindBy(id = "ru.s7.android:id/page_2")
    private MobileElement tripsBottom;//кнопка Путешествия

    @AndroidFindBy(id = "ru.s7.android:id/page_3")
    private MobileElement buyBottom;//кнопка Купить

    @AndroidFindBy(id = "ru.s7.android:id/page_4")
    private MobileElement messagesBottom;//кнопка Сообщения

    @AndroidFindBy(id = "ru.s7.android:id/page_5")
    private MobileElement profileBottom;//кнопка Профиль

    private String generalTitle = "//android.widget.TextView[@text=\"Главная\"]";

    @Step("Нажимаю кнопку Главная")
    public void clickHomeBottom() {
        waitGeneralTitleIsVisible();
        homeBottom.click();
    }

    @Step("Нажимаю кнопку Путешествия")
    public void clickTripsBottom() {
        checkVisibleElement();
        //waitGeneralTitleIsVisible();
        tripsBottom.click();
    }

    @Step("Нажимаю кнопку Купить")
    public void clickBuyBottom() {
        checkVisibleElement();
        //waitGeneralTitleIsVisible();

/*        try {
            sleep(27000);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        buyBottom.click();
    }

    @Step("Нажимаю кнопку Сообщения")
    public void clickMessagesBottom() {
        waitGeneralTitleIsVisible();
        messagesBottom.click();
    }

    @Step("Нажимаю кнопку Профиль")
    public void clickProfileBottom() {
        waitGeneralTitleIsVisible();
        profileBottom.click();
    }

    private void waitGeneralTitleIsVisible() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);
        wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(generalTitle), false));
    }

    //ПЕРЕДЕЛАТЬ НОРМАЛЬНО
    private void checkVisibleElement() {
        int i = 0;
        while (i < 3) {
            try {
                sleep(25000);
                if (Waits.elementIsDispXPathLocator(generalTitle)) {
                    return;
                } else {
                    sleep(3000);
                    driver.navigate().back();
                }
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //}
}