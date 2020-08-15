package vn.sopetgasone.user;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_01_LoginAndCreateUser extends AbstractTest {
	WebDriver driver;
	String email, password, loginUrl, homePageUrl, emailNew, name, code, emailFailed, 
			passwordFailed, nameUser;

	private LoginPage loginPage;
	private HomePage homePage;
	private CreateAccountPage createAccountPage;

	@BeforeClass
	public void beforeClass() {
		log.info("	**********************  OPEN BROWSER  ******************     ");
		driver = openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginUrl = loginPage.getLoginPageUrl();
		email = "thanhbinhtester@dvs.vn";
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
		loginPage.inputToEmailTextbox(email);
		
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
		loginPage.inputToEmailTextbox(email);
		
		log.info("TC_User_03_TradeOwnerLoginSuccess - Step 02 --> Input valid password");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("TC_User_03_TradeOwnerLoginSuccess - Step 03 --> Click Button Login");
		homePage = loginPage.clickToLoginButton();
		
		log.info("TC_User_02_TradeOwnerLoginInvalidPassword - Step 04 --> Verify login success");
		nameUser = homePage.getNameUser();
		verifyEquals("Thanh Bình Tester", nameUser);
	}

	@Test
	public void TC_User_04_CreateCustomerAccount() {
		Faker faker = new Faker();
		log.info("TC_User_04_CreateCustomerAccount - Step 01 --> Click to Bussiness MenuLink");
		homePage.clickToBussinessMenuLink();
		
		log.info("TC_User_04_CreateCustomerAccount - Step 02 --> Click to FactoryChild MenuLink");
		createAccountPage = homePage.clickFactoryChildMenuLink();
		
		log.info("TC_User_04_CreateCustomerAccount - Step 03 --> Click to Create button");
		createAccountPage.clickToCreateButton();
		
		log.info("TC_User_04_CreateCustomerAccount - Step 04 --> Fill to email textbox");
		emailNew = "factorychild" + randomNumber() + "@gmail.com";
		createAccountPage.InputToEmailTextbox(emailNew);
		
		log.info("TC_User_04_CreateCustomerAccount - Step 05 --> Fill to name textbox");
		createAccountPage.InputToNameTextbox(faker.name().fullName());
		
		code = "KHO" + randomNumber();
		log.info("TC_User_04_CreateCustomerAccount - Step 06 --> Fill to code textbox");
		createAccountPage.InputToCodeTextbox(code);
		
		log.info("TC_User_04_CreateCustomerAccount - Step 07 --> Fill to code textbox");
		createAccountPage.InputToAddressTextbox(faker.address().fullAddress());
		
		log.info("TC_User_04_CreateCustomerAccount - Step 08 --> Click to Save Button");
		createAccountPage.clickToSaveButton();
		
		log.info("**********************TC01*****************");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
