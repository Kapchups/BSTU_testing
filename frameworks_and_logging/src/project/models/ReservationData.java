package project.models;

public class ReservationData {
    private String mail_contact;
    private String firstname;
    private String lastname;
    private String PhoneNumber;

    public String getMail_contact() {
        return mail_contact;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public String getPhoneNumber(){
        return PhoneNumber;
    }

    public void setMail_contact(String mail_contact) {
        this.mail_contact=mail_contact;
    }

    public void setFirstname(String firstname) {
        this.firstname=firstname;
    }

    public void setLastname(String lastname) {
        this.lastname=lastname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber=phoneNumber;
    }
}
