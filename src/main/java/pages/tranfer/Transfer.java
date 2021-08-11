package pages.tranfer;

import helpers.HideKeyboardIfVisible;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static base.BaseSetup.setUpDriver;
import static com.codeborne.selenide.Selenide.sleep;

public class Transfer {
    //private final Logger logger = LoggerFactory.getLogger(Transfer.class);//*****-----РАЗОБРАТЬСЯ КАК ИСПОЛЬЗОВАТЬ
    static final Logger logger = LogManager.getLogger(Transfer.class);


    private AndroidDriver driver;

    public Transfer(AndroidDriver driver) {
        this.driver = setUpDriver();
        //PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "ru.s7.android:id/etStartPlace")
    private MobileElement fromField;//поле Откуда на экране с картой

    @AndroidFindBy(id = "ru.s7.android:id/etFinishPlace")
    private AndroidElement whereField;//поле Куда на экране с картой

    @AndroidFindBy(id = "ru.s7.android:id/rlBackground")
    private AndroidElement searchTransferBtn;//кнопка Выбрать трансфер в модалке с описанием трансфера

    @AndroidFindBy(id = "ru.s7.android:id/btnClose")
    private AndroidElement closeBtn;//кнопка Закрыть в блоке примера маршрута

    @AndroidFindBy(id = "ru.s7.android:id/etValue")
    private List<AndroidElement> searchField;//поля поиска в окне ввода адреса

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Карта Google']/android.view.View")
    private List<AndroidElement> pingsOnMap;//кол-во пингов на карте

  /*@AndroidFindBy(className = "UIAKeyboard")
    private AndroidElement keyboard;*/

    private boolean isKeyboardShown;

    HideKeyboardIfVisible hideKeyboardIfVisible = new HideKeyboardIfVisible();

    @Step("Нажимаю кнопку Выбрать трансфер в окне описания трансфера")
    public void clickSelectTransferBtn() {
        logger.info("Start method clickSelectTransferBtn");
        if (searchTransferBtn.isDisplayed()) {
            searchTransferBtn.click();
        }
    }

    @Step("Тап в поле Откуда")
    public void clickInFromField() {
        if (closeBtn.isDisplayed()) {
            closeBtn.click();//закрываем ИнфоБлок над блоком откуда\куда
        }
        fromField.click();
    }

    @Step("Тап в поле Куда")
    public void clickInWhereField() {
        whereField.click();
    }

    @Step("Заполняю поле Откуда")
    public void enterFromField(String fromValue) {
        searchField.get(0).clear();
        searchField.get(0).sendKeys(fromValue);
        //driver.navigate().back();
        hideKeyboardIfVisible.hideKeyboardIfVisible();
        WebElement pointFromField = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Pulkovo Airport (LED)\"]"));
        pointFromField.click();
    }

    @Step("Заполняю поле Куда")
    public void enterWhereField(String whereValue) {
        searchField.get(1).sendKeys(whereValue);
        //driver.navigate().back();
        hideKeyboardIfVisible.hideKeyboardIfVisible();
        WebElement pointWhereField = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Nevsky prospect\"]"));
        pointWhereField.click();
    }

    @Step("Количество пингов на карте")
    public int getCountOfPingsOnMap() {
        //if нужен для ожидания отработки анимации
        if (pingsOnMap.size() != 2) {
            sleep(2000);
        }
        return pingsOnMap.size();
    }

    //метод закрывает клавиатуру если она открыта
   /* private void hideKeyboardIfVisible() {
        isKeyboardShown = driver.isKeyboardShown();
        if (isKeyboardShown = true) {
            //driver.navigate().back();
            driver.hideKeyboard();
        }
    }*/


/* @FindBy(how=How.NAME, using="username")
private WebElement user_name;*/
    //***********************************Экран Трансфер с картой
    //private AndroidDriver driver = setUpDriver();

/*    public Transfer(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }*/

/*    private WebElement selectTransferBtn = driver.findElement(By.id("ru.s7.android:id/btnContainer"));//кнопка Выбрать трансфер / Найти трансфер
    private WebElement fromField = driver.findElement(By.id("ru.s7.android:id/etStartPlace"));//поле Откуда
    private WebElement whereField = driver.findElement(By.id("ru.s7.android:id/etFinishPlace"));//поле Куда

    @Step("Тап в поле Откуда")
    public void clickInFromField() {
        WebElement closeBtn = driver.findElement(By.id("ru.s7.android:id/btnClose"));//закрываем ИнфоБлок над блоком откуда\куда
        closeBtn.click();//закрываем ИнфоБлок над блоком откуда\куда
        fromField.click();
    }

    @Step("Тап в поле Куда")
    public void clickWhereField() {
        whereField.click();
    }

    @Step("Количество пингов на карте")
    public int getCountOfPingsOnMap() {
        List<MobileElement> pingsOnMap = driver.findElements(By.xpath("//android.view.View[@content-desc='Карта Google']/android.view.View"));//пинги на карте
        return pingsOnMap.size();
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    //****************************************       Модалка для ввода откуда\куда на экране Трансфер с картой

    public class SearchTransfer {
        private AndroidDriver driver = setUpDriver();


        private List<MobileElement> searchField = driver.findElements(By.id("ru.s7.android:id/etValue"));

        @Step("Заполняю поле Откуда")
        public void enterFromField(String fromValue) {
            searchField.get(0).clear();
            searchField.get(0).sendKeys(fromValue);
            driver.navigate().back();
            WebElement pointFromField = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Pulkovo Airport (LED)\"]"));
            pointFromField.click();
        }

        @Step("Заполняю поле Куда")
        public void enterWhereField(String whereValue) {
            searchField.get(1).sendKeys(whereValue);
            driver.navigate().back();
            WebElement pointWhereField = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Nevsky prospect\"]"));
            pointWhereField.click();
        }

        public AppiumDriver<MobileElement> getDriver() {
            return driver;
        }
    }

    //***********************---- Экран с мод. окном с описание трансфера
    public static class InfoWindow {
        private AndroidDriver driver = setUpDriver();
        private WebElement searchTransferBtn = driver.findElement(By.id("ru.s7.android:id/rlBackground"));//Кнопка Выбрать трансфер в мод. окне с описание трансфера

                @Step("Нажимаю кнопку Выбрать трансфер в окне описания трансфера")
        public void clickSelectTransferBtn() {

            if (searchTransferBtn.isDisplayed()) {
                searchTransferBtn.click();
            }
        }
    }*/
}
