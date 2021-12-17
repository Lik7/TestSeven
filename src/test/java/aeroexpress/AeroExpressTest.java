package aeroexpress;

import base.BaseTest;
import enums.Dates;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.aeroexpress.AeroExpressScreen;
import pages.menu.Sidebar;

public class AeroExpressTest extends BaseTest {

    @Test(description = "Покупка билета на АЕ стенделон. Пользователь залогирован, банковская карта сохранена")
    public void buyingAETicketSATest() {

        Sidebar sidebar = homeScreen.clickMenuBtn();
        AeroExpressScreen aeroExpressScreen = sidebar.clickMenuAeroexpressBtn();
        aeroExpressScreen.tapThereBtn();
        Dates dates = Dates.DAYS;
        dates.startTomorrow();
        dates.finishInWeek();
        aeroExpressScreen.clickChoiceOfPassengersBtn();
        aeroExpressScreen.clickNextBtn();
/*        aeroExpressScreen.selectMethodOfPayment(1);
        aeroExpressScreen.fillCVVField();
        aeroExpressScreen.onSwitchAgreeToTerms();*/
        aeroExpressScreen.tapPayBtn();


        System.out.println("Номер брони: " + aeroExpressScreen.getBookingNumberOfAE());
        Assert.assertEquals(aeroExpressScreen.getValueStatus(), "Оплачено", "Результат покупки билета АЕ " + aeroExpressScreen.getValueStatus() + " ,а не Оплачено");
    }

}
