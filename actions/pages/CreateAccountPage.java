package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pagesUI.CreateDistributionAgencyPage;

public class CreateAccountPage extends AbstractPage {

	WebDriver driver;
	
	public CreateAccountPage(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void clickToCreateButton() {
		waitForControlVisible(driver, CreateDistributionAgencyPage.CREATE_FACTORYCHILD_BUTTON);
		clickToElement(driver, CreateDistributionAgencyPage.CREATE_FACTORYCHILD_BUTTON);
	}
	
	public void InputToEmailTextbox(String email) {
		waitForControlVisible(driver, CreateDistributionAgencyPage.EMAIL_TEXTBOX);
		sendKeysToElement(driver, CreateDistributionAgencyPage.EMAIL_TEXTBOX, email);
	}
	
	public void InputToNameTextbox(String name) {
		waitForControlVisible(driver, CreateDistributionAgencyPage.NAME_TEXTBOX);
		sendKeysToElement(driver, CreateDistributionAgencyPage.NAME_TEXTBOX, name);
	}
	
	public void InputToCodeTextbox(String code) {
		waitForControlVisible(driver, CreateDistributionAgencyPage.CODE_TEXTBOX);
		sendKeysToElement(driver, CreateDistributionAgencyPage.CODE_TEXTBOX, code);
	}
	
	public void InputToAddressTextbox(String address) {
		waitForControlVisible(driver, CreateDistributionAgencyPage.ADDRESS_TEXTBOX);
		sendKeysToElement(driver, CreateDistributionAgencyPage.ADDRESS_TEXTBOX, address);
	}
	
	public void clickToSaveButton() {
		waitForControlVisible(driver, CreateDistributionAgencyPage.SAVE_BUTTON);
		clickToElement(driver, CreateDistributionAgencyPage.SAVE_BUTTON);
	}
}
