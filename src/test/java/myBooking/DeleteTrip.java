package myBooking;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.myBooking.MyBookingScreen;

public class DeleteTrip extends BaseTest {

    @Test (description = "Удаление всех броней")
    public void deleteAllTrips(){
        MyBookingScreen mb = new MyBookingScreen(homeScreen.getDriver());
        mb.deleteAllTrips();
    }

    @Test (description = "Удаление одной брони")
    public void deleteOneTrip(){
        MyBookingScreen mb = new MyBookingScreen(homeScreen.getDriver());
        mb.deleteOneTrip();
    }
}