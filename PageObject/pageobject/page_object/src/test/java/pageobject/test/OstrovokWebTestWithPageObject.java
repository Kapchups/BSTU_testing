package pageobject.test;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.page.*;

public class OstrovokWebTestWithPageObject {

    private WebDriver driver;

    @Before
    public void before() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        driver.close();
    }

    @Test
    public void LoginNonRegisterUser() {
        StartPage pg =new StartPage(driver)
                .AuthButton();

        LoginUser user = new LoginUser(driver)
                .typeUsername("marchukvalery@mail.ru")
                .typePassword("123456789")
                .submitLogin();


        Assert.assertTrue(user.AssertErrorAuthorization()>0);
    }

    @Test
    public void SavePromotionalCodeWithAnEmptyField() {
        StartPage pg =new StartPage(driver)
                .MenuButton()
                .MenuButtonSavePromotionalCode();

        PromotionalCode codeEmty = new PromotionalCode(driver)
                .WaitWindowWithPromotionalCode()
                .ButtonSavePromotionalCode();

        Assert.assertTrue(codeEmty.AssertErrorPromotionalCode()>0);

    }

}

