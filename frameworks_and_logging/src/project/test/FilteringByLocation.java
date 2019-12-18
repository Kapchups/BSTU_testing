package project.test;

import framework.browser.Browser;
import framework.utils.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.form.AddCountPeoples;
import project.pageObject.HotelsPage;
import project.pageObject.SearchPage;

public class FilteringByLocation extends Base {

    private SearchPage searchPage;
    private AddCountPeoples addCountPeoples;
    private HotelsPage hotelsPage;

    @Test
    public void FilteringByLocation() throws InterruptedException {
        searchPage = new SearchPage();
        addCountPeoples = new AddCountPeoples();
        hotelsPage = new HotelsPage();
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
        hotelsPage.EnterDistation("5");
        Browser.getDriver().navigate().refresh();
        Assert.assertTrue(hotelsPage.equalsDistations());
        Browser.getDriver().manage().deleteAllCookies();


    }
}
