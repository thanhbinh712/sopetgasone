package commons;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class PageFactoryManager {

	private static LoginPage loginPage;
	
	WebDriver driver;
	
	public static LoginPage getLoginPage(WebDriver driver) {
		if(loginPage == null) {
			return new LoginPage(driver);
		}
		return loginPage;
	}
}
