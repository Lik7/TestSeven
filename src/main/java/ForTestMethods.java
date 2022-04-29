import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForTestMethods {


    public static void main(String[] args) {
        //Swipes s = new Swipes();
        //s.swipeRightToLeft(1);
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM");
        LocalDateTime dateTime = LocalDateTime.now();

        String selectedReceiptDate = dateTime.format(formatter);
        System.out.println("Test - " + selectedReceiptDate);*/

/*
        String str = "123 By";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(str);
        if (m.find()) {
            System.out.println(m.group());
        }*/

String price = "123 By";
getPrice("123 By");
        System.out.println(getPrice("123 By"));

        //Insurance insurance = Insurance.MEDICAL_INSURANCE;
        //System.out.println(Insurance.MEDICAL_INSURANCE.getInsuranceName());


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

    public static int getPrice(String price) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(price);
        String str = null;
        if (m.find()) {
            //System.out.println(m.group());
            str = m.group();
        }
        //System.out.println("Цена из класса Ticket " + price);
        return Integer.parseInt(str);
    }


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