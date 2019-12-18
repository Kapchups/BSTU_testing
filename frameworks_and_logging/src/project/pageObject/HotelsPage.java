package project.pageObject;

import com.sun.org.apache.regexp.internal.RE;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import framework.elements.View;
import framework.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import project.form.Sort;
import project.models.Filtration;
import project.models.Price;
import project.models.PriceSorter;

import java.lang.reflect.Array;
import java.util.*;

import static javafx.scene.input.KeyCode.T;

public class HotelsPage {

    private Button ViewRooms = new Button(By.xpath("//div[@class='zen-hotels-list-wrapper']//div[3]//div[1]//div[1]//div[5]//div[1]//a[1]"), "button view rooms");
    private Button Geoposition = new Button(By.xpath("//button[@id='geoblock']"), "button Geoposition");
    private Label Point = new Label(By.xpath("//div[@class='zen-hotelcardmini-pin']"), "Point on map");
    private Label Map = new Label(By.xpath("//div[@class='zengeoblockmap-container']"), "Map");
    private Button ViewPrice = new Button(By.xpath("//button[@id='geoblock']"), "button ViewPrice");
    private Label ViewRoomsInHotel = new Label(By.xpath("//div[@class='zen-roomspagerooms-inner']"), "view Rooms");
    private Button ReservationRoom = new Button(By.xpath("(//a[contains(@class,'button-view-primary button-size-s zenroomspagerate-button')])[2]"), "button ReservationRoom");
    private Label distation = new Label(By.xpath("//div[@class='zen-hotelcard-location-value']"), "distation label");
    private TextBox EnterDistation = new TextBox(By.xpath("//div[@class='zen-filter-indicator-input']//label[@class='zenforminput-inner']"), "EnterDistation Button");
    private Label LabelDistation =new Label(By.xpath("(//input[@class='zenforminput-control'])[4]"), "Disatation label");
    private Label Price=new Label(By.xpath("//div[@class='zen-hotelcard-rate-price-value']"), "Price label");
    private View SortList = new View(By.xpath("//p[@class='zenformselect-value']"), "button SortList");
    private Button PriceSort = new Button(By.xpath("//li[@class='zendropdownlist-item zendropdownlist-item-price.asc']"), "button price sort");


    public boolean isMapDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", Map.getNameOfElement()));
        return Map.isDisplayed();
    }

    public ArrayList<WebElement> getAllPricesBefore() {
        return Price.findElements();
    }

    public ArrayList<WebElement> getAllPricesAfter() {
        return Price.findElements();
    }

    public List<Price> getPricesBefore()
    {
        ArrayList<Price> priceList1 = new ArrayList<>();

        for (WebElement element : getAllPricesBefore())
        {
            int price_length=Price.getText().length();
            Price price=new Price();
            price.setPricebefore(Integer.parseInt(element.getText().substring(0, price_length-4)));
            LogUtils.info("Add price in price list1.");
            priceList1.add(price);
        }

        PriceSorter priceSorter = new PriceSorter(priceList1);
        ArrayList<Price> sortedPrice1 = priceSorter.getSortedPriceBefore();

        return sortedPrice1;
    }

    public List<Price> getPricesAfter()
    {
       // clickSorted();
        ArrayList<Price> priceList2 = new ArrayList<>();

        for (WebElement element : getAllPricesAfter())
        {
            int price_length=Price.getText().length();
            Price price=new Price();
            price.setPriceafter(Integer.parseInt(element.getText().substring(0, price_length-4)));
            LogUtils.info("Add price in price list2.");
            priceList2.add(price);
        }

        PriceSorter priceSorter = new PriceSorter(priceList2);
        ArrayList<Price> sortedPrice2 = priceSorter.getSortedPriceAfter();

        return sortedPrice2;
    }

    public boolean equalsPricesList()
    {
            if(getPricesBefore().equals(getPricesAfter())){
                LogUtils.info("Equals prices return false");
                return false;
            }
            else{
                LogUtils.info("Equals prices return true");
                return true;
            }
    }

    public ArrayList<WebElement> getAllDistations() {
       return distation.findElements();
    }

    public List<Filtration> getDistations()
    {
        ArrayList<Filtration> filtrationList = new ArrayList<>();

        for (WebElement element : getAllDistations())
        {
            Filtration filtration = new Filtration();
            if(element.getText().contains("км")) {
                filtration.setRasstoyanie(Integer.parseInt(element.getText().substring(0, 1)));
                LogUtils.info("Add distation in filtration list.");
                filtrationList.add(filtration);
            }
            else
            {
                filtration.setRasstoyanie(1);
                filtrationList.add(filtration);
            }
        }
        return filtrationList;
    }

    public boolean equalsDistations()
    {
        for (Filtration filtration : getDistations()) {
            int dist_length=LabelDistation.getAttribute("value").length();
            if(filtration.getRasstoyanie() > Integer.parseInt(LabelDistation.getAttribute("value").substring(0,dist_length-3))){
                LogUtils.info("Equals distations return false");
                return false;
            }
        }
        LogUtils.info("Equals distations return true");
        return true;
    }

    public boolean isRoomsDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", ViewRoomsInHotel.getNameOfElement()));
        return ViewRoomsInHotel.isDisplayed();
    }

    public void viewRooms() {
        LogUtils.info(String.format("Click %s .", ViewRooms.getNameOfElement()));
        ViewRooms.waitElementToBeClickable();
        ViewRooms.click();
    }

    public void clickReservationRoom() throws InterruptedException {
        ReservationRoom.hoverElement();
        LogUtils.info(String.format("Click %s .", ReservationRoom.getNameOfElement()));

        ReservationRoom.waitElementToBeClickable();
        Thread.sleep(2000);
        ReservationRoom.click();
    }

    public void clickGeoposotion() {
        LogUtils.info(String.format("Click %s .", Geoposition.getNameOfElement()));
        Geoposition.waitElementToBeClickable();
        Geoposition.click();
    }

    public void EnterDistation(String distation) {
        LogUtils.info(String.format("Enter %s .", EnterDistation.getNameOfElement()));
        EnterDistation.waitElementToBeClickable();
        EnterDistation.click();
        EnterDistation.SendKeys(distation);
        EnterDistation.SendKeysEnter();
    }

    public int AssertViewPointPosition() {
        LogUtils.info(String.format("Check %s .", Point.getNameOfElement()));
        Point.waitVisibilityOfElement();
        return Point.size();
    }

    public void clickViewPrice() {
        LogUtils.info(String.format("Click %s .", ViewPrice.getNameOfElement()));
        ViewPrice.waitElementToBeClickable();
        ViewPrice.click();
    }

    public void clickSorted() {
        LogUtils.info(String.format("Click %s .", SortList.getNameOfElement()));
        SortList.waitElementToBeClickable();
        SortList.click();
        LogUtils.info(String.format("Click %s .", PriceSort.getNameOfElement()));
        PriceSort.waitElementToBeClickable();
        PriceSort.click();
    }
}
