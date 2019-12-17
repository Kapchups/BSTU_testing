package project.form;

import framework.utils.ConfigReader;
import framework.utils.LogUtils;
import project.models.ReservationData;

public class Reservation {
    ReservationData reservationData =new ReservationData();

    public void setMail_contact() {
        LogUtils.info(String.format("Set mail contact"));
        reservationData.setMail_contact(ConfigReader.getTestData("emailcontact"));
    }

    public void setFirstname() {
        LogUtils.info(String.format("Set firstname"));
        reservationData.setFirstname(ConfigReader.getTestData("firstname"));
    }

    public void setLastname() {
        LogUtils.info(String.format("Set lastname"));
        reservationData.setLastname(ConfigReader.getTestData("lastname"));
    }

    public void setPhoneNumber() {
        LogUtils.info(String.format("Set phonenumber"));
        reservationData.setPhoneNumber(ConfigReader.getTestData("phonenumber"));
    }

    public String getMail_contact() {
        return reservationData.getMail_contact();
    }

    public String getFirstname() {
        return reservationData.getFirstname();
    }

    public String getLastname() {
        return reservationData.getLastname();
    }

    public String getPhoneNumber() {
        return reservationData.getPhoneNumber();
    }

}
