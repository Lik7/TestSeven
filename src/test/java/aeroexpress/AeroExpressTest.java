package aeroexpress;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.aeroexpress.AeroExpressScreen;
import pages.menu.Sidebar;

public class AeroExpressTest extends BaseTest {

    @Test(description = "Покупка билета на АЕ")
    public void buyingAETicketTest() {
        Sidebar sidebar = homeScreen.clickMenuBtn();
        AeroExpressScreen aeroExpressScreen = sidebar.clickMenuAeroexpressBtn();
        aeroExpressScreen.tapThereBtn();
        aeroExpressScreen.selectDateThere();
        aeroExpressScreen.selectDateBack(5);
        aeroExpressScreen.clickChoiceOfPassengersBtn();
        aeroExpressScreen.clickNextBtn();
        aeroExpressScreen.fillNameInContactField();
        aeroExpressScreen.fillSurnameInContactField();
        aeroExpressScreen.fillTelephoneInContactField();
        aeroExpressScreen.fillEmailInContactField();
        aeroExpressScreen.selectMethodOfPayment(1);
        aeroExpressScreen.fillCVVField();
        aeroExpressScreen.onSwitchAgreeToTerms();
        aeroExpressScreen.tapPayBtn();
    }
}
