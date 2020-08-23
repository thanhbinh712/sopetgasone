package vn.sopetgasone.product;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.ExportCylinderPage;
import pages.HomePage;
import pages.ImportCylinderPage;
import pages.LoginPage;

public class Product_03_ImportCylinder extends AbstractTest {
	WebDriver driver;
	static String loginUrl, email, password, filePath, brand, type, location, message;
	
	private static LoginPage loginPage;
	private static HomePage homePage;
	private static ImportCylinderPage importCylinderPage;
	
	@BeforeClass
	  public void beforeClass() {
		driver = openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
		//loginUrl = loginPage.getLoginPageUrl();
		email = "agency1dlppbinhtest1808@gmail.com";
		password = "A123!@#";
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
	  }
	
  @Test
  public void TC_Product_06_ImportWithInvalidCylinder() throws Exception {
	  log.info("************* TC06 - IMPORT CYLINDER  **************");
	  
	  log.info("TC_Product_06_ImportWithInvalidCylinder - Step 01 --> Open Export Cylinder Page");
	  importCylinderPage = homePage.openImportCylinderPage(driver);
	  
	  filePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Invalid Cylinder.txt";
	  
	  log.info("TC_Product_06_ImportWithInvalidCylinder - Step 02 --> Upload file import with invalid cylinder code");
	  importCylinderPage.sendKeyToImportCylinder(filePath); 
	 
	  message = "Những mã này chưa xuất nên không thể nhập :";
	  log.info("TC_Product_06_ImportWithInvalidCylinder - Step 03 --> Verify message failed with invalid cylinder code");
	  verifyEquals(message, importCylinderPage.getMessageInvalidCode());
	  
  }
  
  @Test
  public void TC_Product_07_ImportWithEmptyFile() throws Exception {
	  importCylinderPage.refreshPage();
	  log.info("************* TC07 - IMPORT CYLINDER  **************");
	  
	  log.info("TC_Product_07_ImportWithEmptyFile - Step 01 --> Open Export Cylinder Page");
	  importCylinderPage = homePage.openImportCylinderPage(driver);
	  
	  filePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Empty Cylinder.txt";
	  
	  log.info("TC_Product_07_ImportWithEmptyFile - Step 02 --> Upload file import with empty cylinder code");
	  importCylinderPage.sendKeyToImportCylinder(filePath); 
	
	  message = "Không tìm thấy bất kì mã nào";
	  log.info("TC_Product_07_ImportWithEmptyFile - Step 03 --> Verify message failed with invalid cylinder code");
	  verifyEquals(message, importCylinderPage.getMessageEmptyCode());

	  importCylinderPage.refreshPage();
  }
  
  @Test
  public void TC_Product_08_ImportWithValidFile() throws Exception {
	  log.info("************* TC05 - IMPORT CYLINDER  **************");
	  
	  log.info("TC_Product_08_ImportWithValidFile - Step 01 --> Open Export Cylinder Page");
	  importCylinderPage = homePage.openImportCylinderPage(driver);
	//  importCylinderPage = PageFactoryManager.getImportCylinderPage(driver);
	  
	  filePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Valid Cylinder.txt";
	  
	  log.info("TC_Product_08_ImportWithValidFile - Step 02 --> Upload file import with empty cylinder code");
	  importCylinderPage.sendKeyToImportCylinder(filePath);
	  
	  importCylinderPage.scrollToContinueButton();
	  
	  log.info("TC_Product_08_ImportWithValidFile - Step 03 --> Click to Continue Button");
	  importCylinderPage.clickToContinueButton();
	  
	  log.info("TC_Product_08_ImportWithValidFile - Step 04 --> Click choose driver");
	  importCylinderPage.selectDriverName();
	  
	  log.info("TC_Product_08_ImportWithValidFile - Step 04 --> Input to license plate");
	  importCylinderPage.inputToLicensePlate("51G-6868");
	  
	  log.info("TC_Product_08_ImportWithValidFile - Step 05 --> Click to Save button");
	  importCylinderPage.clickToSaveButton();
	  
	  log.info("TC_Product_08_ImportWithValidFile - Step 07 --> Verify import success");
	  message = "Nhập hàng thành công!";
	  verifyEquals(message, importCylinderPage.getMessageSuccess());
  }

  @AfterClass
  public void afterClass() {
	  log.info("	**********************  CLOSE BROWSER  ******************     ");
	  closeBrowser();
  }
}
