package project.test;

import framework.browser.Browser;
import framework.utils.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.form.AddCountPeoples;
import project.pageObject.SearchPage;

public class OneHotelRoomForTenGuests extends Base {

    private SearchPage searchPage;
    private AddCountPeoples addCountPeoples;

    @Test
    public void OneHotelRoomForTenGuests() throws InterruptedException {
        searchPage = new SearchPage();
        addCountPeoples = new AddCountPeoples();

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
        addCountPeoples.setCountClickChildren(4);
        addCountPeoples.setCountClickAdults(4);
        searchPage.saveCountPeoples();

        searchPage.clickOtherPrices();
        searchPage.clickRelaxation();
        searchPage.clickSubmit();

        LogUtils.info("Open page hotels");
        Assert.assertTrue(searchPage.isHotelPageDisplayed(), "The hotels page is not opened.");
        LogUtils.info("Check view hotels");
        Assert.assertTrue(searchPage.AssertViewNoHotels()>0);
        Browser.getDriver().manage().deleteAllCookies();
    }
}
