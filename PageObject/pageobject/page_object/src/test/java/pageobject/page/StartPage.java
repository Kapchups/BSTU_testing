package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage extends Page {
    public StartPage(WebDriver driver) {
        super(driver);
        driver.get("https://ostrovok.ru/");
    }

    public StartPage AuthButton()
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='zen-header-account-button']")));
        driver.findElement(By.xpath("//div[@class='zen-header-account-button']")).click();
        return this;
    }

    public StartPage MenuButton()
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='zen-menuburger-button']")));
        driver.findElement(By.xpath("//div[@class='zen-menuburger-button']")).click();
        return this;
    }

    public StartPage MenuButtonSavePromotionalCode()
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='zen-menuburger-pseudolink']")));
        driver.findElement(By.xpath("//span[@class='zen-menuburger-pseudolink']")).click();
        return this;
    }
    public void select() {
        driver.findElement(By.xpath("//div[@class='zen-header-account-button']")).click();
    }
}
