package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import pagesUI.DistributionAgencyPageUI;
import pagesUI.LoginPageUI;

public class DistributionAgencyPage extends AbstractPage {

	WebDriver driver;
	
	public DistributionAgencyPage(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void clickToCreateButton() {
		waitForControlVisible(driver, DistributionAgencyPageUI.CREATE_FACTORYCHILD_BUTTON);
		clickToElement(driver, DistributionAgencyPageUI.CREATE_FACTORYCHILD_BUTTON);
	}
	
	public void InputToEmailTextbox(String email) {
		waitForControlVisible(driver, DistributionAgencyPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, DistributionAgencyPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void InputToNameTextbox(String name) {
		waitForControlVisible(driver, DistributionAgencyPageUI.NAME_TEXTBOX);
		sendKeysToElement(driver, DistributionAgencyPageUI.NAME_TEXTBOX, name);
	}
	
	public void InputToCodeTextbox(String code) {
		waitForControlVisible(driver, DistributionAgencyPageUI.CODE_TEXTBOX);
		sendKeysToElement(driver, DistributionAgencyPageUI.CODE_TEXTBOX, code);
	}
	
	public void InputToInvoiceNameTextbox(String invoiceName) {
		waitForControlVisible(driver, DistributionAgencyPageUI.INVOICE_NAME_TEXTBOX);
		sendKeysToElement(driver, DistributionAgencyPageUI.INVOICE_NAME_TEXTBOX, invoiceName);
	}
	
	public void InputToInvoiceAddressTextbox(String address) {
		waitForControlVisible(driver, DistributionAgencyPageUI.INVOICE_ADDRESS_TEXTBOX);
		sendKeysToElement(driver, DistributionAgencyPageUI.INVOICE_ADDRESS_TEXTBOX, address);
	}
	
	public void InputToAddressTextbox(String address) {
		waitForControlVisible(driver, DistributionAgencyPageUI.ADDRESS_TEXTBOX);
		sendKeysToElement(driver, DistributionAgencyPageUI.ADDRESS_TEXTBOX, address);
	}
	
	public void clickToSaveButton() {
		waitForControlVisible(driver, DistributionAgencyPageUI.SAVE_BUTTON);
		clickToElement(driver, DistributionAgencyPageUI.SAVE_BUTTON);
	}
	
	public void selectGroup(String group) {
		waitForControlVisible(driver, DistributionAgencyPageUI.GROUP_CUSTOMER_DROPDOWN);
		selectedItemDropdown(driver, DistributionAgencyPageUI.GROUP_CUSTOMER_DROPDOWN, group);
	}
	
	public void clickToDeleteButton() {
		waitForControlVisible(driver, DistributionAgencyPageUI.DELETE_CHILD_BUTTON);
		clickToElement(driver, DistributionAgencyPageUI.DELETE_CHILD_BUTTON);
	}
	
	public String createSuccessMessage() {
		waitForControlVisible(driver, DistributionAgencyPageUI.CREATE_SUCCESS_MESSAGE);
		return getTextElement(driver, DistributionAgencyPageUI.CREATE_SUCCESS_MESSAGE);
	}
	
	public void clickToCloseButton() {
		waitForControlVisible(driver, DistributionAgencyPageUI.CLOSE_BUTTON);
		clickToElement(driver, DistributionAgencyPageUI.CLOSE_BUTTON);
	}
}
