package airTicket;

import base.BaseTest;
import generalActions.pay.PayScreen;
import org.testng.annotations.Test;
import pages.airTickets.SelectCostAirTicketScreen;
import pages.airTickets.SelectDadesAirTicketScreen;
import pages.menu.Sidebar;

public class BuyAirTicketTest extends BaseTest {

    @Test(description = "Покупка билета")
    public void buyAirTicketTest() {
       /* Sidebar sidebar = homeScreen.clickMenuBtn();
        SelectDadesAirTicketScreen airTicket = sidebar.clickMenuAirTicketsBtn();
/*        airTicket.clickDepartureCity();
        airTicket.selectAirportOfDeparture();
        airTicket.clickArrivalCity();
        airTicket.selectAirportOfArrival();
        airTicket.clickDepartureDate();
        airTicket.selectDepartureArrivalDates();
        SelectCostAirTicketScreen costAirTicket = airTicket.clickSearchBtn();

        costAirTicket.selectTicket();
        costAirTicket.selectTicket();
        costAirTicket.clickNextBtn();
        costAirTicket.clickAddPassengerBtn();
        costAirTicket.clickNextBtn();
        costAirTicket.clickNextBtn();
        //costAirTicket.selectMethodOfPayment();
        //costAirTicket.fillCVVField();
        //costAirTicket.onSwitchAgreeToTerms();
        //costAirTicket.tapPayBtn();
        PayScreen payScreen = costAirTicket.selectMethodOfPayment();
        payScreen.paySavedBankCard();*/
    }
}
