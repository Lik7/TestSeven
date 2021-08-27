package pages.menu;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.rentalCar.RentalCarScreen;
import pages.tranfer.TransferScreen;


public class Sidebar {
    private AndroidDriver driver;

    @AndroidFindBy(id = "ru.s7.android:id/navTransfer")
    private MobileElement menuTransferBtn;//кнопка Меню - трансфер

    @AndroidFindBy(id = "ru.s7.android:id/navAuto")
    private MobileElement menuAutoBtn;//кнопка Меню - авто

    public Sidebar(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /*public Sidebar(AndroidDriver driver) {
        this.driver = driver;
    }*/

    @Step("Нажимаю кнопку Трансфер в боковом меню")
    public TransferScreen clickMenuTransferBtn() {
        menuTransferBtn.click();
        return new TransferScreen(driver);
    }

    @Step("Нажимаю кнопку Авто в боковом меню")
    public RentalCarScreen clickMenuAutoBtn() {
        menuAutoBtn.click();
        return new RentalCarScreen(driver);
    }
}
