package commons;

import org.openqa.selenium.WebDriver;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

public class PageFactoryManager {

	private static LoginPage loginPage;
	private static HomePage homePage;;
	private static CreateAccountPage createAccountPage;
	
	
	WebDriver driver;
	
	public static LoginPage getLoginPage(WebDriver driver) {
		if(loginPage == null) {
			return new LoginPage(driver);
		}
		return loginPage;
	}
	
	public static HomePage getHomePage(WebDriver driver) {
		if(homePage == null) {
			return new HomePage(driver);
		}
		return homePage;
	}
	
	public static CreateAccountPage getCreateAccountPage(WebDriver driver) {
		if(createAccountPage == null) {
			return new CreateAccountPage(driver);
		}
		return createAccountPage;
	}
}
