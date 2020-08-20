package vn.sopetgasone.product;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.ExportCylinderPage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Product_02_ExportCylinder extends AbstractTest {
	WebDriver driver;
	static String loginUrl, email, password, filePath, brand, type, location, message;
	
	private static LoginPage loginPage;
	private static HomePage homePage;
	private static ExportCylinderPage exportCylinderPage;
	
	@BeforeClass
	  public void beforeClass() {
		driver = openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginUrl = loginPage.getLoginPageUrl();
		email = "thanhbinhtester@dvs.vn";
		password = "A123!@#";
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
	  }
	
  @Test
  public void TC_Product_03_ExportWithInvalidCylinder() throws Exception {
	  log.info("************* TC03 - EXPORT CYLINDER  **************");
	  
	  log.info("TC_Product_03_ExportWithInvalidCylinder - Step 01 --> Open Export Cylinder Page");
	  exportCylinderPage = homePage.openExportCylinderPage(driver);
	  
	  filePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Invalid Cylinder.txt";
	  
	  log.info("TC_Product_03_ExportWithInvalidCylinder - Step 02 --> Upload file import with invalid cylinder code");
	  exportCylinderPage.sendKeyToExportCylinder(filePath); 
	
	  message = "Những mã này đang vận chuyển, đã bán, bình rỗng, hoặc đang không ở doanh nghiệp sở tại nên không thể xuất : ";
	  log.info("TC_Product_03_ExportWithInvalidCylinder - Step 03 --> Verify message failed with invalid cylinder code");
	  verifyEquals(message, exportCylinderPage.getMessageInvalidCode());
	  
	  exportCylinderPage.refreshPage();
  }
  
  @Test
  public void TC_Product_04_ExportWithEmptyFile() throws Exception {
	  log.info("************* TC04 - EXPORT CYLINDER  **************");
	  
	  log.info("TC_Product_03_ExportWithInvalidCylinder - Step 01 --> Open Export Cylinder Page");
	  exportCylinderPage = homePage.openExportCylinderPage(driver);
	  
	  filePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Empty Cylinder.txt";
	  
	  log.info("TC_Product_03_ExportWithInvalidCylinder - Step 02 --> Upload file import with empty cylinder code");
	  exportCylinderPage.sendKeyToExportCylinder(filePath); 
	
	  message = "Empty request cylinder_serials, cylinder_serials must be id array";
	  log.info("TC_Product_03_ExportWithInvalidCylinder - Step 03 --> Verify message failed with invalid cylinder code");
	  verifyEquals(message, exportCylinderPage.getMessageEmptyCode());
	  
	  exportCylinderPage.refreshPage();
  }
  
  
  

  @AfterClass
  public void afterClass() {
	  closeBrowser();
  }

}
