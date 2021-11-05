package pages.buyAirTicket;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BuyAirTicket {
    AndroidDriver driver;

    public BuyAirTicket(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private String getMonthNameFormatMMM() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM");
        LocalDateTime dateTime = LocalDateTime.now();
        String selectedReceiptDate = dateTime.format(formatter);
        //System.out.println("Test - " + selectedReceiptDate);
        return selectedReceiptDate;
    }
}

