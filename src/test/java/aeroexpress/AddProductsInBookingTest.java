package aeroexpress;

import base.BaseTest;
import generalActions.pay.PayScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.aeroexpress.AddBuyAEScreen;
import pages.insurance.InsuranceScreen;
import pages.myBooking.DetailOfBookingScreen;

public class AddProductsInBookingTest extends BaseTest {

    @Test(description = "Докупка АЕ в бронь")
    public void addAEInBookingTest() {
        DetailOfBookingScreen detailOfBook = homeScreen.clickCityInBookingCard();//переход в детали брони
        //detailOfBook.clickFieldAEInBannerAE();
        AddBuyAEScreen addBuyAEScreen = detailOfBook.fieldAEInBannerAEClick();
        addBuyAEScreen.clickSafeBtn();
        addBuyAEScreen.fillPaymentDetails();
        addBuyAEScreen.tapPayBtn();
        addBuyAEScreen.clickOkBtn();

        Assert.assertEquals(detailOfBook.aeroexpressIconIsDisp(), true, "В брони не отображается баннер купленного АЕ");
    }

    @Test(description = "")
    public void addAEInBookingTestt() {
        DetailOfBookingScreen detailOfBook = homeScreen.clickCityInBookingCard();
        detailOfBook.aeroexpressIconIsDisp();

        Assert.assertEquals(detailOfBook.aeroexpressIconIsDisp(), true, "В брони не отображается баннер купленного АЕ");
    }

    @Test
    public void addInsTest() {
        DetailOfBookingScreen detailOfBook = homeScreen.clickCityInBookingCard();
        detailOfBook.scrollToPeaceInTripText();
        //detailOfBook.swipeToInsSlider();
        InsuranceScreen insuranceScreen = detailOfBook.notLeavingInsNameClick();
        PayScreen payScreen = insuranceScreen.addBtnClick();
        payScreen.paySavedBankCard();
        insuranceScreen.clickOkBtn();
    }
}
