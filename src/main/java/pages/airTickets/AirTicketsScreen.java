package pages.airTickets;

import helpers.Swipes;
import helpers.Switch;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class AirTicketsScreen {

    private AndroidDriver driver;

    public AirTicketsScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    String switchLocatorID = "ru.s7.android:id/sc_redemption";

    @Step("Включаю свич согласия с условиями")
    public void onSwitchPayMiles() {
        Switch sw = new Switch();
        sw.switchON(switchLocatorID);
    }
}
