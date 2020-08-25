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
	  
	//  exportCylinderPage.refreshPage();
  }
  
  @Test
  public void TC_Product_04_ExportWithEmptyFile() throws Exception {
	  log.info("************* TC04 - EXPORT CYLINDER  **************");
	  
	  log.info("TC_Product_04_ExportWithEmptyFile - Step 01 --> Open Export Cylinder Page");
	  //exportCylinderPage = homePage.openExportCylinderPage(driver);
	  exportCylinderPage = PageFactoryManager.getExportCylinderPage(driver);
	  
	  filePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Empty Cylinder.txt";
	  
	  log.info("TC_Product_04_ExportWithEmptyFile - Step 02 --> Upload file import with empty cylinder code");
	  exportCylinderPage.sendKeyToExportCylinder(filePath); 
	
	  message = "Empty request cylinder_serials, cylinder_serials must be id array";
	  log.info("TC_Product_04_ExportWithEmptyFile - Step 03 --> Verify message failed with invalid cylinder code");
	  verifyEquals(message, exportCylinderPage.getMessageEmptyCode());
  }
  
  @Test
  public void TC_Product_05_ExportWithValidFile() throws Exception {
	  log.info("************* TC05 - EXPORT CYLINDER  **************");
	  
	  log.info("TC_Product_05_ExportWithValidFile - Step 01 --> Open Export Cylinder Page");
	  //exportCylinderPage = homePage.openExportCylinderPage(driver);
	  exportCylinderPage = PageFactoryManager.getExportCylinderPage(driver);
	  
	  filePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Valid Cylinder.txt";
	  
	  log.info("TC_Product_05_ExportWithValidFile - Step 02 --> Upload file import with empty cylinder code");
	  exportCylinderPage.sendKeyToExportCylinder(filePath); 
	  
	  exportCylinderPage.scrollToContinueButton();
	  
	  log.info("TC_Product_05_ExportWithValidFile - Step 03 --> Click to Continue Button");
	  exportCylinderPage.clickToContinueButton();
	  
	  log.info("TC_Product_05_ExportWithValidFile - Step 04 --> Click choose driver");
	  exportCylinderPage.selectDriverName();
	  
	  log.info("TC_Product_05_ExportWithValidFile - Step 05 --> Input to Lisence Plate");
	  exportCylinderPage.inputToLicensePlate("51G-6868");
	  
	  log.info("TC_Product_05_ExportWithValidFile - Step 06 --> Click choose customer type");
	  exportCylinderPage.selectCustomerType();
	  
	  log.info("TC_Product_05_ExportWithValidFile - Step 07 --> Click choose customer name");
	  exportCylinderPage.selectCustomerName();
	  
	  log.info("TC_Product_05_ExportWithValidFile - Step 08 --> Click choose child name");
	  exportCylinderPage.selectCustomerChild("Chi nhánh DLPP Bình Test 18/08");
	  
	  exportCylinderPage.pressENTER();
	  
	  exportCylinderPage.scrollToSaveButton();
	  
	  log.info("TC_Product_05_ExportWithValidFile - Step 09 --> Click save buttton");
	  exportCylinderPage.clickToSaveButton();
	  
	  log.info("TC_Product_05_ExportWithValidFile - Step 07 --> Verify import success");
	  message = "Xuất hàng thành công!";
	  verifyEquals(message, exportCylinderPage.getMessageSuccess());
  }

  @AfterClass
  public void afterClass() {
	  log.info("	**********************  CLOSE BROWSER  ******************     ");
	  closeBrowser();
  }

}
