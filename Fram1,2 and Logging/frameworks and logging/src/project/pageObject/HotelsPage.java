package project.pageObject;

import com.sun.org.apache.regexp.internal.RE;
import framework.elements.Button;
import framework.elements.Label;
import framework.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HotelsPage {
    private static WebDriver driver;
    private Button ViewRooms = new Button(By.xpath("//div[@class='zen-hotels-list-wrapper']//div[3]//div[1]//div[1]//div[5]//div[1]//a[1]"), "button view rooms");
    private Button Geoposition = new Button(By.xpath("//button[@id='geoblock']"), "button Geoposition");
    private Label Point =new Label(By.xpath("//div[@class='zen-hotelcardmini-pin']"), "Point on map");
    private Label Map =new Label(By.xpath("//div[@class='zengeoblockmap-container']"), "Map");
    private Button ViewPrice = new Button(By.xpath("//button[@id='geoblock']"), "button ViewPrice");
    private Label ViewRoomsInHotel =new Label(By.xpath("//div[@class='zen-roomspagerooms-inner']"), "view Rooms");
    private Button ReservationRoom = new Button(By.xpath("(//a[contains(@class,'button-view-primary button-size-s zenroomspagerate-button')])[2]"), "button ReservationRoom");

    public boolean isMapDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", Map.getNameOfElement()));
        return Map.isDisplayed();
    }

    public boolean isRoomsDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", ViewRoomsInHotel.getNameOfElement()));
        return ViewRoomsInHotel.isDisplayed();
    }

    public  void viewRooms(){
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

    public void clickGeoposotion(){
        LogUtils.info(String.format("Click %s .", Geoposition.getNameOfElement()));
        Geoposition.waitElementToBeClickable();
        Geoposition.click();
    }

    public int AssertViewPointPosition(){
        LogUtils.info(String.format("Check %s .", Point.getNameOfElement()));
        Point.waitVisibilityOfElement();
        return Point.size();
    }

    public  void clickViewPrice(){
        LogUtils.info(String.format("Click %s .", ViewPrice.getNameOfElement()));
        ViewPrice.waitElementToBeClickable();
        ViewPrice.click();
    }
}
