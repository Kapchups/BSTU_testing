package project.pageObject;

import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import framework.utils.LogUtils;
import org.openqa.selenium.By;

public class PromotionalCodePage {

    private Button ButtonSavePromotionalCode = new Button(By.xpath("//button[@class='zen-promopopup-button button-view-primary button-size-s']"), "button SavePromotionalCode");
    private Label ErrorMessage = new Label(By.xpath("//p[@class='zenforminput-errormessage']"), "Error message promotional code");
    private TextBox EnterPromotionalCode=new TextBox(By.xpath("//input[@id='goog_32453750']"),"field PromotionalCode");

    public boolean isPromotionalCodePageDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", ButtonSavePromotionalCode.getNameOfElement()));
        return ButtonSavePromotionalCode.isDisplayed();
    }

    public void ButtonSavePromotionalCode() {
        LogUtils.info(String.format("Check %s .", EnterPromotionalCode.getNameOfElement()));
        if(EnterPromotionalCode.size()==0) {
            LogUtils.info(String.format("Click %s .", ButtonSavePromotionalCode.getNameOfElement()));
            ButtonSavePromotionalCode.waitElementToBeClickable();
            ButtonSavePromotionalCode.click();
        }
    }

    public int AssertErrorSavePromotionalCode(){
        LogUtils.info(String.format(ErrorMessage.getNameOfElement()));
        ErrorMessage.waitVisibilityOfElement();
        return ErrorMessage.size();
    }
}
