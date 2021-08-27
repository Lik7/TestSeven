import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.*;
import java.util.stream.Collectors;

public class TestMet {


    public static void main(String[] args) {
        System.out.println(Color.RED.getCode());        // #FF0000
        System.out.println(Color.GREEN.getCode());      // #00FF00


    }
}

enum Color {
    RED("#FF0000"), BLUE("#0000FF"), GREEN("#00FF00");
    private String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
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
