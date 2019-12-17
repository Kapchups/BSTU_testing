package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginUser extends Page {
    By usernameLocator = By.xpath("//div[@class='zenforminput zenforminput-size-m']//label[@class='zenforminput-inner']");
    By passwordLocator = By.xpath("//div[@class='zenforminput zenforminput-size-m zenforminput-has-button']//label[@class='zenforminput-inner']");
    By loginButtonLocator = By.xpath("//button[contains(@class,'zen-authpane-signin-submit-button button-view-primary button-size-s')]");


    public LoginUser(WebDriver driver) {
        super(driver);

    }

    public LoginUser typeUsername(String username) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(usernameLocator));
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginUser typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public LoginUser submitLogin() {
        driver.findElement(loginButtonLocator).click();
        return this;
    }

    public int AssertErrorAuthorization(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='zen-authpane-signin-error-message']")));
        return driver.findElements(By.xpath("//div[@class='zen-authpane-signin-error-message']")).size();
    }
}

