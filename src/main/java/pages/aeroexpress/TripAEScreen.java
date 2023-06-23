package pages.aeroexpress;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//бронь АЕ (детали)
public class TripAEScreen {
    private AndroidDriver driver;

    public TripAEScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='ru.s7.android:id/tvTitle' and @text='Аэроэкспресс']")
    private WebElement nameTitleScreen;//название экрана

    public String getNameScreen (){
        return nameTitleScreen.getText();
    }
}
