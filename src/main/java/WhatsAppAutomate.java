
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;
public class WhatsAppAutomate {
    // WebDriver driver;
    protected AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "8fe5de4a");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.whatsapp");
        // This package name of your app (you can get it from apk info app)
        capabilities.setCapability("appActivity", "com.whatsapp.Main");
        driver = new AndroidDriver(new URL("http://192.168.0.102:5036/wd/hub"), capabilities);
    }
    @Test
    public void testCal() throws Exception {
        swipeWhileNotFound("down","//*[@text='Anjan Mondal']",1000,3000,3000,17,true);
    }
    public void swipeWhileNotFound(String direction, String xpath,int offset,int waitTime,int duration,int round, boolean click) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int startx = size.width/2;
        int starty=0;
        int endy=0;
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            boolean loop = true;
            int count = 0;
            while (loop) {
                if (count == round) {
                    System.out.println("round over");
                    break;
                }
                if (driver.findElements(By.xpath(xpath)).size() > 0) {
                    loop = false;
                    System.out.println("element found");
                    WebElement elm = driver.findElement(By.xpath(xpath));
                    if (click)
                        elm.click();
                } /*else {
                    if(direction.toUpperCase().equals("UP")){
                        starty=size.height-offset;
                        endy = (int) (size.height * 0.60);
                        driver.swipe(startx, starty, startx, endy, duration);
                        Thread.sleep(waitTime);
                    }else if(direction.toUpperCase().equals("DOWN")){
                        starty = (int) (size.height * 0.80);
                        endy= offset;
                        driver.swipe(startx, endy, startx, starty, duration);
                        Thread.sleep(waitTime);
                    }
                    count++;
                }*/
            }
        } catch (Exception e) {
            System.out.print(e);
        } finally {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
    }
    @AfterClass
    public void teardown() {
        // close the app
        driver.quit();
    }
}