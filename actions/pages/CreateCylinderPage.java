package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pagesUI.CreateCylinderPageUI;

public class CreateCylinderPage extends AbstractPage {
	WebDriver driver;
	
	public CreateCylinderPage(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeyToCylinderCode(String code) {
		waitForControlVisible(driver, CreateCylinderPageUI.CYLINDERCODE_TEXTBOX);
		sendKeysToElement(driver, CreateCylinderPageUI.CYLINDERCODE_TEXTBOX, code);
	}
	
	public void clickToUploadButton() {
		waitForControlVisible(driver, CreateCylinderPageUI.SAVE_BUTTON);
		clickToElement(driver, CreateCylinderPageUI.SAVE_BUTTON);
	}
	
	public void clickToCloseButton() {
		waitForControlVisible(driver, CreateCylinderPageUI.CLOSE_BUTTON);
		clickToElement(driver, CreateCylinderPageUI.CLOSE_BUTTON);
	}
	
	public void selectCylinderType(String type) {
		waitForControlVisible(driver, CreateCylinderPageUI.CYLINDERTYPE_DROPDOWN);
		selectedItemDropdown(driver, CreateCylinderPageUI.CYLINDERTYPE_DROPDOWN, type);
	}
	
	public void selectCylinderColor(String color) {
		waitForControlVisible(driver, CreateCylinderPageUI.COLOR_DROPDOWN);
		selectedItemDropdown(driver, CreateCylinderPageUI.COLOR_DROPDOWN, color);
	}
	
	public void selectValveType(String valveType) {
		waitForControlVisible(driver, CreateCylinderPageUI.VALVETYPE_DROPDOWN);
		selectedItemDropdown(driver, CreateCylinderPageUI.VALVETYPE_DROPDOWN, valveType);
	}
	
	public void clickToDateBox() {
		waitForControlVisible(driver, CreateCylinderPageUI.DATE_BOX);
		clickToElement(driver, CreateCylinderPageUI.DATE_BOX);
	}
	
	public void sendKeyToVerifycationDate(String date) {
		waitForControlVisible(driver, CreateCylinderPageUI.DATE_BOX);
		sendKeysToElement(driver, CreateCylinderPageUI.DATE_BOX, date);
	}
	
	public void selectBrand(String brand) {
		waitForControlVisible(driver, CreateCylinderPageUI.BRAND_DROPDOWN);
		clickToElement(driver, CreateCylinderPageUI.BRAND_DROPDOWN);
		selectedItemDropdown(driver, CreateCylinderPageUI.BRAND_DROPDOWN, brand);
	}
	
	public void sendKeyToWeight(String weight) {
		waitForControlVisible(driver, CreateCylinderPageUI.WEIGHT_TEXTBOX);
		sendKeysToElement(driver, CreateCylinderPageUI.WEIGHT_TEXTBOX, weight);
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public String getMessageSuccess() {
		waitForControlVisible(driver, CreateCylinderPageUI.SUCCESS_MESSAGE);
		return getTextElement(driver, CreateCylinderPageUI.SUCCESS_MESSAGE);
	}
}
