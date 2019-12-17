package project.form;

import framework.elements.Button;
import framework.utils.LogUtils;
import org.openqa.selenium.By;

import java.awt.*;

public class MainMenu {

    private Button AuthorizationButton = new Button(By.xpath("//div[@class='zen-header-account-button']"), "Authorization Button");
    private Button MenuList = new Button(By.xpath("//div[@class='zen-menuburger-button']"), "MenuList");
    private Button ButtonSavePromotionalCodeInMenu = new Button(By.xpath("//span[@class='zen-menuburger-pseudolink']"), "ButtonSavePromotionalCode Button");

    public boolean isMenuListDisplayed() {
        LogUtils.info(String.format("Check %s is displayed.", ButtonSavePromotionalCodeInMenu.getNameOfElement()));
        return ButtonSavePromotionalCodeInMenu.isDisplayed();
    }

    public void clickAuthorizationButton() {
        LogUtils.info(String.format("Click %s .", AuthorizationButton.getNameOfElement()));
        AuthorizationButton.waitElementToBeClickable();
        AuthorizationButton.click();
    }

    public void clickMenuList() {
        LogUtils.info(String.format("Click %s .", MenuList.getNameOfElement()));
        MenuList.waitElementToBeClickable();
        MenuList.click();
    }

    public void clickButtonSavePromotionalCodeInMenu() {
        LogUtils.info(String.format("Click %s .", ButtonSavePromotionalCodeInMenu.getNameOfElement()));
        ButtonSavePromotionalCodeInMenu.waitElementToBeClickable();
        ButtonSavePromotionalCodeInMenu.click();
    }
}
