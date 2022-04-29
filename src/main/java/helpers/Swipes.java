package helpers;

import base.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;


public class Swipes {
    private static AndroidDriver driver = Driver.getDriver();

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
        TouchAction action = new TouchAction(driver);
        Dimension sizeScreen = driver.manage().window().getSize();//Получаем размер экрана
        int x = sizeScreen.width / 2;
        int start_Y = (int) (sizeScreen.height * startPoint); //Нач. точка в %-х экрана
        int end_Y = (int) (sizeScreen.height * endPoint); //Конечн. точка в %-х экрана
        action
                .press(point(x, start_Y))
                .waitAction(waitOptions(ofMillis(900)))
                .moveTo(point(x, end_Y))
                .release()
                .perform();
    }

    //Свайп справа налево по элементу (на высоте элемента)
    public static void swipeRightLeftToElement(String xPathLocator) {
        MobileElement mobileElement = (MobileElement) driver.findElement(By.xpath(xPathLocator));
        Point point = mobileElement.getLocation();
        swipeHorizontal(0.8, 0.2, point.getY());
    }

    //Свап по экрану горизонтально. Если heightPoint=0 свап во середине экрана
    private static void swipeHorizontal(double startPoint, double endPoint, int heightPoint) {
        TouchAction action = new TouchAction(driver);
        Dimension sizeScreen = driver.manage().window().getSize();//Получаем размер экрана
        int y = heightPoint;

        if (y == 0) {
            y = (int) (sizeScreen.height * 0.5);//высота экрана на которой будет свайп
        }
        int start_X = (int) (sizeScreen.width * startPoint); //Нач. точка в x% экрана справа
        int end_X = (int) (sizeScreen.width * endPoint); //Конечн. точка в x%% экрана слева

        action.press(point(start_X, y))
                .waitAction(waitOptions(ofMillis(800)))
                .moveTo(point(end_X, y))
                .release()
                .perform();
    }
}
