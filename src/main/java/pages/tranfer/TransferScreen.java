package pages.tranfer;

import helpers.AllureScreenShooter;
import helpers.HideKeyboardIfVisible;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import java.util.List;

//import static base.BaseTest.setUpDriver;
import static com.codeborne.selenide.Selenide.sleep;
//прикрутил "свободный интерфейс" (цепочка методов)
@Listeners(AllureScreenShooter.class)


public class TransferScreen {
    //private final Logger logger = LoggerFactory.getLogger(Transfer.class);//*****-----РАЗОБРАТЬСЯ КАК ИСПОЛЬЗОВАТЬ
    static final Logger logger = LogManager.getLogger(TransferScreen.class);


    private AndroidDriver driver;

    public TransferScreen(AndroidDriver driver) {
        //this.driver = setUpDriver();
        this.driver = driver;
        //PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ru.s7.android:id/etStartPlace")
    private WebElement fromField;//поле Откуда на экране с картой

    @AndroidFindBy(id = "ru.s7.android:id/etFinishPlace")
    private WebElement whereField;//поле Куда на экране с картой

    @AndroidFindBy(id = "ru.s7.android:id/rlBackground")
    private WebElement searchTransferBtn;//кнопка Выбрать трансфер в модалке с описанием трансфера

    @AndroidFindBy(id = "ru.s7.android:id/btnClose")
    private WebElement closeBtn;//кнопка Закрыть в блоке примера маршрута

    @AndroidFindBy(id = "ru.s7.android:id/etValue")
    private List<WebElement> searchField;//поля поиска в окне ввода адреса

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Карта Google']/android.view.View")
    private List<WebElement> pingsOnMap;//кол-во пингов на карте

  /*@AndroidFindBy(className = "UIAKeyboard")
    private AndroidElement keyboard;*/

    //private boolean isKeyboardShown;

    HideKeyboardIfVisible hideKeyboardIfVisible = new HideKeyboardIfVisible();

    @Step("Нажимаю кнопку Выбрать трансфер в окне описания трансфера")
    public TransferScreen clickSelectTransferBtn() {
        logger.info("Start method clickSelectTransferBtn");
        if (searchTransferBtn.isDisplayed()) {
            searchTransferBtn.click();
        }
        return this;
    }

    @Step("Тап в поле Откуда")
    public TransferScreen clickInFromField() {
        if (closeBtn.isDisplayed()) {
            closeBtn.click();//закрываем ИнфоБлок над блоком откуда\куда
        }
        fromField.click();
        return this;
    }

    @Step("Тап в поле Куда")
    public TransferScreen clickInWhereField() {
        whereField.click();
        return this;
    }

    @Step("Заполняю поле Откуда")
    public TransferScreen enterFromField(String fromValue) {
        String str = searchField.get(0).getText();
        System.out.println("searchField.get(0):" + searchField.get(0).getText());
        if (!str.isEmpty()) {
            searchField.get(0).clear();
        }
        searchField.get(0).sendKeys(fromValue);
        //driver.navigate().back();
        hideKeyboardIfVisible.hideKeyboardIfVisible();
        WebElement pointFromField = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Pulkovo Airport (LED)\"]"));
        pointFromField.click();
        return this;
    }

    @Step("Заполняю поле Куда")
    public TransferScreen enterWhereField(String whereValue) {
        searchField.get(1).sendKeys(whereValue);
        //driver.navigate().back();
        hideKeyboardIfVisible.hideKeyboardIfVisible();
        WebElement pointWhereField = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Nevsky prospect\"]"));
        pointWhereField.click();
        return this;
    }

    @Step("Количество пингов на карте")
    public int getCountOfPingsOnMap() {
        //if нужен для ожидания отработки анимации
        if (pingsOnMap.size() != 2) {
            sleep(2000);
        }
        return pingsOnMap.size();
    }
}
