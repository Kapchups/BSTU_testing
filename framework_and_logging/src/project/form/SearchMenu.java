package project.form;

import framework.utils.ConfigReader;
import framework.utils.LogUtils;
import project.models.Locations;

public class SearchMenu {
    Locations location =new Locations();

    public void setLocation() {
        LogUtils.info(String.format("Set location"));
        location.setLocation(ConfigReader.getTestData("location"));
    }

    public String getLocation() {
        return location.getLocation();
    }

}
