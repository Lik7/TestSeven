package pages.buy;

import base.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

//экран Купить из нижнего меню
public class BuyScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ru.s7.android:id/text') and @text='Авиа']")
    private MobileElement aviaChips;//кнопка Авиа

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ru.s7.android:id/text') and @text='Отель']")
    private MobileElement hotelChips;//кнопка Отель

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ru.s7.android:id/text') and @text='Авто']")
    private MobileElement carChips;//кнопка Авто

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ru.s7.android:id/text') and @text='Трансфер']")
    private MobileElement transferChips;//кнопка Трансфер

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'ru.s7.android:id/text') and @text='Аэроэкспресс']")
    private MobileElement aeChips;//кнопка Аэроэкспресс


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
