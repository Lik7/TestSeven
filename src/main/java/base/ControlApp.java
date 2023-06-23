package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.qameta.allure.Step;

import java.util.logging.Logger;

public class ControlApp {
    private static AppiumDriver driver;

        //@Step("Terminate app")
    //public void AppiumDriver terminateApp() {
    public static void terminateApp() {
        //Logger.log();
        String appID = null;
        if (driver != null) {
            try {
                if (driver instanceof AppiumDriver) {
                    appID = (String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE);
                }
                if (appID != null)
                    ((InteractsWithApps) driver).terminateApp(appID);
            } catch (Exception e) {
                //Logger.logError(e.getMessage());
            }
        }
       // return;
    }

}


    /*@Step("Terminate app")
    public AppDriver terminateApp() {
        Logger.log();
        String appID = null;
        if (driver != null) {
            try {
                if (driver instanceof AndroidDriver) {
                    appID = (String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE);
                } else if (driver instanceof IOSDriver) {
                    appID = String.valueOf(driver.getCapabilities().getCapability(IOSMobileCapabilityType.BUNDLE_ID));
                } else
                    Assert.fail(createAssertionLog("unknown driver type"));
                if (appID != null)
                    ((InteractsWithApps) driver).terminateApp(appID);
            } catch (Exception e) {
                Logger.logError(e.getMessage());
            }
        }
        return this;
    }*/