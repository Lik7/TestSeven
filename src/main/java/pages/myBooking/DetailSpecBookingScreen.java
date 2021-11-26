package pages.myBooking;

import helpers.Swipes;
import helpers.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.aeroexpress.AddBuyAE;

//экран деталей конкретной брони
public class DetailSpecBookingScreen {
    AndroidDriver driver;

    public DetailSpecBookingScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"ru.s7.android:id/twTitle\") and @text=\"Аэроэкспресс\"]")
    private MobileElement fieldAeroexpressInBannerAE;//поле с текстом Аэроэкспресс в баннере АЕ

    @AndroidFindBy(id = "ru.s7.android:id/flAeroexpressIcon")
    private MobileElement aeroexpressIcon;//иконка АЕ в купленном баннере

    String fieldAeroexpress = "//android.widget.TextView[contains(@resource-id,\"ru.s7.android:id/twTitle\") and @text=\"Аэроэкспресс\"]";
    String AEIconID = "ru.s7.android:id/flAeroexpressIcon";

    @Step("Тап по баннеру АЕ")
    public AddBuyAE clickFieldAEInBannerAE() {
        Swipes swipe = new Swipes();
        swipe.swipeUpToElement(fieldAeroexpress, 10);
        fieldAeroexpressInBannerAE.click();
        return new AddBuyAE(driver);
    }

    @Step("Проверяю, что АЕ добавлен в бронь")
    public boolean aeroexpressIconIsDisp(){

        return Waits.elementIsDispIDLocator(AEIconID);
    }

}
