package base;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities extends DesiredCapabilities {
    public final static String PLATFORM_NAME = "Android";
    public final static String APP_PACKAGE = "ru.s7.android";
    public final static String APP_ACTIVITY = "ru.s7.android.ui.SplashActivity";
    public final static String APP_WAIT_ACTIVITY = "ru.s7.android.ui.MainActivity";
    public final static String FULL_RESET = "false";
    public final static String NO_RESET = "true";
    public final static String PRINT_PAGE_SOURCE_ON_FIND_FAILLURE = "true";
    public final static String LAUNCH_TIMEOUT = "30000";
    public final static String APP_WAIT_DURATION = "30000";
    public final static String APP_WAIT_FOR_LAUNCH = "false";
    public final static String UNLOCK_TYPE = "pattern";
    public final static String UNLOCK_KEY = "523698741";


    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("deviceName", "meizu");
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("platformVersion", "8.1.0");
        //capabilities.setCapability("udid", "818HGBTP2245L");
        capabilities.setCapability("udid", "ENU7N15B06000502");
        capabilities.setCapability("appPackage", APP_PACKAGE);
        capabilities.setCapability("appActivity", APP_ACTIVITY);
        capabilities.setCapability("appWaitActivity", APP_WAIT_ACTIVITY);
        capabilities.setCapability("fullReset", FULL_RESET);
        capabilities.setCapability("noReset", NO_RESET);
        capabilities.setCapability("printPageSourceOnFindFailure", PRINT_PAGE_SOURCE_ON_FIND_FAILLURE);
        capabilities.setCapability("launchTimeout", LAUNCH_TIMEOUT);
        capabilities.setCapability("appWaitDuration", APP_WAIT_DURATION);
        capabilities.setCapability("appWaitForLaunch", APP_WAIT_FOR_LAUNCH);
        capabilities.setCapability("unlockType", UNLOCK_TYPE);
        capabilities.setCapability("unlockKey", UNLOCK_KEY);
        return capabilities;
    }
}