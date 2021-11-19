package aeroexpress;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.myBooking.DetailSpecBookingScreen;
import pages.myBooking.MyBookingsScreen;

public class AddAEInBookingTest extends BaseTest {

    @Test
    MyBookingsScreen mb = homeScreen;
    DetailSpecBookingScreen detBooking = mb.clickCityInBookingCard();
}
