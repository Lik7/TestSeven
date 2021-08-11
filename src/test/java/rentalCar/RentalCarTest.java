package rentalCar;

import base.BaseSetup;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomeScreen;
import pages.menu.Sidebar;
import pages.rentalCar.RentalCar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//Использовал AssertJ для нескольких проверок в одном тесте
public class RentalCarTest extends BaseSetup {

    String location = "Пулково";
    String selectedReceiptDate;//дата получения
    String selectedReceiptTime = "17:30";//время получения
    String addTimeOfReceipt = "35";
    String selectedReturnDate;//дата возврата
    String selectedReturnTime = "12:00";//время возврата

    @Test
    public void rentalCarTest() {
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.clickMenuBtn();//нажимаю кнопку Меню
        Sidebar sidebar = new Sidebar();
        sidebar.clickMenuAutoBtn();//нажимаю кнопку Меню - Авто
        RentalCar rentalCar = new RentalCar(BaseSetup.setUpDriver());
        rentalCar.clickPlaceOfReceiptField();//тап в поле Место получения
        rentalCar.enterFromLocation(location);//ввод локации откуда
        rentalCar.clickDateOfReceiptField();//тап в поле Дата получения
        rentalCar.selectDateReceiptOfCar();//установка даты получения
        rentalCar.selectDateReturnOfCar();//установка даты возврата
        rentalCar.setTimeOfReceipt(addTimeOfReceipt);//установка времени возврата
        rentalCar.clickSelectBtn();//нажать кнопку Выбрать в календаре
        addRentalPeriod();

        SoftAssertions softAsserts = new SoftAssertions();
        softAsserts.assertThat(rentalCar.getPlaceOfReceiptField())
                .withFailMessage("Ошибка в локации")
                .isEqualTo(location);
        softAsserts.assertThat(rentalCar.getSelectedReceiptDate().replace("\u00A0", " "))
                .withFailMessage("Ошибка в дате получения")
                .isEqualTo(selectedReceiptDate);
        softAsserts.assertThat(rentalCar.getSelectedReceiptTime())
                .withFailMessage("Ошибка в времени получения: \nact: " + rentalCar.getSelectedReceiptTime() + " \nexp: " + selectedReceiptTime)
                .isEqualTo(selectedReceiptTime);
        softAsserts.assertThat(rentalCar.getSelectedReturnDate().replace("\u00A0", " "))
                .withFailMessage("Ошибка в дате возврата")
                .isEqualTo(selectedReturnDate);
        softAsserts.assertThat(rentalCar.getSelectedReturnTime())
                .withFailMessage("Ошибка в времени возврата:\nact: " + rentalCar.getSelectedReturnTime() + " \nexp: " + selectedReturnTime)
                .isEqualTo(selectedReturnTime);
        softAsserts.assertAll();
/*        Assert.assertEquals(rentalCar.getPlaceOfReceiptField(), location, "Ошибка в локации");
        Assert.assertEquals(rentalCar.getSelectedReceiptDate().replace("\u00A0", " "), selectedReceiptDate, "Ошибка в дате получения");
        Assert.assertEquals(rentalCar.getSelectedReceiptTime(), selectedReceiptTime, "Ошибка в времени получения");
        Assert.assertEquals(rentalCar.getSelectedReturnDate().replace("\u00A0", " "), selectedReturnDate, "Ошибка в дате возврата");
        Assert.assertEquals(rentalCar.getSelectedReturnTime(), selectedReturnTime, "Ошибка в времени возврата");*/
    }

    //метод задает даты (сегодня и завтра) получения и возврата авто для проверки в assert
    private void addRentalPeriod() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM, E");
        Calendar cal = Calendar.getInstance();
        String todayDate = dateFormat.format(cal.getTime());
        System.out.println(todayDate);
        selectedReceiptDate = todayDate;
        cal.add(Calendar.DATE, +1);
        System.out.println(dateFormat.format(cal.getTime()));
        selectedReturnDate = dateFormat.format(cal.getTime());
    }

}
