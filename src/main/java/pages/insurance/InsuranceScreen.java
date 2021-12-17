package pages.insurance;

import generalActions.pay.PayScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class InsuranceScreen {
    AndroidDriver driver;

    public InsuranceScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "ru.s7.android:id/rlBackground")
    private MobileElement addBtn;//кнопка Добавить в мод. окне страховки

    @AndroidFindBy(id ="ru.s7.android:id/yes")
    private MobileElement OKBtn;//кнопка ОК в поп-ап результата

    @Step("Тап по кнопке Добавить в мод. окне страховки")
    public PayScreen addBtnClick(){
        addBtn.click();
        return new PayScreen(driver);
    }

    @Step("Нажимаю кнопку ОК в поп-ап результата покупки страховки")
    public void clickOkBtn(){
        OKBtn.click();
    }
}
