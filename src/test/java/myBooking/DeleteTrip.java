package myBooking;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.myBooking.MyBookingsScreen;

public class DeleteTrip extends BaseTest {

    @Test (description = "Удаление всех броней")
    public void deleteAllTrips(){
        MyBookingsScreen mb = new MyBookingsScreen(homeScreen.getDriver());
        mb.deleteAllTrips();
    }

    @Test (description = "Удаление одной брони")
    public void deleteOneTrip(){
        MyBookingsScreen mb = new MyBookingsScreen(homeScreen.getDriver());
        mb.deleteOneTrip();
    }
}