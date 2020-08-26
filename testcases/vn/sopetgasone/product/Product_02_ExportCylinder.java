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
	String validFilePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Valid Cylinder.txt";
	String emptyCodefilePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Empty Cylinder.txt";
	String invalidCodeFilePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Invalid Cylinder.txt";
	String email = "thanhbinhtester@dvs.vn";
	String password = "A123!@#";
	String success_message = "Xuất hàng thành công!";
	String invalid_message = "Những mã này đang vận chuyển, đã bán, bình rỗng, hoặc đang không ở doanh nghiệp sở tại nên không thể xuất : ";
	String empty_message = "Empty request cylinder_serials, cylinder_serials must be id array";
	String license_plate = "51G-6868";
	String customerChild_Name = "Chi nhánh DLPP Bình Test 18/08";
	
	private static LoginPage loginPage;
	private static HomePage homePage;
	private static ExportCylinderPage exportCylinderPage;
	
	@BeforeClass
	  public void beforeClass() {
		log.info("	**********************  OPEN BROWSER  ******************     ");
		driver = openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
	  }
	
	@Test
	  public void TC_Product_04_ExportWithValidFile() throws Exception {
		  log.info("************* TC04 - EXPORT VALID CYLINDER FILE  **************");
		  
		  log.info("TC_Product_04_ExportWithValidFile - Step 01 --> Open Export Cylinder Page");
		  exportCylinderPage = homePage.openExportCylinderPage(driver);
		  
		  log.info("TC_Product_04_ExportWithValidFile - Step 02 --> Upload file import with empty cylinder code");
		  exportCylinderPage.sendKeyToExportCylinder(validFilePath); 
		  
		  exportCylinderPage.scrollToContinueButton();
		  
		  log.info("TC_Product_04_ExportWithValidFile - Step 03 --> Click to Continue Button");
		  exportCylinderPage.clickToContinueButton();
		  
		  log.info("TC_Product_04_ExportWithValidFile - Step 04 --> Click choose driver 001");
		  exportCylinderPage.selectDriverName();
		  
		  log.info("TC_Product_04_ExportWithValidFile - Step 05 --> Input to Lisence Plate " + license_plate);
		  exportCylinderPage.inputToLicensePlate(license_plate);
		  
		  log.info("TC_Product_04_ExportWithValidFile - Step 06 --> Click choose customer type");
		  exportCylinderPage.selectCustomerType();
		  
		  log.info("TC_Product_04_ExportWithValidFile - Step 07 --> Click choose customer name");
		  exportCylinderPage.selectCustomerName();
		  
		  log.info("TC_Product_04_ExportWithValidFile - Step 08 --> Click choose child name");
		  exportCylinderPage.selectCustomerChild(customerChild_Name);
		  
		  exportCylinderPage.pressENTER();
		  
		  exportCylinderPage.scrollToSaveButton();
		  
		  log.info("TC_Product_04_ExportWithValidFile - Step 09 --> Click save buttton");
		  exportCylinderPage.clickToSaveButton();
		  
		  log.info("TC_Product_04_ExportWithValidFile - Step 07 --> Verify import success: " + success_message);
		  verifyEquals(success_message, exportCylinderPage.getMessageSuccess());
		  
		  exportCylinderPage.refreshPage();
	  }
	
  @Test
  public void TC_Product_05_ExportWithInvalidCylinder() throws Exception {
	  log.info("************* TC05 - EXPORT INVALID CYLINDER  **************");
	  
	  log.info("TC_Product_05_ExportWithInvalidCylinder - Step 01 --> Open Export Cylinder Page");
	  exportCylinderPage = homePage.openExportCylinderPage(driver);
	  
	  log.info("TC_Product_05_ExportWithInvalidCylinder - Step 02 --> Upload file import with invalid cylinder code");
	  exportCylinderPage.sendKeyToExportCylinder(invalidCodeFilePath); 
	
	  log.info("TC_Product_05_ExportWithInvalidCylinder - Step 03 --> Verify message failed with invalid cylinder code");
	  verifyEquals(invalid_message, exportCylinderPage.getMessageInvalidCode());
	  
	  exportCylinderPage.refreshPage();
  }
  
  @Test
  public void TC_Product_06_ExportWithEmptyFile() throws Exception {
	  log.info("************* TC06 - EXPORT EMPTY CYLINDER FILE  **************");
	  
	  log.info("TC_Product_06_ExportWithEmptyFile - Step 01 --> Open Export Cylinder Page");
	  exportCylinderPage = homePage.openExportCylinderPage(driver);
	  
	  log.info("TC_Product_06_ExportWithEmptyFile - Step 02 --> Upload file import with empty cylinder code");
	  exportCylinderPage.sendKeyToExportCylinder(emptyCodefilePath); 
	 
	  log.info("TC_Product_06_ExportWithEmptyFile - Step 03 --> Verify message failed with invalid cylinder code");
	  verifyEquals(empty_message, exportCylinderPage.getMessageEmptyCode());
  }
  
  @AfterClass
  public void afterClass() {
	  log.info("	**********************  CLOSE BROWSER  ******************     ");
	  closeBrowser();
  }

}
