package project.pageObject;

import framework.elements.Button;
import framework.elements.CheckBox;
import framework.elements.TextBox;
import framework.elements.View;
import framework.utils.LogUtils;
import org.openqa.selenium.By;
import project.form.SearchMenu;


public class SearchPage {
    private TextBox LocationText = new TextBox(By.xpath("//input[@placeholder='Город, отель или аэропорт']"), "Location hotel");
    private TextBox ArrivalDate= new TextBox(By.xpath("//div[@class='SearchForm__dates--3XSQc SearchForm__control--2yett']//label[1]"), "ArrivalDate");
    //private TextBox DateOfDeparture=new TextBox(By.xpath("//div[@class='SearchForm__dates--3XSQc SearchForm__control--2yett']//label[2]"),"DateOfDeparture");
    private Button DateOf = new Button(By.xpath("//div[@class='Grid__months--27ael']//div[1]//div[5]//div[3]"), "DateOf");
    private Button DateTo = new Button(By.xpath("//div[@class='Grid__months--27ael']//div[1]//div[5]//div[6]"), "DateTo");
    private TextBox Numbers=new TextBox(By.xpath("//label[@class='Input__wrapper--2qhVw Input__wrapper_size_m--1HDVA Input__wrapper_wide--163Tq Guests__input--2xDhO']"),"Numbers");

    private Button SaveCountPeoples = new Button(By.xpath("//button[@class='Button__button--3r3W1 Button__button_size_m--SWi_Y Button__button_wide--32aja Form__button--n9lak']"), "button Save Count Peoples");
    private CheckBox OtherPrices =new CheckBox(By.xpath("//div[@class='Default__fakeCheckbox--1dBf1 Default__fakeCheckbox_checked--1nCGM']"), "checkbox Other Prices");
    private CheckBox Relaxation =new CheckBox(By.xpath("//div[@class='B2CExtra__tripType--_MUwJ']//label[1]//div[1]"), "checkbox Relaxation");
    private Button Submit = new Button(By.xpath("//button[@class='Button__button--3r3W1 Button__button_size_m--SWi_Y Button__button_wide--32aja']"), "button Submit");
    private View ViewNoHotels = new View(By.xpath("//div[@class='zen-hotels-emptyserp']"), "view no Hotels");
    private View ViewHotels = new View(By.xpath("//div[@class='zen-hotels-serpresult']"), "view Hotels");


    SearchMenu searchMenu = new SearchMenu();

    public boolean isHotelPageDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", ViewNoHotels.getNameOfElement()));
        return ViewNoHotels.isDisplayed();
    }

    public void setLocation()
    {
        searchMenu.setLocation();
    }

    public void clickLocation() {
        LogUtils.info(String.format("Click %s .", LocationText.getNameOfElement()));
        LocationText.waitElementToBeClickable();
        LocationText.click();
    }

    public void sendKeysOnLocation() throws InterruptedException {
        LogUtils.info(String.format("Enter %s .", LocationText.getNameOfElement()));
        LocationText.SendKeys(searchMenu.getLocation());
        Thread.sleep(2000);
        LocationText.SendKeysEnter();
    }

    public void clickArrivalDate(){
        LogUtils.info(String.format("Click %s .", ArrivalDate.getNameOfElement()));
        ArrivalDate.waitElementToBeClickable();
        ArrivalDate.click();
    }

    public void enterDateOf() {
        LogUtils.info(String.format("Enter %s .", DateOf.getNameOfElement()));
        DateOf.waitElementToBeClickable();
        DateOf.click();
    }

    public void enterDateTo() {
        LogUtils.info(String.format("Enter %s .", DateTo.getNameOfElement()));
        DateTo.waitElementToBeClickable();
        DateTo.click();
    }

    public void clickNumbers(){
        LogUtils.info(String.format("Click %s .", Numbers.getNameOfElement()));
        Numbers.waitElementToBeClickable();
        Numbers.click();
    }

    public void saveCountPeoples() {
        LogUtils.info(String.format("Click %s .", SaveCountPeoples.getNameOfElement()));
        SaveCountPeoples.waitElementToBeClickable();
        SaveCountPeoples.click();
    }

    public void clickOtherPrices() {
        LogUtils.info(String.format("Click %s .", OtherPrices.getNameOfElement()));
        OtherPrices.waitElementToBeClickable();
        OtherPrices.click();
    }

    public void clickRelaxation() {
        LogUtils.info(String.format("Click %s .", Relaxation.getNameOfElement()));
        Relaxation.waitElementToBeClickable();
        Relaxation.click();
    }

    public void clickSubmit() {
        LogUtils.info(String.format("Click %s .", Submit.getNameOfElement()));
        Submit.waitElementToBeClickable();
        Submit.click();
    }

    public int AssertViewNoHotels(){
        LogUtils.info(String.format(ViewNoHotels.getNameOfElement()));
        ViewNoHotels.waitVisibilityOfElement();
        if (ViewHotels.size()>0)
        {
            LogUtils.error("No hotels");
        }
        return ViewNoHotels.size();
    }
    public int AssertViewHotels(){
        LogUtils.info(String.format(ViewHotels.getNameOfElement()));
        ViewHotels.waitVisibilityOfElement();
        return ViewHotels.size();
    }
}
