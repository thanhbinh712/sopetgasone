package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pagesUI.ExportCylinderPageUI;

public class ExportCylinderPage extends AbstractPage{
	WebDriver driver;
	
	public ExportCylinderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sendKeyToExportCylinder(String filePath) {
		waitForControlVisible(driver, ExportCylinderPageUI.UPLOADFILE_EXPORT_CYLINDER);
		sendKeysToElement(driver, ExportCylinderPageUI.UPLOADFILE_EXPORT_CYLINDER, filePath);
	}
	
	public void clickToContinueButton() {
		waitForControlVisible(driver, ExportCylinderPageUI.CONTINUE_BUTTON);
		clickToElement(driver, ExportCylinderPageUI.CONTINUE_BUTTON);
	}
	
	public void selectDriverName() {
		waitForControlVisible(driver, ExportCylinderPageUI.DRIVER_DROPDOWN);
		clickToElement(driver, ExportCylinderPageUI.DRIVER_DROPDOWN);
		waitForControlVisible(driver, ExportCylinderPageUI.DRIVER_001);
		clickToElement(driver, ExportCylinderPageUI.DRIVER_001);
	}
	
	public void inputToLicensePlate(String lisenceplate) {
		waitForControlVisible(driver, ExportCylinderPageUI.LICENSEPLATE_INPUT);
		clickToElement(driver, ExportCylinderPageUI.LICENSEPLATE_INPUT);
		waitForControlVisible(driver, ExportCylinderPageUI.LICENSEPLATE_INPUT);
		sendKeysToElement(driver, ExportCylinderPageUI.LICENSEPLATE_INPUT, lisenceplate);
	}
	
	public void selectCustomerType() {
		waitForControlVisible(driver, ExportCylinderPageUI.CUSTOMERTYPE_DROPDOWN);
		clickToElement(driver, ExportCylinderPageUI.CUSTOMERTYPE_DROPDOWN);
		waitForControlVisible(driver, ExportCylinderPageUI.DISTRIBUTION_AGENCY);
		clickToElement(driver, ExportCylinderPageUI.DISTRIBUTION_AGENCY);
	}
	
	public void selectCustomerName(String name) {
		waitForControlVisible(driver, ExportCylinderPageUI.CUSTOME_NAME_DROPDOWN);
		clickToElement(driver, ExportCylinderPageUI.CUSTOME_NAME_DROPDOWN);
	}
	
	public void sendKeyToCustomerChild(String childname) {
		waitForControlVisible(driver, ExportCylinderPageUI.CUSTOMER_CHILD_DROPDOWN);
		sendKeysToElement(driver, ExportCylinderPageUI.CUSTOMER_CHILD_DROPDOWN, childname);
	}
	
	public void clickToSaveButton() {
		waitForControlVisible(driver, ExportCylinderPageUI.SAVE_BUTTON);
		clickToElement(driver, ExportCylinderPageUI.SAVE_BUTTON);
	}
	
	public void clickToCloseButton() {
		waitForControlVisible(driver, ExportCylinderPageUI.CLOSE_BUTTON);
		clickToElement(driver, ExportCylinderPageUI.CLOSE_BUTTON);
	}
	
//	public void clickToResetButton() {
//		waitForControlVisible(driver, ExportCylinderPageUI.RESET_BUTTON);
//		clickToElement(driver, ExportCylinderPageUI.RESET_BUTTON);
//	}
	
	public String getMessageInvalidCode() {
		waitForControlVisible(driver, ExportCylinderPageUI.NOTIFICATION_STATUS_MESSAGE);
		return getTextElement(driver, ExportCylinderPageUI.NOTIFICATION_STATUS_MESSAGE);
	}
	
	public String getMessageEmptyCode() {
		waitForControlVisible(driver, ExportCylinderPageUI.NOTIFICATION_EMPTY_MESSAGE);
		return getTextElement(driver, ExportCylinderPageUI.NOTIFICATION_EMPTY_MESSAGE);
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void scrollToContinueButton() {
		scrollToElement(driver, ExportCylinderPageUI.CONTINUE_BUTTON);
	}
	
	public void scrollToSaveButton() {
		scrollToElement(driver, ExportCylinderPageUI.SAVE_BUTTON);
	}
}
