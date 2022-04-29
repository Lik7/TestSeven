package pages.menu;

import helpers.Scroll;
import helpers.Swipes;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.airTickets.SelectDadesAirTicketScreen;
import pages.settings.AppSettings;
import pages.aeroexpress.AeroExpressScreen;
import pages.rentalCar.RentalCarScreen;
import pages.tranfer.TransferScreen;


public class Sidebar {
    private AndroidDriver driver;

    public Sidebar(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

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

    @AndroidFindBy(id = "ru.s7.android:id/navDebugViews")
    private MobileElement menuDebugViewsBtn;


    @Step("Нажимаю кнопку Авиабилеты в боковом меню")
    public SelectDadesAirTicketScreen clickMenuAirTicketsBtn() {
        menuAirTicketsBtn.click();
        return new SelectDadesAirTicketScreen(driver);
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
    //public AeroExpressScreen clickMenuAeroexpressBtn() {
    public void clickMenuAeroexpressBtn() {
        menuAeroexpressBtn.click();
        //return new AeroExpressScreen(driver);
    }

    @Step("Нажимаю кнопку Настройки в меню")
    public AppSettings clickSettingBtn() {
        Swipes sw = new Swipes();
        Scroll.scrollToElementDown("//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='ru.s7.android:id/navSettings']",10);
        menuSettingsBtn.click();
        return new AppSettings(driver);
    }

    @Step
    public void clickMenuDebugViewsBtn(){
        Swipes swipes = new Swipes();
        Scroll.scrollDownUpToElement("//*[@resource-id='ru.s7.android:id/navDebugViews_']", 3);
        menuDebugViewsBtn.click();
    }
}
