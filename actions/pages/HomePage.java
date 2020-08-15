package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import pagesUI.HomePageUI;

public class HomePage extends AbstractPage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void clickToBussinessMenuLink() {
		waitForControlVisible(driver, HomePageUI.BUSSINESS_MENULINK);
		clickToElement(driver, HomePageUI.BUSSINESS_MENULINK);
	}
	
	public CreateAccountPage clickFactoryChildMenuLink() {
		waitForControlVisible(driver, HomePageUI.FACTORYCHILD_MENULINK);
		clickToElement(driver, HomePageUI.FACTORYCHILD_MENULINK);
		return PageFactoryManager.getCreateAccountPage(driver);
	}
}
