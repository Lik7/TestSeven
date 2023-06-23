package pages.home;

import base.BaseScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class BottomNavigationMenu extends BaseScreen {

    @AndroidFindBy(id = "ru.s7.android:id/page_1")
    private WebElement homeBottom;//кнопка Главная

    @AndroidFindBy(id = "ru.s7.android:id/page_2")
    private WebElement tripsBottom;//кнопка Путешествия

    @AndroidFindBy(id = "ru.s7.android:id/page_3")
    private WebElement buyBottom;//кнопка Купить

    @AndroidFindBy(id = "ru.s7.android:id/page_4")
    private WebElement messagesBottom;//кнопка Сообщения

    @AndroidFindBy(id = "ru.s7.android:id/page_5")
    private WebElement profileBottom;//кнопка Профиль


    @Step("Нажимаю кнопку Главная")
    public void clickHomeBottom() {
        homeBottom.click();
    }

    @Step("Нажимаю кнопку Путешествия")
    public void clickTripsBottom() {
        tripsBottom.click();
    }

    @Step("Нажимаю кнопку Купить")
    public void clickBuyBottom() {
        buyBottom.click();
    }

    @Step("Нажимаю кнопку Сообщения")
    public void clickMessagesBottom() {
        messagesBottom.click();
    }

    @Step("Нажимаю кнопку Профиль")
    public void clickProfileBottom() {
        profileBottom.click();
    }
}
