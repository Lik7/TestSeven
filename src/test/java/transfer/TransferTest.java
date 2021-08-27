package transfer;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.menu.Sidebar;
import pages.tranfer.TransferScreen;

public class TransferTest extends BaseTest {

    @Test(description = "Проверяем, что на карте установлены пин в начальной и конечной точке маршрута")
    public void transferTest() {

        Sidebar sidebar = homeScreen.clickMenuBtn();
        sidebar.clickMenuTransferBtn();//в боковом меню нажимаю пункт Трансфер
        TransferScreen transfer = sidebar.clickMenuTransferBtn();
        transfer.clickSelectTransferBtn();
        transfer.clickInFromField();
        transfer.enterFromField("pulkovo");
        transfer.clickInWhereField();
        transfer.enterWhereField("nevski");
        Assert.assertEquals(transfer.getCountOfPingsOnMap(), 3, "На карте не 2 поинта");
    }
}

