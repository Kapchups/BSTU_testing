package pageobject.page;

import org.openqa.selenium.WebDriver;

public class AuthPage extends Page {

	public AuthPage(WebDriver driver) {
		super(driver);
	}

	public String url() {
		return driver.getCurrentUrl();
	}


}
