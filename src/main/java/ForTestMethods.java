import enums.Dates;
import helpers.Swipes;
import sun.security.mscapi.CPublicKey;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ForTestMethods {


    public static void main(String[] args) {
        //Swipes s = new Swipes();
        //s.swipeRightToLeft(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM");
        LocalDateTime dateTime = LocalDateTime.now();

        String selectedReceiptDate = dateTime.format(formatter);
        System.out.println("Test - " + selectedReceiptDate);



    /*public static void main(String[] args) throws InterruptedException {
        AppiumServer appiumServer = new AppiumServer();
        appiumServer.startServer();
        Thread.sleep(5000);
        //System.out.println("appium Server Started");
        appiumServer.stopServer();
        System.out.println("appium Server Stopped");
    }*/
    }
//}

    public void data() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
        LocalDateTime dateTime = LocalDateTime.now();

        String selectedReceiptDate = dateTime.format(formatter);
        System.out.println("Test - " + selectedReceiptDate);

       /* int amountOfRentalDays = 3;
        String selectedReturnDate = dateTime.plusDays(amountOfRentalDays).format(formatter);
        System.out.println("Test - " + selectedReturnDate);*/
    }
}