package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import pagesUI.HomePageUI;

public class HomePage extends AbstractPage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePageUrl() {
		return getCurrentUrl(driver);
	}
	
	public void clickToBussinessMenuLink() {
		waitForControlVisible(driver, HomePageUI.BUSSINESS_MENULINK);
		clickToElement(driver, HomePageUI.BUSSINESS_MENULINK);
	}
	
	public DistributionAgencyPage clickFactoryChildMenuLink() {
		waitForControlVisible(driver, HomePageUI.FACTORYCHILD_MENULINK);
		clickToElement(driver, HomePageUI.FACTORYCHILD_MENULINK);
		return PageFactoryManager.getDistributionAgencyPage(driver);
	}
	
	public String getNameUser() {
		waitForControlVisible(driver, HomePageUI.NAME_LABEL);
		return getTextElement(driver, HomePageUI.NAME_LABEL);
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
}
