package project.form;

import framework.utils.ConfigReader;
import framework.utils.LogUtils;
import project.models.Users;

public class LoginUser {
    Users user =new Users();

    public void setUsername() {
        LogUtils.info(String.format("Set username"));
        user.setUsername(ConfigReader.getTestData("email"));
    }

    public void setPassword() {
        LogUtils.info(String.format("Set password"));
        user.setPassword(ConfigReader.getTestData("password"));
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getPassword() {
        return user.getPassword();
    }
}
