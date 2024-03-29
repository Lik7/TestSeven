package aeroexpress;

import base.BaseTest;
import enums.Days;
import helpers.DateSelected;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.aeroexpress.AeroExpressScreen;
import pages.buy.BuyScreen;
import pages.home.HomeScreen;
import pages.trips.TripsScreen;

public class AeroExpressTest extends BaseTest {

    @Test(description = "Покупка билета на АЕ стенделон. Пользователь залогирован, банковская карта сохранена")
    public void buyingAETicketSATest() {

        homeScreen.clickBuyBottom();
        BuyScreen buy = new BuyScreen();
        buy.clickAeChips();
        AeroExpressScreen aeroExpressScreen = new AeroExpressScreen();
        aeroExpressScreen.tapThereBtn();
        DateSelected dateSelected = new DateSelected();
        dateSelected.tapDayStartInCalendar(Days.TOMORROW);
        dateSelected.tapDayFinishInCalendar(Days.IN_FIVE_DAYS);
        aeroExpressScreen.clickChoiceOfPassengersBtn();
        aeroExpressScreen.clickNextBtn();
        aeroExpressScreen.selectMethodOfPayment(0);
        aeroExpressScreen.fillPaymentDetails();
        aeroExpressScreen.fillCVVField();
        aeroExpressScreen.onSwitchAgreeToTerms();
        aeroExpressScreen.tapPayBtn();

        System.out.println("Номер брони: " + aeroExpressScreen.getBookingNumberOfAE());
        Assert.assertEquals(aeroExpressScreen.getValueStatus(), "Оплачено", "Результат покупки билета АЕ " + aeroExpressScreen.getValueStatus() + " ,а не Оплачено");

    }

    /*@Test
    public void df() {
        clickTripsBottom();
        TripsScreen tripsScreen = new TripsScreen();
        tripsScreen.clickAddBooking();

    }*/

}
