package rentalCar;

import base.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.menu.Sidebar;
import pages.rentalCar.BuyOrBookCarScreen;
import pages.rentalCar.RentalCarScreen;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Использовал AssertJ для нескольких проверок в одном тесте

public class RentalCarTest extends BaseTest {

    String location = "Пулково";
    String selectedReceiptDate;//дата получения
    String selectedReceiptTime = "17:30";//время получения
    String addTimeOfReceipt = "35";
    String selectedReturnDate;//дата возврата
    String selectedReturnTime = "12:00";//время возврата
    int amountOfRentalDays = 3;//на сколько дней арендуется авто

    @Test (description = "Проверяем заполнение формы для аренды авто")
    public void rentalCarTest() {

        Sidebar sidebar = homeScreen.clickMenuBtn();
        RentalCarScreen rentalCar = sidebar.clickMenuAutoBtn();
        rentalCar.clickPlaceOfReceiptField();//тап в поле Место получения
        rentalCar.enterFromLocation(location);//ввод локации откуда
        rentalCar.clickDateOfReceiptField();//тап в поле Дата получения
        rentalCar.selectDateReceiptOfCar();//установка даты получения
        rentalCar.selectDateReturnOfCar(amountOfRentalDays);//установка даты возврата
        rentalCar.setTimeOfReceipt(addTimeOfReceipt);//установка времени возврата
        rentalCar.clickSelectBtn();//нажать кнопку Выбрать в календаре
        addRentalPeriod(amountOfRentalDays);

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
        //softAsserts.assertAll();

        BuyOrBookCarScreen buyOrBookCarScreen = rentalCar.clickSearchBtn();//нажимаю кнопку Найти в форме аренды авто
        softAsserts.assertThat(buyOrBookCarScreen.getTitleName())
                .withFailMessage("Ошибка в названии экрана:\nact: " + buyOrBookCarScreen.getTitleName() + " \nexp: " + "Купить или забронировать")
                .isEqualTo("Купить или забронировать");
        softAsserts.assertThat(buyOrBookCarScreen.getNameOfBlockSelectionCar())
                .withFailMessage("Ошибка в названии блока выбора авто:\nact: " + buyOrBookCarScreen.getNameOfBlockSelectionCar() + " \nexp: " + "Выбор авто")
                .isEqualTo("Выбор авто");
        softAsserts.assertAll();

    }

    @Test(description = "Проверяем сообщение в календаре если не выбрана дата")
    public void messageDateNotSelectedTest(){
        Sidebar sidebar = homeScreen.clickMenuBtn();
        RentalCarScreen rentalCar = sidebar.clickMenuAutoBtn();
        rentalCar.clickDateOfReceiptField();//тап в поле Дата получения
        rentalCar.clickSelectBtn();//нажать кнопку Выбрать в календаре
        Assert.assertEquals(rentalCar.checkMessageDateNotSelected(), true, "Сообщение, что дата не выбрана не отображается");
    }

    //метод задает даты (сегодня и завтра) получения и возврата авто для проверки в assert
    private void addRentalPeriod(Integer amountOfRentalDays) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM, E");
        LocalDateTime dateTime = LocalDateTime.now();// сегодня

        selectedReceiptDate = dateTime.format(formatter);
        System.out.println("Test - дата получения " + selectedReceiptDate);

        selectedReturnDate = dateTime.plusDays(amountOfRentalDays).format(formatter);
        System.out.println("Test - дата возврата " + selectedReturnDate);
    }
}
