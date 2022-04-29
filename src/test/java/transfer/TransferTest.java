package transfer;

import base.BaseTest;
import enums.AirportData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.menu.Sidebar;
import pages.tranfer.TransferScreen;
//прикрутил "свободный интерфейс" (цепочка методов)

public class TransferTest extends BaseTest {
    AirportData AD = AirportData.LED;

    @Test(description = "Проверяем, что на карте установлены пин в начальной и конечной точке маршрута")
    public void transferTest() {

       /* Sidebar sidebar = homeScreen.clickMenuBtn();
        TransferScreen transfer = sidebar.clickMenuTransferBtn()
        .clickSelectTransferBtn()
        .clickInFromField()
        .enterFromField(AD.getNameEN())
        .clickInWhereField()
        .enterWhereField("nevski");
        Assert.assertEquals(transfer.getCountOfPingsOnMap(), 2, "На карте " + transfer.getCountOfPingsOnMap() + " поинт/а, а не 2");
    */}
}

