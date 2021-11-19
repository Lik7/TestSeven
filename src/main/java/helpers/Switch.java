package helpers;

import base.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Switch {
    private AndroidDriver driver = Driver.getDriver();

    String onRu = "ВКЛ";
    String offRu = "ВЫКЛ";

    //метод переводит свич в состояние Вкл
    public void switchON(String locatorID) {
        String str = driver.findElement(By.id(locatorID)).getText();
        System.out.println("Состояние свич: " + str);
        if (offRu.equalsIgnoreCase(str)) {
            driver.findElement(By.id(locatorID)).click();
        }
    }

    //метод переводит свич в состояние Выкл
    public void switchOFF(String locatorID) {
        String str = driver.findElement(By.id(locatorID)).getText();
        System.out.println("Состояние свич 'Согласен с условиями': " + str);
        if (onRu.equalsIgnoreCase(str)) {
            driver.findElement(By.id(locatorID)).click();
        }
    }
}
