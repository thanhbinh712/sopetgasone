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
	String emailI, password, loginUrl, homePageUrl, emailNew, name, code, emailFailed, 
			passwordFailed, nameUser, message;

	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeClass
	public void beforeClass() {
		log.info("	**********************  OPEN BROWSER  ******************     ");
		driver = openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
		emailI = "thanhbinhtester@dvs.vn";
		password = "A123!@#";
	}
	
	@Test
	public void TC_User_01_TradeOwnerLoginInvalidEmail(){
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
	}
	
	@Test
	public void TC_User_03_TradeOwnerLoginSuccess(){
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

	@AfterClass
	public void afterClass() {
		log.info("	**********************  CLOSE BROWSER  ******************     ");
		closeBrowser();
	}

}
