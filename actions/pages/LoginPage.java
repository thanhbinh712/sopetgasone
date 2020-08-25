package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import pagesUI.LoginPageUI;

public class LoginPage extends AbstractPage{
	
	WebDriver driver;
	
	//Page Object constructor which passes the driver context forward
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageUrl() {
		return getCurrentUrl(driver);
	}
	
	public void inputToEmailTextbox(String email) {
		waitForControlVisible(driver, LoginPageUI.EMAIL_TXT);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TXT, email);
		log.info("sendkeys successfully - " + email);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TXT);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TXT, password);
	}
	
	public HomePage clickToLoginButton() {
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageFactoryManager.getHomePage(driver);
	}
	
	public String getLoginFailedMessage() {
		waitForControlVisible(driver, LoginPageUI.LOGINFAILED_MESSAGE);
		return getTextElement(driver, LoginPageUI.LOGINFAILED_MESSAGE);
	}
	
	public String getEmptyMessage() {
		waitForControlVisible(driver, LoginPageUI.EMPTY_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMPTY_MESSAGE);
	}
	
	public void clearToEmailTextbox() {
		waitForControlVisible(driver, LoginPageUI.EMAIL_TXT);
		clearToElement(driver, LoginPageUI.EMAIL_TXT);
	}
	
	public void clearToPasswordTextbox() {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TXT);
		clearToElement(driver, LoginPageUI.PASSWORD_TXT);
	}
	
}
