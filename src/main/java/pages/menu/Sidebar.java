package pages.menu;

import helpers.Swipes;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.airTickets.AirTicketsScreen;
import pages.settings.AppSettings;
import pages.aeroexpress.AeroExpressScreen;
import pages.rentalCar.RentalCarScreen;
import pages.tranfer.TransferScreen;


public class Sidebar {
    private AndroidDriver driver;

    @AndroidFindBy(id = "ru.s7.android:id/navIbe")
    private MobileElement menuAirTicketsBtn;//кнопка Меню - авиабилеты

    @AndroidFindBy(id = "ru.s7.android:id/navAeroexpress")
    private MobileElement menuAeroexpressBtn;//кнопка Меню - аэроэкспресс

    @AndroidFindBy(id = "ru.s7.android:id/navTransfer")
    private MobileElement menuTransferBtn;//кнопка Меню - трансфер

    @AndroidFindBy(id = "ru.s7.android:id/navAuto")
    private MobileElement menuAutoBtn;//кнопка Меню - авто

        @AndroidFindBy(id = "ru.s7.android:id/navSettings")
    private MobileElement menuSettingsBtn;//кнопка Меню - Настройки

    public Sidebar(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Нажимаю кнопку Авиабилеты в боковом меню")
    public AirTicketsScreen clickMenuAirTicketsBtn() {
        menuAirTicketsBtn.click();
        return new AirTicketsScreen(driver);
    }

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

    @Step("Нажимаю кнопку Аэроэкспресс в боковом меню")
    public AeroExpressScreen clickMenuAeroexpressBtn() {
        menuAeroexpressBtn.click();
        return new AeroExpressScreen(driver);
    }

    @Step("Нажимаю кнопку Настройки в меню")
    public AppSettings clickSettingBtn() {
        Swipes sw = new Swipes();
        sw.swipeUpToElement("//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='ru.s7.android:id/navSettings']");
        menuSettingsBtn.click();
        return new AppSettings(driver);
    }
}
