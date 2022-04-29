package pages.trips;

import base.BaseScreen;
import helpers.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TripsScreen extends BaseScreen {

    @AndroidFindBy(id = "ru.s7.android:id/btnAddBooking")
    private MobileElement addBooking;//кнопка Добавить вручную

    public void clickAddBooking (){
        Scroll.scrollToElementDown("//*[@resource-id='ru.s7.android:id/btnAddBooking']", 3);
        addBooking.click();
    }
}
