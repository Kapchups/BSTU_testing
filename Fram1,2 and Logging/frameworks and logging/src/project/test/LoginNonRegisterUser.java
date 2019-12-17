package project.test;

import framework.browser.Browser;
import framework.utils.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.form.MainMenu;
import project.pageObject.AuthorizationPage;

public class LoginNonRegisterUser extends Base {

    private AuthorizationPage authorizationPage;
    private MainMenu mainMenu;

    @Test
    public void LoginNonRegisterUser() {
        authorizationPage = new AuthorizationPage();
        mainMenu = new MainMenu();

        mainMenu.clickAuthorizationButton();

        LogUtils.info("Open Authorization Page");
        Assert.assertTrue(authorizationPage.isAuthorizationPageDisplayed(), "The Authorization page is not opened.");


        authorizationPage.setUser();

        authorizationPage.typeUsername();
        Assert.assertTrue(authorizationPage.AssertErrorUsername()>0);
        LogUtils.info("Checked Username on empty");

        authorizationPage.typePassword();
        Assert.assertTrue(authorizationPage.AssertErrorPassword()>0);
        LogUtils.info("Checked Password on empty");

        authorizationPage.submitLogin();

        Assert.assertTrue(authorizationPage.AssertErrorAuthorization()>0);
        Browser.getDriver().manage().deleteAllCookies();
    }
}
