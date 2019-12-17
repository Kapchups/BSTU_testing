package project.test;

import framework.browser.Browser;
import framework.utils.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.form.AddCountPeoples;
import project.pageObject.HotelsPage;
import project.pageObject.ReservationRoomPage;
import project.pageObject.SearchPage;

public class RoomReservation extends Base {

    private SearchPage searchPage;
    private AddCountPeoples addCountPeoples;
    private HotelsPage hotelsPage;
    private ReservationRoomPage reservationRoomPage;

    @Test
    public void RoomReservation() throws InterruptedException {
        searchPage = new SearchPage();
        addCountPeoples = new AddCountPeoples();
        hotelsPage = new HotelsPage();
        reservationRoomPage = new ReservationRoomPage();

        LogUtils.info("Setup location");
        searchPage.clickLocation();
        searchPage.setLocation();
        searchPage.sendKeysOnLocation();

        LogUtils.info("Setup Date");
        searchPage.clickArrivalDate();
        searchPage.enterDateOf();
        searchPage.enterDateTo();

        LogUtils.info("Setup count numbers");
        searchPage.clickNumbers();
        addCountPeoples.setCountClickChildren(1);
        searchPage.saveCountPeoples();

        searchPage.clickOtherPrices();
        searchPage.clickRelaxation();
        searchPage.clickSubmit();

        LogUtils.info("Open page hotels");
        Assert.assertTrue(searchPage.isHotelPageDisplayed(), "The hotels page is not opened.");
        LogUtils.info("Check view hotels");
        Assert.assertTrue(searchPage.AssertViewHotels()>0);

        hotelsPage.viewRooms();

        LogUtils.info("Create new tab");
        Browser.switchTab(1);

        hotelsPage.clickViewPrice();

        Assert.assertTrue(hotelsPage.isRoomsDisplayed(), "The rooms is not displayed.");

        hotelsPage.clickReservationRoom();

        reservationRoomPage.setUserReservation();

        reservationRoomPage.EnterMail_Contact();
        reservationRoomPage.EnterFirstname();
        reservationRoomPage.EnterLastname();
        reservationRoomPage.EnterPhoneNumber();

        reservationRoomPage.clickContinue();

        LogUtils.info("Check view data credit card");
        Assert.assertTrue(reservationRoomPage.isDataCreditCardDisplayed(), "The data credit card is not displayed.");

        Browser.getDriver().close();
        Browser.switchTab(0);
        Browser.getDriver().manage().deleteAllCookies();

    }
}
