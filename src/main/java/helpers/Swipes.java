package helpers;

import base.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;


public class Swipes {
    private AndroidDriver driver = Driver.getDriver();
    Waits waits = new Waits();

    //Скролл вниз (свайп по экрану снизу вверх)
    public void scrollDown() {
        swipeHorizontal(350, 0.7, 0.2);
    }

    //Скролл вверх (свап по экрану сверху вниз)
    public void scrollUp() {
        swipeHorizontal(350, 0.2, 0.7);
    }

    //Скролл с заданными значениями
    public void scrollCustom(int timeOfSwipe, double startPoint, double endPoint){
        swipeHorizontal(timeOfSwipe, startPoint, endPoint);
    }

    //Свайп по экрану
    private void swipeHorizontal(int timeOfSwipe, double startPoint, double endPoint) {
        TouchAction action = new TouchAction(driver);
        Dimension sizeScreen = driver.manage().window().getSize();//Получаем размер экрана
        int x = sizeScreen.width / 2;
        int start_Y = (int) (sizeScreen.height * startPoint); //Нач. точка в %-х экрана
        int end_Y = (int) (sizeScreen.height * endPoint); //Конечн. точка в %-х экрана
        action.press(point(x, start_Y))
                .waitAction(waitOptions(ofMillis(timeOfSwipe)))
                .moveTo(point(x, end_Y))
                // .waitAction(waitOptions(ofMillis(timeOfSwipe)))
                .release()
                .perform();
    }

    //Свап по экрану справа налево
    public void swipeRightToLeft(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension sizeScreen = driver.manage().window().getSize();//Получаем размер экрана
        int y = (int) (sizeScreen.height * 0.4);//высота экрана на которой будет свайп
        int start_X = (int) (sizeScreen.width * 0.15); //Нач. точка в x% экрана справа
        int end_X = (int) (sizeScreen.width * 0.8); //Конечн. точка в x%% экрана слева

        action.press(point(start_X, y))
                .waitAction(waitOptions(ofMillis(timeOfSwipe)))
                .moveTo(point(end_X, y))
                .release()
                .perform();
    }

    //Свайп до элемента
    public void swipeUpToElement(String xPathLocator, int countOfSwipes) {
        int alreadySwiped = 0;//Кол-во сделанных свайпов
        //int countOfSwipes = 10;
        while (countElementsXPathLocator(xPathLocator) == 0) {
            if (alreadySwiped > countOfSwipes) {
                return;
            }
            //swipe(300, 0.7, 0.3);
            scrollDown();
            ++alreadySwiped;
        }
        driver.manage().timeouts().implicitlyWait(Driver.getWaitSec(), TimeUnit.SECONDS);
    }

    public void scrollToElementDown(String xPathLocator, int countOfSwipes) {
        swipeToElement(xPathLocator, countOfSwipes, true);
    }

    public void scrollToElementUp(String xPathLocator, int countOfSwipes) {
        swipeToElement(xPathLocator, countOfSwipes, false);
    }

    //Свайп до элемента
    private void swipeToElement(String xPathLocator, int countOfSwipes, boolean b) {
        int alreadySwiped = 0;//Кол-во сделанных свайпов
        while (countElementsXPathLocator(xPathLocator) == 0) {
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

    //Свайп до элемента
    public void swipeUpToElement(String xPathLocator, double startPoint, double endPoint) {
        int alreadySwiped = 0;//Кол-во сделанных свайпов
        int maxSwipes = 10;
        while (countElementsXPathLocator(xPathLocator) == 0) {
            if (alreadySwiped > maxSwipes) {
                waits.waitForElementPresent(By.xpath(xPathLocator), 1);
                return;
            }
            swipeHorizontal(350, startPoint, endPoint);
            ++alreadySwiped;
        }
    }

    //метод свайпает сначала вверх, затем вниз до элемента
    public void swipeUpAfterDownToElement(String xPathLocator, int countOfSwipes) {
        int alreadySwiped = 0;//Кол-во сделанных свайпов
        int maxUpSwipes = countOfSwipes;
        int maxDownSwipes = countOfSwipes * 2;

        while (countElementsXPathLocator(xPathLocator) == 0) {
            if (alreadySwiped > maxUpSwipes) {

                while (countElementsXPathLocator(xPathLocator) == 0) {
                    if (alreadySwiped > maxDownSwipes) {
                        waits.waitForElementPresent(By.xpath(xPathLocator), 1);
                        return;
                    }
                    scrollDown();
                    ++alreadySwiped;
                }

                return;
                //break;
            }
            scrollUp();
            ++alreadySwiped;
        }
        driver.manage().timeouts().implicitlyWait(Driver.getWaitSec(), TimeUnit.SECONDS);
    }

    private int countElementsXPathLocator(String xPathLocator) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return driver.findElements(By.xpath(xPathLocator)).size();
    }
}

    /*public void swipeUpToElement(By by, int maxSwipes, int timeOfSwipe, double startPoint, double endPoint) {
        int alreadySwiped = 0;//Кол-во сделанных свайпов
        while (countElementsBy(by) == 0) {
            if (alreadySwiped > maxSwipes) {
                waits.waitForElementPresent(by, 1);
                return;
            }
            swipe(timeOfSwipe, startPoint, endPoint);
            ++alreadySwiped;
        }
    }

    private int countElementsBy(By by) {
        return driver.findElements(by).size();
    }
    */
