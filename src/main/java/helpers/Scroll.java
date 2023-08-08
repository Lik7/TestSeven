package helpers;

import base.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Scroll extends Swipes {

    //private static AndroidDriver driver = Driver.getDriver();
    private static AppiumDriver driver = Driver.getDriver();

    //Скролл до элемена вниз
    public static void scrollToElementDown(String xPathLocator, int countOfSwipes) {
        scrollToElement(xPathLocator, countOfSwipes, true);
    }

    //Скролл до элемента вверх
    public void scrollToElementUp(String xPathLocator, int countOfSwipes) {
        scrollToElement(xPathLocator, countOfSwipes, false);
    }

    //Скролл до элемента
    private static void scrollToElement(String xPathLocator, int countOfSwipes, boolean b) {
        int alreadySwiped = 0;//Кол-во сделанных свайпов

        while (countDisplayOfElements(xPathLocator) == 0) {
            if (alreadySwiped > countOfSwipes) {
                return;
            }
            if (b == true) {
                swipeDown();
             } else swipeUp();
            ++alreadySwiped;
        }
    }

    //метод скроллит сначала вниз, затем вверх до элемента
    public static void scrollDownUpToElement(String xPathLocator, int countOfSwipes) {
        int alreadySwiped = 0;//Кол-во сделанных свайпов
        int maxDownSwipes = countOfSwipes;
        int maxUpSwipes = countOfSwipes * 3;

        while (countDisplayOfElements(xPathLocator) == 0) {
            if (alreadySwiped == maxDownSwipes) {
                //waits.waitForElementPresent(By.xpath(xPathLocator), 1);
                while (countDisplayOfElements(xPathLocator) == 0) {
                    if (alreadySwiped > maxUpSwipes) {
                        //waits.waitForElementPresent(By.xpath(xPathLocator), 1);
                        return;
                    }
                    swipeUp();
                    ++alreadySwiped;
                }
                return;
            }
            swipeDown();
            ++alreadySwiped;
        }
        //driver.manage().timeouts().implicitlyWait(Driver.getWaitSec(), TimeUnit.SECONDS);
    }

    //свап до элемента без pull to refresh
    public static void scrollUpDownToElement(int countOfSwipes, String... xPathLocator) {
        String str1 = xPathLocator.length > 0 ? xPathLocator[0] : null;
        String str2 = xPathLocator.length > 0 ? xPathLocator[1] : null;
        int alreadySwiped = 0;//Кол-во сделанных свайпов
        int maxUpSwipes = countOfSwipes;
        int maxDownSwipes = countOfSwipes * 3;

        while (countDisplayOfElements(str1) == 0) {
            if (alreadySwiped == maxUpSwipes || ElementIsMissing.elementIsDispXPathLocator(str2)) {
                //waits.waitForElementPresent(By.xpath(xPathLocator), 1);
                while (countDisplayOfElements(str1) == 0) {
                    if (alreadySwiped > maxDownSwipes) {
                        //waits.waitForElementPresent(By.xpath(str1), 1);
                        return;
                    }
                    swipeDown();
                    ++alreadySwiped;
                }
                return;
            }
            swipeUp();
            ++alreadySwiped;
        }
        //driver.manage().timeouts().implicitlyWait(Driver.getWaitSec(), TimeUnit.SECONDS);
    }

    private static int countDisplayOfElements(String xPathLocator) {
        Driver.driverTimeout_1sec();
        int i = driver.findElements(By.xpath(xPathLocator)).size();
        Driver.driverTimeoutDefault();
        return i;
    }

    private static void scrollEl (){

    }

}
