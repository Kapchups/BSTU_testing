package pageobject.page;

import org.openqa.selenium.WebDriver;

public abstract class Page {

	protected WebDriver driver;

	private Page() {
	}

	public Page(WebDriver driver) {
		this.driver = driver;
	}

}
