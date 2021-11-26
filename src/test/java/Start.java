import base.BaseTest;
import org.testng.annotations.Test;
import pages.menu.Sidebar;

public class Start extends BaseTest {

    /*@Test
    public void startApp() {
        BaseSetup setupDriver = new BaseSetup();
        setupDriver.setUpDriver();

        HomeScreen logIn = new HomeScreen();
      //  logIn.clickEnterBtn();
        Enter enter = new Enter();
        enter.enterLogin();
        enter.enterPassword();
        enter.tapEnterBtn();
    }*/

    @Test
    public void s(){
        Sidebar sidebar = homeScreen.clickMenuBtn();
        sidebar.clickMenuDebugViewsBtn();
    }
}
