package vn.sopetgasone.newaccount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.ExcelUtils;
import commons.PageFactoryManager;
import pages.DistributionAgencyPage;
import pages.HomePage;
import pages.LoginPage;

public class NewAccount_01_CreateUser extends AbstractTest {
	WebDriver driver;
	String email = "thanhbinhtester@dvs.vn";
	String password = "A123!@#";
	String success_message = "Tạo mới thành công!";
	String exist_customerCode_message = "Trùng mã khách hàng";
	String exist_customerEmail_message = "Email đã tồn tại";

	private LoginPage loginPage;
	private HomePage homePage;
	private DistributionAgencyPage distributionAgencyPage;

	@BeforeClass
	public void beforeClass() throws Exception {
		log.info("	**********************  OPEN BROWSER  ******************     ");
		driver = openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		distributionAgencyPage = homePage.openDistriButionAgencyPage(driver);
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] getDataCreateCustomer(){
		Object[][] data = ExcelUtils.getTestData("Create New Account");
		return data;
	}

	@Test(dataProvider = "getDataCreateCustomer")
	public void TC_NewAccount_01_CreateDistributionAgencyValid(String email, String name, String code, String address, String group, 
																String childID, String childName, String childAddress) throws Exception {
		log.info("******************** TC01 - CREATE NEW CUSTOMER VALID  *********************");
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 01 --> Open Distribution Agency Page");
		distributionAgencyPage = PageFactoryManager.getDistributionAgencyPage(driver);
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 02 --> Click to Create button");
		distributionAgencyPage.clickToCreateButton();
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 03 --> Fill to email textbox: " + email);
		distributionAgencyPage.InputToEmailTextbox(email+"@gmail.com");
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 04 --> Fill to name textbox: " + name);
		distributionAgencyPage.InputToNameTextbox(name);
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 05 --> Fill to code textbox: " + code);
		distributionAgencyPage.InputToCodeTextbox(code);
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 06 --> Fill to invoce name textbox: " + name);
		distributionAgencyPage.InputToInvoiceNameTextbox(name);
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 07 --> Fill to address textbox: " + address);
		distributionAgencyPage.InputToInvoiceAddressTextbox(address);
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 08 --> Choose group: " + group);
		distributionAgencyPage.selectGroup(group);
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 09 --> Input to Child code: " + childID);
		distributionAgencyPage.InputToChildIDTextbox(childID);
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 10 --> Input to Child name: " + childName);
		distributionAgencyPage.InputToChildNameTextbox(childName);
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 11 --> Input to Child code: " + childAddress);
		distributionAgencyPage.InputToChildAddressTextbox(childAddress);
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 10 --> Click to Save Button");
		distributionAgencyPage.clickToSaveButton();
		
		log.info("TC_NewAccount_01_CreateDistributionAgencyValid - Step 11 --> Verify create success message: " + success_message);
		verifyEquals(success_message, distributionAgencyPage.createSuccessMessage());
		
		distributionAgencyPage.refreshPage();
	}
	
	@DataProvider
	public Object[][] getDataCreateCustomerExistCode(){
		Object[][] data = ExcelUtils.getTestData("CreateAccountWithExistCode");
		return data;
	}
	
	@Test(dataProvider = "getDataCreateCustomerExistCode")
	public void TC_NewAccount_02_CreateDistributionAgencyWithExistCode(String email, String name, String code, String address, String group, 
																String childID, String childName, String childAddress) throws Exception {
		log.info("******************** TC02 - CREATE NEW CUSTOMER WITH EXIST CODE  *********************");
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 01 --> Open Distribution Agency Page");
		distributionAgencyPage = PageFactoryManager.getDistributionAgencyPage(driver);
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 02 --> Click to Create button");
		distributionAgencyPage.clickToCreateButton();
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 03 --> Fill to email textbox" + email);
		distributionAgencyPage.InputToEmailTextbox(email);
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 04 --> Fill to name textbox " + name);
		distributionAgencyPage.InputToNameTextbox(name);
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 05 --> Fill to code textbox " + code);
		distributionAgencyPage.InputToCodeTextbox(code);
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 06 --> Fill to invoce name textbox " + name);
		distributionAgencyPage.InputToInvoiceNameTextbox(name);
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 07 --> Fill to address textbox " + address);
		distributionAgencyPage.InputToInvoiceAddressTextbox(address);
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 08 --> Choose group " + group);
		distributionAgencyPage.selectGroup(group);
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 09 --> Input to Child code: " + childID);
		distributionAgencyPage.InputToChildIDTextbox(childID);
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 10 --> Input to Child name: " + childName);
		distributionAgencyPage.InputToChildNameTextbox(childName);
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 11 --> Input to Child code: " + childAddress);
		distributionAgencyPage.InputToChildAddressTextbox(childAddress);
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 12 --> Click to Save Button");
		distributionAgencyPage.clickToSaveButton();
		
		log.info("TC_NewAccount_02_CreateDistributionAgencyWithExistCode - Step 13 --> Verify Exist Customer Code Message: " + exist_customerEmail_message);
		verifyEquals(exist_customerEmail_message, distributionAgencyPage.existCustomerMessage());
		
		distributionAgencyPage.refreshPage();
	}
	
	@DataProvider
	public Object[][] getDataCreateCustomerExistEmail(){
		Object[][] data = ExcelUtils.getTestData("CreateAccountWithExistEmail");
		return data;
	}
	
	@Test(dataProvider = "getDataCreateCustomerExistEmail")
	public void TC_NewAccount_03_CreateDistributionAgencyWithExistEmail(String email, String name, String code, String address, String group, 
																String childID, String childName, String childAddress) throws Exception {
		log.info("******************** TC03 - CREATE NEW CUSTOMER WITH EXIST EMAIL  *********************");
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 01 --> Open Distribution Agency Page");
		distributionAgencyPage = PageFactoryManager.getDistributionAgencyPage(driver);
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 02 --> Click to Create button");
		distributionAgencyPage.clickToCreateButton();
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 03 --> Fill to email textbox: " + email);
		distributionAgencyPage.InputToEmailTextbox(email);
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 04 --> Fill to name textbox: " + name);
		distributionAgencyPage.InputToNameTextbox(name);
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 05 --> Fill to code textbox: " + code);
		distributionAgencyPage.InputToCodeTextbox(code);
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 06 --> Fill to invoce name textbox: " + name);
		distributionAgencyPage.InputToInvoiceNameTextbox(name);
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 07 --> Fill to address textbox: " + address);
		distributionAgencyPage.InputToInvoiceAddressTextbox(address);
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 08 --> Choose group: " + group);
		distributionAgencyPage.selectGroup(group);
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 09 --> Input to Child code: " + childID);
		distributionAgencyPage.InputToChildIDTextbox(childID);
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 10 --> Input to Child name: " + childName);
		distributionAgencyPage.InputToChildNameTextbox(childName);
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 11 --> Input to Child code: " + childAddress);
		distributionAgencyPage.InputToChildAddressTextbox(childAddress);
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 12 --> Click to Save Button: ");
		distributionAgencyPage.clickToSaveButton();
		
		log.info("TC_NewAccount_03_CreateDistributionAgencyWithExistEmail - Step 13 --> Verify Exist Customer Email Message : " + exist_customerEmail_message);
		
		verifyEquals(exist_customerEmail_message, distributionAgencyPage.existCustomerMessage());
	}

	@AfterClass
	public void afterClass() {
		log.info("	**********************  CLOSE BROWSER  ******************     ");
		closeBrowser();
	}

}
