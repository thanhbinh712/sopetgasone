package commons;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.DistributionAgencyPage;
import pages.ExportCylinderPage;
import pages.CreateCylinderPage;
import pagesUI.AbstractPageUI;

public class AbstractPage extends AbstractTest{
	WebDriver driver;
	
	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getTitlePage(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void back(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public void sendKeysToElement(WebDriver driver, String locator, String value) {
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			element.sendKeys(value);
			log.info("sendkeys successfully: " + locator + " - " + value);
		}catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	public void clearToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}
	
	public void selectedItemDropdown(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);
	}
	
	public void selectedItemDropdownByIndex(WebDriver driver, String locator, Integer index) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByIndex(index);
	}
	
	public String getFirstSelectedItem(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}
	
	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public int getSizeElement(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}
	
	public void checkTheCheckBox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isControlDisplay(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	
	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}
	
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void sendKeysToAlert(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}
	
	public void waitForControlVisible(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitForControlToBeClick(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by)).clear();;
	}
	
	public Object scrollToBottomPage(WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		} 
	}
	
	public void scrollToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor)
				driver).executeScript ("arguments[0].scrollIntoView();", element);
	}
	
	public void selectedItemDropdownDiv(WebDriver driver, String locator, String text) {
		WebElement divClick = driver.findElement(By.xpath(locator));
		divClick.click();
		Select select = new Select(divClick);
		select.selectByVisibleText(text);
	}
	
//===================== OPEN MENU PAGE =====================
	public DistributionAgencyPage openDistriButionAgencyPage(WebDriver driver) {
		waitForControlVisible(driver, pagesUI.HomePageUI.BUSSINESS_MENULINK);
		clickToElement(driver, pagesUI.HomePageUI.BUSSINESS_MENULINK);
		waitForControlVisible(driver, pagesUI.HomePageUI.CUSTOMER_MENULINK);
		clickToElement(driver, pagesUI.HomePageUI.CUSTOMER_MENULINK);
		waitForControlVisible(driver, pagesUI.HomePageUI.DISTRIBUTION_AGENCY_MENULINK);
		clickToElement(driver, pagesUI.HomePageUI.DISTRIBUTION_AGENCY_MENULINK);
		return PageFactoryManager.getDistributionAgencyPage(driver);
	}
	
	public CreateCylinderPage openCreateCylinderPage(WebDriver driver) {
		waitForControlVisible(driver, pagesUI.HomePageUI.PRODUCT_MENULINK);
		clickToElement(driver, pagesUI.HomePageUI.PRODUCT_MENULINK);
		waitForControlVisible(driver, pagesUI.CreateCylinderPageUI.CREATE_CYLINDER_BUTTON);
		clickToElement(driver, pagesUI.CreateCylinderPageUI.CREATE_CYLINDER_BUTTON);
		return PageFactoryManager.getCreateCylinderPage(driver);
	}
	
	public ExportCylinderPage openExportCylinderPage(WebDriver driver) {
		waitForControlVisible(driver, pagesUI.HomePageUI.PRODUCT_MENULINK);
		clickToElement(driver, pagesUI.HomePageUI.PRODUCT_MENULINK);
		waitForControlVisible(driver, pagesUI.ExportCylinderPageUI.EXPORT_CYLINDER_BUTTON);
		clickToElement(driver, pagesUI.ExportCylinderPageUI.EXPORT_CYLINDER_BUTTON);
		return PageFactoryManager.getExportCylinderPage(driver);
	}
}
