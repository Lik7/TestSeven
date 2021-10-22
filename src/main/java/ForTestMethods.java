import base.AppiumServer;
import enums.AirportData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.*;
import java.util.stream.Collectors;

public class ForTestMethods {


   // public static void main(String[] args) {
        //System.out.println(Color.RED.getCode());        // #FF0000
        //System.out.println(Color.GREEN.getCode());      // #00FF00
        //AppiumServer ap = new AppiumServer();
        //ap.startServer();
        // ap.stopServer();
        /*AirportData AD = AirportData.LED;
        System.out.println(AD.getCity() + AD.getNameEN());
        AppiumServer.stopServer();*/

    public static void main(String[] args) throws InterruptedException {
        AppiumServer appiumServer = new AppiumServer();
        appiumServer.startServer();
        Thread.sleep(5000);
        //System.out.println("appium Server Started");
        appiumServer.stopServer();
        System.out.println("appium Server Stopped");


    }
    }






        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM, E");
        LocalDateTime dateTime = LocalDateTime.now();

        String selectedReceiptDate = dateTime.format(formatter);
        System.out.println("Test - " + selectedReceiptDate);

        int amountOfRentalDays = 3;
        String selectedReturnDate = dateTime.plusDays(amountOfRentalDays).format(formatter);
        System.out.println("Test - " + selectedReturnDate);
    }*/
