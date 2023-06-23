package pages.buy;

import base.BaseScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

//экран Купить из нижнего меню
public class BuyScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ru.s7.android:id/text') and @text='Авиа']")
    private WebElement aviaChips;//кнопка Авиа

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ru.s7.android:id/text') and @text='Отель']")
    private WebElement hotelChips;//кнопка Отель

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ru.s7.android:id/text') and @text='Авто']")
    private WebElement carChips;//кнопка Авто

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ru.s7.android:id/text') and @text='Трансфер']")
    private WebElement transferChips;//кнопка Трансфер

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ru.s7.android:id/text') and @text='Аэроэкспресс']")
    private WebElement aeChips;//кнопка Аэроэкспресс


    public void clickAviaChips(){
        aeChips.click();
    }

    public void clickHotelChips(){
        hotelChips.click();
    }

    public void clickCarChips(){
        carChips.click();
    }

    public void clickTransferChips(){
        transferChips.click();
    }

    @Step("Нажимаю вкладку (чипс) Аэроэкспресс")
    public void clickAeChips(){
        aeChips.click();
    }
}
