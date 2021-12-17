package helpers;

import base.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;


public class Swipes {
    private AndroidDriver driver = Driver.getDriver();
    Waits waits = new Waits();

    //Скролл вниз (свайп по экрану снизу вверх)
    public void scrollDown() {
        swipeVertical(0.75, 0.3);
    }

    //Скролл вверх (свап по экрану сверху вниз)
    public void scrollUp() {
        swipeVertical(0.3, 0.75);
    }

    //Скролл обновляет экран pull to refresh
    public void pullToRefreshScreen() {
        scrollCustom(0.2, 0.7);
    }

    //Скролл с заданными значениями
    public void scrollCustom(double startPoint, double endPoint) {
        swipeVertical(startPoint, endPoint);
    }

    //Свайп по экрану вертикально
    private void swipeVertical(double startPoint, double endPoint) {
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
    public void swipeRightLeftToElement(String xPathLocator) {
        MobileElement mobileElement = (MobileElement) driver.findElement(By.xpath(xPathLocator));
        Point point = mobileElement.getLocation();
        swipeHorizontal(0.8, 0.2, point.getY());
    }

    //Свап по экрану горизонтально. Если heightPoint=0 свап во середине экрана
    private void swipeHorizontal(double startPoint, double endPoint, int heightPoint) {
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

    //Скролл до элемена вниз
    public void scrollToElementDown(String xPathLocator, int countOfSwipes) {
        swipeToElement(xPathLocator, countOfSwipes, true);
    }

    //Скролл до элемена вверх
    public void scrollToElementUp(String xPathLocator, int countOfSwipes) {
        swipeToElement(xPathLocator, countOfSwipes, false);
    }

    //Скролл до элемента
    private void swipeToElement(String xPathLocator, int countOfSwipes, boolean b) {
        int alreadySwiped = 0;//Кол-во сделанных свайпов
        while (countDisplayOfElements(xPathLocator) == 0) {
            if (alreadySwiped > countOfSwipes) {
                return;
            }
            if (b == true) {
                scrollDown();
            } else scrollUp();
            ++alreadySwiped;
        }
        driver.manage().timeouts().implicitlyWait(Driver.getWaitSec(), TimeUnit.SECONDS);
    }


    //метод скроллит сначала вниз, затем вверх до элемента
    public void scrollDownUpToElement(String xPathLocator, int countOfSwipes) {
        int alreadySwiped = 0;//Кол-во сделанных свайпов
        int maxDownSwipes = countOfSwipes;
        int maxUpSwipes = countOfSwipes * 3;

        while (countDisplayOfElements(xPathLocator) == 0) {
            if (alreadySwiped == maxDownSwipes) {
                //waits.waitForElementPresent(By.xpath(xPathLocator), 1);
                while (countDisplayOfElements(xPathLocator) == 0) {
                    if (alreadySwiped > maxUpSwipes) {
                        waits.waitForElementPresent(By.xpath(xPathLocator), 1);
                        return;
                    }
                    scrollUp();
                    ++alreadySwiped;
                }
                return;
            }
            scrollDown();
            ++alreadySwiped;
        }
        driver.manage().timeouts().implicitlyWait(Driver.getWaitSec(), TimeUnit.SECONDS);
    }

    //****ДОПИСАТЬ*** свап до элемента без pull to refresh
    public void scrollUpDownToElement(int countOfSwipes, String... xPathLocator) {
        String str1 = xPathLocator.length > 0 ? xPathLocator[0] : null;
        String str2 = xPathLocator.length > 0 ? xPathLocator[1] : null;
        int alreadySwiped = 0;//Кол-во сделанных свайпов
        int maxUpSwipes = countOfSwipes;
        int maxDownSwipes = countOfSwipes * 3;

        while (countDisplayOfElements(str1) == 0) {
            if (alreadySwiped == maxUpSwipes || Waits.elementIsDispXPathLocator(str2)) {
                //waits.waitForElementPresent(By.xpath(xPathLocator), 1);
                while (countDisplayOfElements(str1) == 0) {
                    if (alreadySwiped > maxDownSwipes) {
                        waits.waitForElementPresent(By.xpath(str1), 1);
                        return;
                    }
                    scrollDown();
                    ++alreadySwiped;
                }
                return;
            }
            scrollUp();
            ++alreadySwiped;
        }
        driver.manage().timeouts().implicitlyWait(Driver.getWaitSec(), TimeUnit.SECONDS);
    }

    private int countDisplayOfElements(String xPathLocator) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return driver.findElements(By.xpath(xPathLocator)).size();
    }
}
