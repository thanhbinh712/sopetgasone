package commons;

import org.openqa.selenium.WebDriver;

import pages.DistributionAgencyPage;
import pages.HomePage;
import pages.CreateCylinderPage;
import pages.LoginPage;

public class PageFactoryManager {

	private static LoginPage loginPage;
	private static HomePage homePage;;
	private static DistributionAgencyPage createAccountPage;
	private static CreateCylinderPage createCylinderPage;
	
	
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
	
	public static DistributionAgencyPage getDistributionAgencyPage(WebDriver driver) {
		if(createAccountPage == null) {
			return new DistributionAgencyPage(driver);
		}
		return createAccountPage;
	}
	
	public static CreateCylinderPage getCreateCylinderPage(WebDriver driver) {
		if(createCylinderPage == null) {
			return new CreateCylinderPage(driver);
		}
		return createCylinderPage;
	}
}
