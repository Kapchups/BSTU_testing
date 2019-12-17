package project.pageObject;

import framework.elements.Label;
import framework.elements.TextBox;
import framework.utils.ConfigReader;
import framework.utils.LogUtils;
import org.openqa.selenium.By;
import project.form.LoginUser;
import project.models.Users;

public class AuthorizationPage {

    private TextBox Username = new TextBox(By.xpath("//div[@class='zenforminput zenforminput-size-m']//label[@class='zenforminput-inner']"), "Username TextBox");
    private TextBox Password = new TextBox(By.xpath("//div[@class='zenforminput zenforminput-size-m zenforminput-has-button']//label[@class='zenforminput-inner']"), "Password TextBox");
    private TextBox LoginButton = new TextBox(By.xpath("//button[contains(@class,'zen-authpane-signin-submit-button button-view-primary button-size-s')]"), "Login Button");
    private Label InvalidPassword = new Label(By.xpath("//div[@class='zen-authpane-signin-error-message']"), "Invalid password");

    LoginUser loginUser = new LoginUser();

    public  void setUser(){
        LogUtils.info("Set values user");
        loginUser.setUsername();
        loginUser.setPassword();
    }

    public boolean isAuthorizationPageDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", LoginButton.getNameOfElement()));
        return LoginButton.isDisplayed();
    }

    public void typeUsername() {
        LogUtils.info(String.format("Enter %s .", Username.getNameOfElement()));
        Username.waitElementToBeClickable();
        Username.SendKeys(loginUser.getUsername());
    }

    public void typePassword() {
        LogUtils.info(String.format("Enter %s .", Password.getNameOfElement()));
        Password.waitElementToBeClickable();
        Password.SendKeys(loginUser.getPassword());
    }

    public void submitLogin() {
        LogUtils.info(String.format("Click %s .", LoginButton.getNameOfElement()));
        LoginButton.waitElementToBeClickable();
        LoginButton.click();
    }

    public int AssertErrorUsername(){
        LogUtils.info(String.format(Username.getNameOfElement()));
        Username.waitVisibilityOfElement();
        return Username.size();
    }

    public int AssertErrorPassword(){
        LogUtils.info(String.format(Password.getNameOfElement()));
        Password.waitVisibilityOfElement();
        return Password.size();
    }

    public int AssertErrorAuthorization(){
        LogUtils.info(String.format(InvalidPassword.getNameOfElement()));
        InvalidPassword.waitVisibilityOfElement();
        return LoginButton.size();
    }

}
