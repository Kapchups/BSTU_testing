package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PromotionalCode extends Page {

    public PromotionalCode(WebDriver driver) {
        super(driver);
    }

    public PromotionalCode WaitWindowWithPromotionalCode()
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='zen-promopopup-inner']")));
        return this;
    }

    public PromotionalCode ButtonSavePromotionalCode()
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='zen-promopopup-button button-view-primary button-size-s']")));
        driver.findElement(By.xpath("//button[@class='zen-promopopup-button button-view-primary button-size-s']")).click();
        return this;
    }

    public int AssertErrorPromotionalCode(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='zenforminput-errormessage']")));
        return driver.findElements(By.xpath("//p[@class='zenforminput-errormessage']")).size();
    }
}
