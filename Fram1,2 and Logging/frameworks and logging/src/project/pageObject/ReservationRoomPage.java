package project.pageObject;

import framework.elements.Button;
import framework.elements.TextBox;
import framework.elements.View;
import framework.utils.LogUtils;
import org.openqa.selenium.By;
import project.form.Reservation;

public class ReservationRoomPage {

    private TextBox mail = new TextBox(By.xpath("//div[@class='zen-booking-contacts-form-main-field zen-booking-contacts-form-main-field-email']//label[@class='zenforminput-inner']"), "Mail TextBox");
    private TextBox firstname = new TextBox(By.xpath("//div[@class='zen-booking-contacts-form-main-field zen-booking-contacts-form-main-field-firstname']//label[@class='zenforminput-inner']"), "FirstName TextBox");
    private TextBox lastname = new TextBox(By.xpath("//div[@class='zen-booking-contacts-form-main-field zen-booking-contacts-form-main-field-lastname']//label[@class='zenforminput-inner']"), "LastName TextBox");
    private TextBox phonenumber = new TextBox(By.xpath("//div[@class='zen-booking-contacts-form-main-field zen-booking-contacts-form-main-field-phone']//label[@class='zenforminput-inner']"), "PhoneNumber TextBox");
    private View view_data_credit_card = new View(By.xpath("//div[@class='zen-booking-creditcard-main']"), "view data Credit Card");
    private Button Continue = new Button(By.xpath("//button[@class='zen-booking-stepbar-continue button-view-primary button-size-m']"), "button continue");

    Reservation reservation = new Reservation();

    public boolean isDataCreditCardDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", view_data_credit_card.getNameOfElement()));
        return view_data_credit_card.isDisplayed();
    }

    public  void setUserReservation(){
        LogUtils.info("Set values UserReservation");
        reservation.setMail_contact();
        reservation.setFirstname();
        reservation.setLastname();
        reservation.setPhoneNumber();
    }

    public void EnterMail_Contact() {
        LogUtils.info(String.format("Enter %s .", mail.getNameOfElement()));
        mail.waitElementToBeClickable();
        mail.SendKeys(reservation.getMail_contact());
    }

    public void EnterFirstname() {
        LogUtils.info(String.format("Enter %s .", firstname.getNameOfElement()));
        firstname.waitElementToBeClickable();
        firstname.SendKeys(reservation.getFirstname());
    }

    public void EnterLastname() {
        LogUtils.info(String.format("Enter %s .", lastname.getNameOfElement()));
        lastname.waitElementToBeClickable();
        lastname.SendKeys(reservation.getLastname());
    }

    public void EnterPhoneNumber() {
        LogUtils.info(String.format("Enter %s .", phonenumber.getNameOfElement()));
        phonenumber.waitElementToBeClickable();
        phonenumber.SendKeys(reservation.getPhoneNumber());
    }

    public void clickContinue() {
        LogUtils.info(String.format("Click %s .", Continue.getNameOfElement()));
        Continue.waitElementToBeClickable();
        Continue.click();
    }

}
