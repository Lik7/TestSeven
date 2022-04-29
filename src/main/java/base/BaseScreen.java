package base;

import helpers.DateSelected;
import helpers.Scroll;
import helpers.Swipes;
import helpers.Waits;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {
    protected AndroidDriver driver = Driver.getDriver();
    protected Swipes swipe = new Swipes();
    protected Waits wait = new Waits();
    protected Scroll scroll = new Scroll();
    //protected DateSelected dateSelected = new DateSelected();

    public BaseScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
