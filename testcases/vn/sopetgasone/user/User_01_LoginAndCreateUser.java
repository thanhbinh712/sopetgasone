package vn.sopetgasone.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.ExcelUtils;
import commons.PageFactoryManager;
import pages.DistributionAgencyPage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_01_LoginAndCreateUser extends AbstractTest {
	WebDriver driver;
	String emailI, password, loginUrl, homePageUrl, emailNew, name, code, emailFailed, 
			passwordFailed, nameUser;

	private LoginPage loginPage;
	private HomePage homePage;
	private DistributionAgencyPage distributionAgencyPage;

	@BeforeClass
	public void beforeClass() {
		log.info("	**********************  OPEN BROWSER  ******************     ");
		driver = openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginUrl = loginPage.getLoginPageUrl();
		emailI = "thanhbinhtester@dvs.vn";
		password = "A123!@#";
	}
	
	@Test
	public void TC_User_01_TradeOwnerLoginInvalidEmail() {
		emailFailed = "ttthanhbinhtester@dvs.vn";
		log.info("**************** TC01 - LOGIN WITH INVALID EMAIL  ****************");
		
		log.info("TC_User_01_TradeOwnerLoginInvalidEmail - Step 01 --> Input with invalid email");
		loginPage.inputToEmailTextbox(emailFailed);
		
		log.info("TC_User_01_TradeOwnerLoginInvalidEmail - Step 02 --> Input with valid password");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("TC_User_01_TradeOwnerLoginInvalidEmail - Step 03 --> Click Login Button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("TC_User_01_TradeOwnerLoginInvalidEmail - Step 04 --> Verify login failed");
		verifyEquals("Thông tin không chính xác", loginPage.getLoginFailedMessage());
		
//		log.info("***********************************************************************");
	}
	
	@Test
	public void TC_User_02_TradeOwnerLoginInvalidPassword() {
		passwordFailed = "A123!@#qqq";
		
		log.info("**************** TC02 - LOGIN WITH INVALID PASSWORD  ****************");
		
		loginPage.clearToEmailTextbox();
		loginPage.clearToPasswordTextbox();
		
		log.info("TC_User_02_TradeOwnerLoginInvalidPassword - Step 01 --> Input with valid email");
		loginPage.inputToEmailTextbox(emailI);
		
		log.info("TC_User_02_TradeOwnerLoginInvalidPassword - Step 02 --> Input with invalid password");
		loginPage.inputToPasswordTextbox(passwordFailed);
		
		log.info("TC_User_02_TradeOwnerLoginInvalidPassword - Step 03 --> Click Login Button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("TC_User_02_TradeOwnerLoginInvalidPassword - Step 04 --> Verify login failed");
		verifyEquals("Thông tin không chính xác", loginPage.getLoginFailedMessage());
		
//		log.info("***********************************************************************");
	}
	
	@Test
	public void TC_User_03_TradeOwnerLoginSuccess() {
		log.info("************* TC03 - LOGIN WITH VALID EMAIL & PASSWORD  **************");
		
		loginPage.clearToEmailTextbox();
		loginPage.clearToPasswordTextbox();
		
		log.info("TC_User_03_TradeOwnerLoginSuccess - Step 01 --> Input valid email");
		loginPage.inputToEmailTextbox(emailI);
		
		log.info("TC_User_03_TradeOwnerLoginSuccess - Step 02 --> Input valid password");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("TC_User_03_TradeOwnerLoginSuccess - Step 03 --> Click Button Login");
		homePage = loginPage.clickToLoginButton();
		
		log.info("TC_User_02_TradeOwnerLoginInvalidPassword - Step 04 --> Verify login success");
		nameUser = homePage.getNameUser();
		verifyEquals("Thanh Bình Tester", nameUser);
	}
	
//	@DataProvider
//	public Object[][] getDataCreateCustomer(){
//		Object[][] data = ExcelUtils.getTestData("Create New Account");
//		return data;
//	}
//
//	@Test(dataProvider = "getDataCreateCustomer")
//	public void TC_User_04_CreateDistributionAgency(String email, String name, String code, String address, String group) throws Exception {
//		log.info("******************** TC04 - CREATE NEW CUSTOMER  *********************");
//		
//		log.info("TC_User_04_CreateDistributionAgency - Step 01 --> Open Distribution Agency Page");
//		distributionAgencyPage = homePage.openDistriButionAgencyPage(driver);
//		
//		log.info("TC_User_04_CreateDistributionAgency - Step 02 --> Click to Create button");
//		distributionAgencyPage.clickToCreateButton();
//		
//		log.info("TC_User_04_CreateDistributionAgency - Step 03 --> Fill to email textbox" + email);
//		emailNew = "factorychild" + randomNumber() + "@gmail.com";
//		distributionAgencyPage.InputToEmailTextbox(email);
//		
//		log.info("TC_User_04_CreateDistributionAgency - Step 04 --> Fill to name textbox " + name);
//		distributionAgencyPage.InputToNameTextbox(name);
//		
//		log.info("TC_User_04_CreateDistributionAgency - Step 05 --> Fill to code textbox " + code);
//		distributionAgencyPage.InputToCodeTextbox(code);
//		
//		log.info("TC_User_04_CreateDistributionAgency - Step 06 --> Fill to invoce name textbox " + name);
//		distributionAgencyPage.InputToInvoiceNameTextbox(name);
//		
//		log.info("TC_User_04_CreateDistributionAgency - Step 07 --> Fill to address textbox " + address);
//		distributionAgencyPage.InputToInvoiceAddressTextbox(address);
//		
//		log.info("TC_User_04_CreateDistributionAgency - Step 08 --> Choose group " + group);
//		distributionAgencyPage.selectGroup(group);
//		
//		log.info("TC_User_04_CreateDistributionAgency - Step 09 --> Click to delete child");
//		distributionAgencyPage.clickToDeleteButton();
//		
//		log.info("TC_User_04_CreateDistributionAgency - Step 10 --> Click to Save Button");
//		distributionAgencyPage.clickToSaveButton();
//		
//		Thread.sleep(3000);
//	}

	@AfterClass
	public void afterClass() {
		log.info("	**********************  CLOSE BROWSER  ******************     ");
		closeBrowser();
	}

}
