package base;

import io.appium.java_client.android.options.UiAutomator2Options;

public class Capabilities extends UiAutomator2Options {
    public final static String AUTOMATION_NAME = "UiAutomator2";
    public final static String PLATFORM_NAME = "Android";
    public final static String APP_PACKAGE = "ru.s7.android";
    public final static String APP_PLATFORM_VERSION = "8.1.0";
    //public final static String APP_ACTIVITY = "ru.s7.android.ui.SplashActivity";
    public final static String APP_ACTIVITY = "ru.s7.android.ui.MainActivity";
    public final static String APP_WAIT_ACTIVITY = "ru.s7.android.ui.MainActivity";
    public final static String SHOULD_TERMINATE_APP = "false"; //приложение всегда завершается в конце сеанса
    public final static String FORCE_APP_LAUNCH = "true"; //приложение принудительно перезапускается при запуске сеанса
    public final static String PRINT_PAGE_SOURCE_ON_FIND_FAILLURE = "true";
    public final static String LAUNCH_TIMEOUT = "30000";
    public final static String APP_WAIT_DURATION = "30000";
    public final static String APP_WAIT_FOR_LAUNCH = "false";
    public final static String FULL_RESET = "false";
    public final static String NO_RESET = "true";
    public final static String UNLOCK_TYPE = "pattern";
    public final static String UNLOCK_KEY = "523698741";


    public UiAutomator2Options getCapabilities() {
        //public DesiredCapabilities getCapabilities() {
        //DesiredCapabilities capabilities = new DesiredCapabilities();
        UiAutomator2Options capabilities = new UiAutomator2Options();

        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("appium:platformVersion", APP_PLATFORM_VERSION);
        //capabilities.setCapability("udid", "818HGBTP2245L");
        capabilities.setCapability("appium:udid", "ENU7N15B06000502");
        capabilities.setCapability("appium:appPackage", APP_PACKAGE);
        capabilities.setCapability("appium:appActivity", APP_ACTIVITY);
        capabilities.setCapability("appium:automationName", AUTOMATION_NAME);
        //capabilities.setCapability("appWaitActivity", APP_WAIT_ACTIVITY);
        capabilities.setCapability("fullReset", FULL_RESET);
        capabilities.setCapability("noReset", NO_RESET);
        capabilities.setCapability("appium:shouldTerminateApp", SHOULD_TERMINATE_APP);
        capabilities.setCapability("appium:forceAppLaunch", FORCE_APP_LAUNCH);
        capabilities.setCapability("printPageSourceOnFindFailure", PRINT_PAGE_SOURCE_ON_FIND_FAILLURE);
        capabilities.setCapability("launchTimeout", LAUNCH_TIMEOUT);
        capabilities.setCapability("appWaitDuration", APP_WAIT_DURATION);
        capabilities.setCapability("appium:appWaitForLaunch", APP_WAIT_FOR_LAUNCH);
        capabilities.setCapability("unlockType", UNLOCK_TYPE);
        capabilities.setCapability("unlockKey", UNLOCK_KEY);
        //capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        //capabilities.setCapability("appium:nativeWebScreenshot", true);
        //capabilities.setCapability("appium:connectHardwareKeyboard", true);

        return capabilities;
    }
}
