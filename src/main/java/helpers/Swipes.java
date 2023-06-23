package helpers;

import base.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class Swipes {
    //private static AndroidDriver driver = Driver.getDriver();
    private static AppiumDriver driver = Driver.getDriver();

    //Скролл вниз (свайп по экрану снизу вверх)
    public static void swipeDown() {
        swipeVertical(0.75, 0.3);
    }

    //Скролл вверх (свап по экрану сверху вниз)
    public static void swipeUp() {
        swipeVertical(0.3, 0.75);
    }

    //Скролл обновляет экран pull to refresh
    public static void pullToRefreshScreen() {
        swipeCustom(0.2, 0.7);
    }

    //Скролл с заданными значениями
    public static void swipeCustom(double startPoint, double endPoint) {
        swipeVertical(startPoint, endPoint);
    }

    //Свайп по экрану вертикально
    private static void swipeVertical(double startPoint, double endPoint) {
        //Actions action = new Actions(driver);
        //ActionChains action = new ActionChains(driver);

        Dimension sizeScreen = driver.manage().window().getSize();//Получаем размер экрана
        int x = sizeScreen.width / 2;
        int start_Y = (int) (sizeScreen.height * startPoint); //Нач. точка в %-х экрана
        int end_Y = (int) (sizeScreen.height * endPoint); //Конечн. точка в %-х экрана

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, start_Y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, end_Y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence));
        /*action
                .press(point(x, start_Y))
                .waitAction(waitOptions(ofMillis(900)))
                .moveTo(point(x, end_Y))
                .release()
                .perform();*/
    }

    //Свайп справа налево по элементу (на высоте элемента)
    public static void swipeRightLeftToElement(String xPathLocator) {
        WebElement WebElement = (WebElement) driver.findElement(By.xpath(xPathLocator));
        Point point = WebElement.getLocation();
        swipeHorizontal(0.8, 0.2, point.getY());
    }

    //Свап по экрану горизонтально. Если heightPoint=0 свап во середине экрана
    private static void swipeHorizontal(double startPoint, double endPoint, int heightPoint) {

        Dimension sizeScreen = driver.manage().window().getSize();//Получаем размер экрана
        int y = heightPoint;

        if (y == 0) {
            y = (int) (sizeScreen.height * 0.5);//высота экрана на которой будет свайп
        }
        int start_X = (int) (sizeScreen.width * startPoint); //Нач. точка в x% экрана справа
        int end_X = (int) (sizeScreen.width * endPoint); //Конечн. точка в x%% экрана слева

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start_X, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), end_X, y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence));

        /*action.press(point(start_X, y))
                .waitAction(waitOptions(ofMillis(800)))
                .moveTo(point(end_X, y))
                .release()
                .perform();*/
    }
}
