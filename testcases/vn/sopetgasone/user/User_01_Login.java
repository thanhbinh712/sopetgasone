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

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_01_Login extends AbstractTest {
	WebDriver driver;
	String valid_email = "thanhbinhtester@dvs.vn";
	String valid_password = "A123!@#";
	String invalid_email = "ttthanhbinhtester@dvs.vn";
	String wrong_pass = "A123!@#qqq";
	String nameUser = "Thanh Bình Tester";
	String space_email = "   ";
	String empty_message = "Không được để trống.";
	String loginFailed_message = "Thông tin không chính xác";

	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeClass
	public void beforeClass() {
		log.info("	**********************  OPEN BROWSER  ******************     ");
		driver = openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
	}
	
	@Test
	public void TC_User_01_TradeOwnerLoginSuccess(){
		log.info("************* TC01 - LOGIN WITH VALID EMAIL & PASSWORD  **************");
		
		log.info("TC_User_01_TradeOwnerLoginSuccess - Step 01 --> Input valid email: " + valid_email);
		loginPage.inputToEmailTextbox(valid_email);
		
		log.info("TC_User_01_TradeOwnerLoginSuccess - Step 02 --> Input valid password: "+ valid_password);
		loginPage.inputToPasswordTextbox(valid_password);
		
		log.info("TC_User_01_TradeOwnerLoginSuccess - Step 03 --> Click Button Login ");
		homePage = loginPage.clickToLoginButton();
		
		log.info("TC_User_01_TradeOwnerLoginSuccess - Step 04 --> Seeing name user " + nameUser);
	 
		verifyEquals(nameUser, homePage.getNameUser());
	}
	
	
	@Test
	public void TC_User_02_TradeOwnerLoginInvalidEmail(){
		loginPage = homePage.openLoginPage(driver);
		log.info("**************** TC02 - LOGIN WITH INVALID EMAIL  ****************");
		
		log.info("TC_User_02_TradeOwnerLoginInvalidEmail - Step 01 --> Input with invalid email: " + invalid_email);
		loginPage.inputToEmailTextbox(invalid_email);
		
		log.info("TC_User_02_TradeOwnerLoginInvalidEmail - Step 02 --> Input with valid password: " + valid_password);
		loginPage.inputToPasswordTextbox(valid_password);
		
		log.info("TC_User_02_TradeOwnerLoginInvalidEmail - Step 03 --> Click Login Button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("TC_User_02_TradeOwnerLoginInvalidEmail - Step 04 --> Verify login failed message: " + loginFailed_message);
		verifyEquals(loginFailed_message, loginPage.getLoginFailedMessage());
	}
	
	@Test
	public void TC_User_03_TradeOwnerLoginInvalidPassword() {
		
		loginPage = homePage.openLoginPage(driver);
		log.info("**************** TC03 - LOGIN WITH INVALID PASSWORD  ****************");
		
		log.info("TC_User_03_TradeOwnerLoginInvalidPassword - Step 01 --> Input with valid email: " + valid_email);
		loginPage.inputToEmailTextbox(valid_email);
		
		log.info("TC_User_03_TradeOwnerLoginInvalidPassword - Step 02 --> Input with invalid password: " + wrong_pass);
		loginPage.inputToPasswordTextbox(wrong_pass);
		
		log.info("TC_User_03_TradeOwnerLoginInvalidPassword - Step 03 --> Click Login Button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("TC_User_03_TradeOwnerLoginInvalidPassword - Step 04 --> Verify login failed message : " + loginFailed_message);
		verifyEquals(loginFailed_message, loginPage.getLoginFailedMessage());
	}
	
	@Test
	public void TC_User_04_TradeOwnerLoginSpaceEmail() {
		
		loginPage = homePage.openLoginPage(driver);
		log.info("**************** TC04 - LOGIN WITH SPACE EMAIL TEXTBOX  ****************");
		
		log.info("TC_User_04_TradeOwnerLoginSpaceEmail - Step 01 --> Input with space email textbox: " + space_email);
		loginPage.inputToEmailTextbox(space_email);
		
		log.info("TC_User_04_TradeOwnerLoginSpaceEmail - Step 02 --> Input with valid password: " + valid_password);
		loginPage.inputToPasswordTextbox(valid_password);
		
		log.info("TC_User_04_TradeOwnerLoginSpaceEmail - Step 03 --> Click Login Button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("TC_User_04_TradeOwnerLoginSpaceEmail - Step 04 --> Verify login failed message: " + empty_message);
		verifyEquals(empty_message, loginPage.getEmptyMessage());
	}

	@AfterClass
	public void afterClass() {
		log.info("	**********************  CLOSE BROWSER  ******************     ");
		closeBrowser();
	}

}
