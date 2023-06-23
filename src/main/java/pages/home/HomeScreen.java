package pages.home;

import base.BaseScreen;
import helpers.ElementIsMissing;
import helpers.Waits;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.myBooking.DetailOfBookingScreen;

import java.time.Duration;

import static java.lang.Thread.sleep;


public class HomeScreen extends BaseScreen {
    private static AppiumDriver driver;

    public HomeScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    //@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    //private WebElement menuBtn;//кнопка Меню

   /* @AndroidFindBy(className = "android.widget.ImageButton")
    private WebElement nameTitle;//имя в боковом меню

    @AndroidFindBy(id = "ru.s7.android:id/design_menu_item_text")
    private WebElement menuEl;//элемент меню для проверки открыто ли уже меню

    @AndroidFindBy(id = "ru.s7.android:id/tvDestination")
    private WebElement cityInBookingCard; //поле с названием города в карточке брони*/

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
            //cityInBookingCard.click();

            /*if (!Waits.elementIsDispIDLocator("ru.s7.android:id/design_menu_item_text")) {
                cityInBookingCard.click();
            }*/
        } catch (Exception e) {

        }
        return new DetailOfBookingScreen((AndroidDriver) driver);
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    @AndroidFindBy(id = "ru.s7.android:id/page_1")
    private static WebElement homeBottom;//кнопка Главная

    @AndroidFindBy(id = "ru.s7.android:id/page_2")
    private WebElement tripsBottom;//кнопка Путешествия

    //@AndroidFindBy(id = "ru.s7.android:id/page_3")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Купить\"]")
    private WebElement buyBottom;//кнопка Купить

    @AndroidFindBy(id = "ru.s7.android:id/page_4")
    private WebElement messagesBottom;//кнопка Помощник

    @AndroidFindBy(id = "ru.s7.android:id/page_5")
    private WebElement profileBottom;//кнопка Профиль

    private String generalTitle = "//android.widget.TextView[@text=\"Главная\"]";

    @Step("Нажимаю кнопку Главная")
    public void clickHomeBottom() {
        waitGeneralTitleIsVisible();
        homeBottom.click();
    }

    @Step("Нажимаю кнопку Путешествия")
    public void clickTripsBottom() {
        //checkVisibleElement(buyBottom);
        //waitGeneralTitleIsVisible();
        tripsBottom.click();
    }

    @Step("Нажимаю кнопку Купить")
    public void clickBuyBottom() {
        Waits.waitMissingElementWitchText("Главная", 10);
        driver.navigate().back();
        //checkVisibleElement("//android.widget.TextView[@text=\"Главная\"]");
        buyBottom.click();
    }

    @Step("Нажимаю кнопку Помощник")
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(generalTitle), false));

        //wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(By.id("link"))));
    }

    private static void checkVisibleElement(String str) {
       do {
           try {
            sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
       } while (ElementIsMissing.textIsDisp("Главная"));




        if (!ElementIsMissing.textIsDisp(str)){
            driver.navigate().back();
        }

       /* if (ElementIsMissing.elementIsDispXPathLocator(xPathLocator)) {
            driver.navigate().back();
        }*/
    }

    //int i = 0;
        /*while (i < 3) {
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
        }*/
}
