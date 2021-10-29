package aeroexpress;

import base.BaseTest;
import enums.Dates;
import org.testng.annotations.Test;
import pages.aeroexpress.AeroExpressScreen;
import pages.menu.Sidebar;

public class AeroExpressTest extends BaseTest {

    Dates dates = Dates.DAYS;

    @Test(description = "Покупка билета на АЕ")
    public void buyingAETicketTest() {
        Sidebar sidebar = homeScreen.clickMenuBtn();
        AeroExpressScreen aeroExpressScreen = sidebar.clickMenuAeroexpressBtn();
        aeroExpressScreen.tapThereBtn();
        aeroExpressScreen.selectDateThere(dates.tomorrow());
        //aeroExpressScreen.selectDateBack(5);
        aeroExpressScreen.selectDateBack(dates.getInWeek());
        aeroExpressScreen.clickChoiceOfPassengersBtn();
        aeroExpressScreen.clickNextBtn();
        //aeroExpressScreen.fillNameInContactField();
        //aeroExpressScreen.fillSurnameInContactField();
        //aeroExpressScreen.fillTelephoneInContactField();
        //aeroExpressScreen.fillEmailInContactField();
        aeroExpressScreen.selectMethodOfPayment(1);
        aeroExpressScreen.fillCVVField();
        aeroExpressScreen.onSwitchAgreeToTerms();
       // aeroExpressScreen.tapPayBtn();
    }
}
