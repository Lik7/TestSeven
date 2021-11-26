package aeroexpress;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.aeroexpress.AddBuyAE;
import pages.myBooking.DetailSpecBookingScreen;
import pages.myBooking.MyBookingsScreen;

public class AddAEInBookingTest extends BaseTest {

    @Test(description = "Докупка АЕ в бронь")
    public void addAEInBookingTest() {
        DetailSpecBookingScreen detBook = homeScreen.clickCityInBookingCard();
        //detBook.clickFieldAEInBannerAE();
        AddBuyAE addBuyAE = detBook.clickFieldAEInBannerAE();
        addBuyAE.clickSafeBtn();
        addBuyAE.fillPaymentDetails();
        //addBuyAE.tapPayBtn();
        addBuyAE.clickOkBtn();

        Assert.assertEquals(detBook.aeroexpressIconIsDisp(), true, "В брони не отображается баннер купленного АЕ");

    }
}
