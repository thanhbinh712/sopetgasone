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
	String email, password, loginUrl, emailNew, name, code, emailFailed, passwordFailed;

	private LoginPage loginPage;
	private HomePage homePage;
	private CreateAccountPage createAccountPage;

	int steps = 0;

	@BeforeClass
	public void beforeClass() {
		log.info("----------OPEN BROWSER----------");
		driver = openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);

		loginUrl = loginPage.getLoginPageUrl();
		email = "thanhbinhtester@dvs.vn";
		password = "A123!@#";
		
	}
	
	@Test
	public void TC_User_01_TNSHLoginfailed() {
		emailFailed = "ttthanhbinhtester@dvs.vn";
		passwordFailed = "A123!@#";
		log.info("----------LOGIN FAILED----------");
		
		log.info("TC_User_01_TNSHLoginfailed - Step 01 --> Input invalid email");
		loginPage.inputToEmailTextbox(emailFailed);
		
		log.info("TC_User_01_TNSHLoginfailed - Step 02 --> Input invalid password");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("TC_User_01_TNSHLoginfailed - Step 03 --> Click Button Login");
		homePage = loginPage.clickToLoginButton();
		
		log.info("TC_User_01_TNSHLoginfailed - Step 04 --> Verify login failed");
		verifyEquals("Thông tin không chính xác", loginPage.getLoginFailedMessage());
		
		log.info("**********************LOGIN FAILED*****************");
		log.info("**********************TC01*****************");
	}
	
	@Test
	public void TC_User_02_TNSHLoginSuccess() {
		
		log.info("----------LOGIN----------");
		
		log.info("TC_User_02_TNSHLoginSuccess - Step 01 --> Clear old email");
		loginPage.clearToEmailTextbox();
		
		log.info("TC_User_02_TNSHLoginSuccess - Step 02 --> Input valid email");
		loginPage.inputToEmailTextbox(email);
		
		log.info("TC_User_02_TNSHLoginSuccess - Step 03 --> Clear old password");
		loginPage.clearToPasswordTextbox();
		
		log.info("TC_User_02_TNSHLoginSuccess - Step 04 --> Input valid password");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("TC_User_02_TNSHLoginSuccess - Step 05 --> Click Button Login");
		homePage = loginPage.clickToLoginButton();
		
		log.info("**********************LOGIN SUCCESS*****************");
		log.info("**********************TC01*****************");
	}

	@Test
	public void TC_User_03_CreateCustomerAccount() {
		Faker faker = new Faker();
		log.info("TC_User_01_CreateFactoryChild - Step 01 --> Click to Bussiness MenuLink");
		homePage.clickToBussinessMenuLink();
		
		log.info("TC_User_01_CreateFactoryChild - Step 02 --> Click to FactoryChild MenuLink");
		createAccountPage = homePage.clickFactoryChildMenuLink();
		
		log.info("TC_User_01_CreateFactoryChild - Step 03 --> Click to Create button");
		createAccountPage.clickToCreateButton();
		
		log.info("TC_User_01_CreateFactoryChild - Step 04 --> Fill to email textbox");
		emailNew = "factorychild" + randomNumber() + "@gmail.com";
		createAccountPage.InputToEmailTextbox(emailNew);
		
		log.info("TC_User_01_CreateFactoryChild - Step 05 --> Fill to name textbox");
		createAccountPage.InputToNameTextbox(faker.name().fullName());
		
		code = "KHO" + randomNumber();
		log.info("TC_User_01_CreateFactoryChild - Step 06 --> Fill to code textbox");
		createAccountPage.InputToCodeTextbox(code);
		
		log.info("TC_User_01_CreateFactoryChild - Step 07 --> Fill to code textbox");
		createAccountPage.InputToAddressTextbox(faker.address().fullAddress());
		
		log.info("TC_User_01_CreateFactoryChild - Step 08 --> Click to Save Button");
		createAccountPage.clickToSaveButton();
		
		log.info("**********************TC01*****************");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
