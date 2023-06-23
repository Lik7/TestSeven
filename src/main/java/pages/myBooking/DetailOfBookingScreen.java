package pages.myBooking;

import helpers.ElementIsMissing;
import helpers.Scroll;
import helpers.Swipes;
import helpers.Waits;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.aeroexpress.AddBuyAEScreen;
import pages.insurance.InsuranceScreen;

//экран деталей конкретной брони
public class DetailOfBookingScreen {
    AndroidDriver driver;

    public DetailOfBookingScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"ru.s7.android:id/twTitle\") and @text=\"Аэроэкспресс\"]")
    private WebElement fieldAeroexpressInBannerAE;//поле с текстом Аэроэкспресс в баннере АЕ

    @AndroidFindBy(id = "ru.s7.android:id/flAeroexpressIcon")
    private WebElement aeroexpressIcon;//иконка АЕ в купленном баннере

    @AndroidFindBy(xpath = "//*[@resource-id='ru.s7.android:id/pnrLabel']")
    private WebElement bookingText;//текст Бронь:

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Спокойствие в поездке']")
    private WebElement peaceInTripText;//название блока Спокойствие в поездке

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Страховка от невыезда']")
    private WebElement notLeavingInsName;//название Страховка от невыезда

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Медицинская страховка']")
    private WebElement medicalInsName;//название Медицинская страховка

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Страховка Трэвел']")
    private WebElement travelInsName;//название Страховка Трэвел

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Страховка Трэвел-Спорт']")
    private WebElement travelSportInsName;//название Страховка Трэвел-Спорт

    Swipes swipe = new Swipes();

    //элемент в уже купленном продукте
    String fieldAeroexpress = "//android.widget.TextView[contains(@resource-id,\"ru.s7.android:id/twTitle\") and @text=\"Аэроэкспресс\"]";
    String AEIconID = "ru.s7.android:id/flAeroexpressIcon";
    //String fieldNotLeavingIns = "android.widget.TextView[contains(@resource-id,'ru.s7.android:id/tvProductName') and @text=\"Страховка от невыезда\"]";

    @Step("Тап по баннеру АЕ")
    public AddBuyAEScreen fieldAEInBannerAEClick() {
        //Swipes swipe = new Swipes();
        Scroll.scrollToElementDown(fieldAeroexpress, 10);
        fieldAeroexpressInBannerAE.click();
        return new AddBuyAEScreen(driver);
    }

    @Step("Проверяю, что АЕ добавлен в бронь")
    public boolean aeroexpressIconIsDisp() {
        Scroll.scrollUpDownToElement(3, "//*[@resource-id='ru.s7.android:id/flAeroexpressIcon']", "//*[@resource-id='ru.s7.android:id/pnrLabel']");
        return ElementIsMissing.elementIsDispIDLocator(AEIconID);
    }

    @Step("Скролл до названия блока Спокойствие в поезке")
    public void scrollToPeaceInTripText() {
        Scroll.scrollDownUpToElement("//android.widget.TextView[@text='Спокойствие в поездке']", 5);
    }

    @Step("Скролл в слайдере страховок")
    public void swipeToInsSlider() {
        swipe.swipeRightLeftToElement("//android.widget.TextView[@text='Страховка от невыезда']");
    }

    @Step("Тап по баннеру Страховка от невыезда")
    public InsuranceScreen notLeavingInsNameClick() {
        notLeavingInsName.click();
        return new InsuranceScreen(driver);
    }
    @Step("Тап по баннеру Медицинская страховка")
    public InsuranceScreen medicalInsNameClick() {
        medicalInsName.click();
        return new InsuranceScreen(driver);
    }

    @Step("Тап по баннеру Страховка Трэвел")
    public InsuranceScreen travelInsNameClick() {
        travelInsName.click();
        return new InsuranceScreen(driver);
    }

    @Step("Тап по баннеру Страховка Трэвел-Спорт")
    public InsuranceScreen travelSportInsNameClick() {
        travelSportInsName.click();
        return new InsuranceScreen(driver);
    }

    @Step("Проверяю, что страховка куплена")
    public boolean payedInsuranceIsDisp(String insurance) {
        String fieldPayedInsurance = "//android.widget.TextView[contains(@resource-id,'ru.s7.android:id/tvProductName') and @text='" + insurance + "']";
        Scroll.scrollDownUpToElement(fieldPayedInsurance, 5);

        //System.out.println("текст локатора: " + fieldPayedInsurance);
        return ElementIsMissing.elementIsDispXPathLocator(fieldPayedInsurance);
    }
}
