package pages.settings;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class AppSettings {

    private AndroidDriver driver;

    public AppSettings(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
