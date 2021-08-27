package pages.rentalCar;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class BuyOrBookCarScreen {

    private AndroidDriver driver;

    public BuyOrBookCarScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ru.s7.android:id/tvTitle")
    private MobileElement titleName;//Название экрана

    @AndroidFindBy(xpath = "//android.view.View[@text='Выбор авто']")
    private MobileElement nameOfBlockSelectionCar;//название блока Выбор авто

    @Step("Получение название экрана")
    public String getTitleName(){
        //System.out.println(titleName.getText());
        return titleName.getText();
    }

    @Step("Получение название экрана")
    public String getNameOfBlockSelectionCar(){
        //System.out.println(nameOfBlockSelectionCar.getText());
        return nameOfBlockSelectionCar.getText();
    }
}
