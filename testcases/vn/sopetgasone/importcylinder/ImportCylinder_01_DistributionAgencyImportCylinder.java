package vn.sopetgasone.importcylinder;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.HomePage;
import pages.ImportCylinderPage;
import pages.LoginPage;

public class ImportCylinder_01_DistributionAgencyImportCylinder extends AbstractTest {
	WebDriver driver;
	
	String email = "agency1dlppbinhtest1808@gmail.com";
	String password = "A123!@#";
	String validFilePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Valid Cylinder.txt";
	String emptyCodefilePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Empty Cylinder.txt";
	String invalidCodeFilePath = "D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\Invalid Cylinder.txt";
	String sucess_message = "Nhập hàng thành công!";
	String invalid_message = "Những mã này chưa xuất nên không thể nhập :";
	String notfound_message = "Không tìm thấy bất kì mã nào";
	
	private static LoginPage loginPage;
	private static HomePage homePage;
	private static ImportCylinderPage importCylinderPage;
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		log.info("	**********************  DISTRIBUTION AGENCY IMPORT CYLINDER  ******************     ");
		driver = openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Thread.sleep(2000);
	  }
	
	@Test
	  public void TC_ImportCylinder_01_ImportWithValidFile() {
		  log.info("************* TC01 - IMPORT VALID CYLINDER  **************");
		  
		  log.info("TC_ImportCylinder_01_ImportWithValidFile - Step 01 --> Open Import Cylinder Page");
		  importCylinderPage = homePage.openImportCylinderPage(driver);
		  
		  log.info("TC_ImportCylinder_01_ImportWithValidFile - Step 02 --> Upload file import with empty cylinder code");
		  importCylinderPage.sendKeyToImportCylinder(validFilePath);
		  
		  importCylinderPage.scrollToContinueButton();
		  
		  log.info("TC_ImportCylinder_01_ImportWithValidFile - Step 03 --> Click to Continue Button");
		  importCylinderPage.clickToContinueButton();
		  
		  log.info("TC_ImportCylinder_01_ImportWithValidFile - Step 04 --> Click choose driver");
		  importCylinderPage.selectDriverName();
		  
		  log.info("TC_ImportCylinder_01_ImportWithValidFile - Step 04 --> Input to license plate");
		  importCylinderPage.inputToLicensePlate("51G-6868");
		  
		  log.info("TC_ImportCylinder_01_ImportWithValidFile - Step 05 --> Click to Save button");
		  importCylinderPage.clickToSaveButton();
		  
		  log.info("TC_ImportCylinder_01_ImportWithValidFile - Step 07 --> Verify import success : " + sucess_message);
		  verifyEquals(sucess_message, importCylinderPage.getMessageSuccess());
		  
		  
	  }
	
  @Test
  public void TC_ImportCylinder_02_ImportWithInvalidCylinder(){
	  importCylinderPage.refreshPage();
	  log.info("************* TC02 - IMPORT INVALID CYLINDER  **************");
	  
	  log.info("TC_ImportCylinder_02_ImportWithInvalidCylinder - Step 01 --> Open Import Cylinder Page");
	  importCylinderPage = homePage.openImportCylinderPage(driver);
	  
	  log.info("TC_ImportCylinder_02_ImportWithInvalidCylinder - Step 02 --> Upload file import with invalid cylinder code");
	  importCylinderPage.sendKeyToImportCylinder(invalidCodeFilePath); 
	  
	  log.info("TC_ImportCylinder_02_ImportWithInvalidCylinder - Step 03 --> Verify message failed with invalid cylinder code: " + invalid_message);
	  verifyEquals(invalid_message, importCylinderPage.getMessageInvalidCode()); 
	  
	  importCylinderPage.refreshPage();
  }
  
  @Test
  public void TC_ImportCylinder_03_ImportWithEmptyFile() {
	  log.info("************* TC03 - IMPORT EMPTY CYLINDER  **************");
	  
	  log.info("TC_ImportCylinder_03_ImportWithEmptyFile - Step 01 --> Open Import Cylinder Page");
	  importCylinderPage = homePage.openImportCylinderPage(driver);
	  
	  log.info("TC_ImportCylinder_03_ImportWithEmptyFile - Step 02 --> Upload file import with empty cylinder code");
	  importCylinderPage.sendKeyToImportCylinder(emptyCodefilePath); 
	  
	  log.info("TC_ImportCylinder_03_ImportWithEmptyFile - Step 03 --> Verify message failed with invalid cylinder code " + notfound_message);
	  verifyEquals(notfound_message, importCylinderPage.getMessageEmptyCode());
  }
  
  @AfterClass
  public void afterClass() {
	  log.info("	**********************  CLOSE BROWSER  ******************     ");
	  closeBrowser();
  }
}
