package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pagesUI.LoginPageUI;

public class LoginPage extends AbstractPage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public String getLoginPageUrl() {
		return getCurrentUrl(driver);
	}
	
	public void inputToUsernameTextbox(String userID) {
		waitForControlVisible(driver, LoginPageUI.EMAIL_TXT);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TXT, userID);
		log.info("sendkeys successfully - " + userID);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TXT);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TXT, password);
	}
	
	public void clickToLoginButton() {
		waitForControlVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
}
