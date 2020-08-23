package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pagesUI.ExportCylinderPageUI;
import pagesUI.ImportCylinderPageUI;

public class ImportCylinderPage extends AbstractPage {
	WebDriver driver;
	
	public ImportCylinderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sendKeyToImportCylinder(String filePath) {
		waitForControlVisible(driver, ImportCylinderPageUI.UPLOADFILE_BUTTON);
		sendKeysToElement(driver, ImportCylinderPageUI.UPLOADFILE_BUTTON, filePath);
	}
	
	public void clickToContinueButton() {
		waitForControlVisible(driver, ImportCylinderPageUI.CONTINUE_BUTTON);
		clickToElement(driver, ImportCylinderPageUI.CONTINUE_BUTTON);
	}
	
	public void selectDriverName() {
		waitForControlVisible(driver, ImportCylinderPageUI.DRIVER_DROPDOWN);
		clickToElement(driver, ImportCylinderPageUI.DRIVER_DROPDOWN);
		waitForControlVisible(driver, ImportCylinderPageUI.DRIVER_001);
		clickToElement(driver, ImportCylinderPageUI.DRIVER_001);
	}
	
	public void inputToLicensePlate(String lisenceplate) {
		waitForControlVisible(driver, ImportCylinderPageUI.LICENSEPLATE_TEXTBOX);
		clickToElement(driver, ImportCylinderPageUI.LICENSEPLATE_TEXTBOX);
		waitForControlVisible(driver, ImportCylinderPageUI.LICENSEPLATE_TEXTBOX);
		sendKeysToElement(driver, ImportCylinderPageUI.LICENSEPLATE_TEXTBOX, lisenceplate);
	}
	
	public void clickToSaveButton() {
		waitForControlVisible(driver, ImportCylinderPageUI.SAVE_BUTTON);
		clickToElement(driver, ImportCylinderPageUI.SAVE_BUTTON);
	}
	
	public void clickToCloseButton() {
		waitForControlVisible(driver, ImportCylinderPageUI.CLOSE_BUTTON);
		clickToElement(driver, ImportCylinderPageUI.CLOSE_BUTTON);
	}
	
	public String getMessageInvalidCode() {
		waitForControlVisible(driver, ImportCylinderPageUI.NOTIFICATION_STATUS_MESSAGE);
		return getTextElement(driver, ImportCylinderPageUI.NOTIFICATION_STATUS_MESSAGE);
	}
	
	public String getMessageEmptyCode() {
		waitForControlVisible(driver, ImportCylinderPageUI.NOTIFICATION_EMPTY_MESSAGE);
		return getTextElement(driver, ImportCylinderPageUI.NOTIFICATION_EMPTY_MESSAGE);
	}
	
	public String getMessageSuccess() {
		waitForControlVisible(driver, ImportCylinderPageUI.SUCCESS_MESSAGE);
		return getTextElement(driver, ImportCylinderPageUI.SUCCESS_MESSAGE);
	}
	
	public String getCannotFoundMessage() {
		waitForControlVisible(driver, ImportCylinderPageUI.CANNOT_FOUND_MESSAGE);
		return getTextElement(driver, ImportCylinderPageUI.CANNOT_FOUND_MESSAGE);
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void scrollToContinueButton() {
		scrollToElement(driver, ImportCylinderPageUI.CONTINUE_BUTTON);
	}
}
