package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pagesUI.CreateAccountPageUI;

public class CreateAccountPage extends AbstractPage {

	WebDriver driver;
	
	public CreateAccountPage(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void clickToCreateButton() {
		waitForControlVisible(driver, CreateAccountPageUI.CREATE_FACTORYCHILD_BUTTON);
		clickToElement(driver, CreateAccountPageUI.CREATE_FACTORYCHILD_BUTTON);
	}
	
	public void InputToEmailTextbox(String email) {
		waitForControlVisible(driver, CreateAccountPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, CreateAccountPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void InputToNameTextbox(String name) {
		waitForControlVisible(driver, CreateAccountPageUI.NAME_TEXTBOX);
		sendKeysToElement(driver, CreateAccountPageUI.NAME_TEXTBOX, name);
	}
	
	public void InputToCodeTextbox(String code) {
		waitForControlVisible(driver, CreateAccountPageUI.CODE_TEXTBOX);
		sendKeysToElement(driver, CreateAccountPageUI.CODE_TEXTBOX, code);
	}
	
	public void InputToAddressTextbox(String address) {
		waitForControlVisible(driver, CreateAccountPageUI.ADDRESS_TEXTBOX);
		sendKeysToElement(driver, CreateAccountPageUI.ADDRESS_TEXTBOX, address);
	}
	
	public void clickToSaveButton() {
		waitForControlVisible(driver, CreateAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, CreateAccountPageUI.SAVE_BUTTON);
	}
}
