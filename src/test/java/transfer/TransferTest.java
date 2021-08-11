package transfer;

import base.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomeScreen;
import pages.menu.Sidebar;
import pages.tranfer.Transfer;

//@Listeners(AllureScreenShooter.class)

public class TransferTest extends BaseSetup {
    @Test(description = "Проверяем, что на карте установлены пин в начальной и конечной точке маршрута")
    public void transferTest() {

        HomeScreen homeScreen = new HomeScreen();
        homeScreen.clickMenuBtn();//нажимаю кнопку Меню
        Sidebar sidebar = new Sidebar();
        sidebar.clickMenuTransferBtn();//в боковом меню нажимаю пункт Трансфер
        Transfer transfer = new Transfer(BaseSetup.setUpDriver());
        transfer.clickSelectTransferBtn();
        transfer.clickInFromField();
        transfer.enterFromField("pulkovo");
        transfer.clickInWhereField();
        transfer.enterWhereField("nevski");
        Assert.assertEquals(transfer.getCountOfPingsOnMap(), 2, "На карте не 2 поинта");


        //BaseSetup setupDriver = new BaseSetup();
        //setupDriver.setUpDriver();

/*        HomeScreen homeScreen = new HomeScreen();
        homeScreen.clickMenuBtn();//нажимаю кнопку Меню
        Sidebar sidebar = new Sidebar();
        sidebar.clickMenuTransferBtn();//в боковом меню нажимаю пункт Трансфер
        //Taps taps = new Taps();
        //taps.tap(2, 10);//ВРЕМЕННО тап, чтобы закрыть мод.окно

        Transfer.InfoWindow infoWindow = new Transfer.InfoWindow();
        infoWindow.clickSelectTransferBtn();
        Transfer transfer = new Transfer();
        transfer.clickInFromField();//тап в поле Откуда

        Transfer.SearchTransfer searchTransfer = transfer.new SearchTransfer();
        searchTransfer.enterFromField("pulkovo");//ввод значения точки Откуда

        Transfer transfer2 = new Transfer();
        transfer2.clickWhereField();//тап в поле Куда

        Transfer.SearchTransfer searchTransfer2 = transfer2.new SearchTransfer();
        searchTransfer2.enterWhereField("nevski");//ввод значения точки Куда

        Assert.assertEquals(transfer.getCountOfPingsOnMap(), 2, "На карте не 2 поинта");
    */
    }
}

