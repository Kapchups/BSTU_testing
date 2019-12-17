package project.test;

import framework.utils.LogUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.form.MainMenu;
import project.pageObject.PromotionalCodePage;

public class SavePromotionalCodeWithAnEmptyField extends Base {
    private PromotionalCodePage promotionalCodePage;
    private MainMenu mainMenu;

    @Test
    public void SavePromotionalCodeWithAnEmptyField() {
        promotionalCodePage = new PromotionalCodePage();
        mainMenu = new MainMenu();

        mainMenu.clickMenuList();
        LogUtils.info("Open Menu List");
        Assert.assertTrue(mainMenu.isMenuListDisplayed(), "The Menu List is not opened.");
        mainMenu.clickButtonSavePromotionalCodeInMenu();

        LogUtils.info("Open PromotionalCode page");
        Assert.assertTrue(promotionalCodePage. isPromotionalCodePageDisplayed(), "The PromotionalCode page is not opened.");
        promotionalCodePage.ButtonSavePromotionalCode();

        Assert.assertTrue(promotionalCodePage.AssertErrorSavePromotionalCode()>0);
    }
}
