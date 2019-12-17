package project.form;

import framework.elements.Button;
import framework.utils.LogUtils;
import org.openqa.selenium.By;

public class AddCountPeoples {

    private Button AddCountChildren = new Button(By.xpath("//div[@class='Room__rightColumn--1hMAR']//div[2]//div[2]//button[2]"), "button Add Children");
    private Button AddCountAdults = new Button(By.xpath("//div[@class='Room__line--385ZF']//div[1]//div[2]//button[2]"), "button Add Adults");

    public void setAddCountChildren() {
        LogUtils.info(String.format("Click %s .", AddCountChildren.getNameOfElement()));
        AddCountChildren.waitElementToBeClickable();
        AddCountChildren.click();
    }

    public void setAddCountAdults() {
        LogUtils.info(String.format("Click %s .", AddCountAdults.getNameOfElement()));
        AddCountAdults.waitElementToBeClickable();
        AddCountAdults.click();
    }

    public void setCountClickChildren(int count) {
        LogUtils.info(String.format("Count children: %s .", count));
        for (int i = 1; i <= count; i++) {
            setAddCountChildren();
        }
    }

    public void setCountClickAdults(int count) {
        LogUtils.info(String.format("Count adults: %s .", count));
        for (int i = 1; i <= count; i++) {
            setAddCountAdults();
        }
    }
}
