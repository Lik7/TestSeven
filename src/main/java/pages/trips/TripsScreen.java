package pages.trips;

import base.BaseScreen;
import helpers.Scroll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TripsScreen extends BaseScreen {

    @AndroidFindBy(id = "ru.s7.android:id/btnAddBooking")
    private WebElement addBooking;//кнопка Добавить вручную

    public void clickAddBooking (){
        Scroll.scrollToElementDown("//*[@resource-id='ru.s7.android:id/btnAddBooking']", 3);
        addBooking.click();
    }
}
