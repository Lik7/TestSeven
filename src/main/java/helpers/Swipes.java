package helpers;

import base.BaseTest;
import base.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static com.codeborne.selenide.Selenide.sleep;


public class Swipes {
    //    private AndroidDriver driver = BaseTest.setUpDriver();
    private AndroidDriver driver = Driver.getDriver();
    Waits waits = new Waits();

    //Свайп по экрану
    public void swipe(int timeOfSwipe, double startPoint, double endPoint) {
        TouchAction action = new TouchAction(driver);
        Dimension sizeScreen = driver.manage().window().getSize();//Получаем размер экрана
        int x = sizeScreen.width / 2;
        int start_Y = (int) (sizeScreen.height * startPoint); //Нач. точка в %-х экрана вниз
        int end_Y = (int) (sizeScreen.height * endPoint); //Конечн. точка в %-х экрана вниз
        action.press(point(x, start_Y))
                .waitAction(waitOptions(ofMillis(timeOfSwipe)))
                .moveTo(point(x, end_Y))
                .waitAction(waitOptions(ofMillis(timeOfSwipe)))
                .release()
                .perform();
    }

    //Свайп по экрану вверх (с низу в верх)
    public void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension sizeScreen = driver.manage().window().getSize();//Получаем размер экрана
        int x = sizeScreen.width / 2;
        int start_Y = (int) (sizeScreen.height * 0.8); //Нач. точка в 80% экрана вниз
        int end_Y = (int) (sizeScreen.height * 0.2); //Конечн. точка в 20% экрана вниз

        action.press(point(x, start_Y))
                .waitAction(waitOptions(ofMillis(timeOfSwipe)))
                .moveTo(point(x, end_Y))
                .release()
                .perform();
    }

    //Свап по экрану вниз (с верху в низ)
    public void swipeDown(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension sizeScreen = driver.manage().window().getSize();//Получаем размер экрана
        int x = sizeScreen.width / 2;
        int start_Y = (int) (sizeScreen.height * 0.2); //Нач. точка в 80% экрана вниз
        int end_Y = (int) (sizeScreen.height * 0.8); //Конечн. точка в 20% экрана вниз

        action.press(point(x, start_Y))
                .waitAction(waitOptions(ofMillis(timeOfSwipe)))
                .moveTo(point(x, end_Y))
                .release()
                .perform();
    }

    //Свайп до элемента
    public void swipeUpToElement(By by, int maxSwipes, double startPoint, double endPoint) {
        int alreadySwiped = 0;//Кол-во сделанных свайпов
        while (driver.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwipes) {
                waits.waitForElementPresent(by, 1);
                return;
            }
            swipe(100, startPoint, endPoint);
            ++alreadySwiped;
        }
    }
}
