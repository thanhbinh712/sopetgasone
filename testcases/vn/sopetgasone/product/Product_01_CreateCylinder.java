package vn.sopetgasone.product;

import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.ExcelUtils;
import commons.PageFactoryManager;
import pages.HomePage;
import pages.CreateCylinderPage;
import pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Product_01_CreateCylinder extends AbstractTest {
	WebDriver driver;
	static String loginUrl, email, password, filePath, brand, type, location, message;

	private static CreateCylinderPage createCylinderPage;
	private static LoginPage loginPage;
	private static HomePage homePage;

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

	@DataProvider
	public Object[][] getDataCreateCylinderWithExistCode() {
		Object[][] data = ExcelUtils.getTestData("CreateWithExistCode");
		return data;
	}

	@Test(dataProvider = "getDataCreateCylinderWithExistCode")
	public void TC_Product_01_CreateCylinderWithExistCode(String code, String type, String color, String valveType,
			String weight, String verificationDate, String brand) throws Exception {
		log.info("************* TC01 - CREATE PRODUCT  **************");
		log.info("TC_Product_01_CreateProduct - Step 01 --> Open Import Cylinder Page");
		createCylinderPage = homePage.openCreateCylinderPage(driver);

		log.info("TC_Product_01_CreateProduct - Step 02 --> Input to Cylinder Code: " + code);
		createCylinderPage.sendKeyToCylinderCode(code);

		log.info("TC_Product_01_CreateProduct - Step 03 --> Select Cylinder Type: " + type);
		createCylinderPage.selectCylinderType(type);

		log.info("TC_Product_01_CreateProduct - Step 04 --> Select Color: " + color);
		createCylinderPage.selectCylinderColor(color);

		log.info("TC_Product_01_CreateProduct - Step 05 --> Select Valve Type: " + valveType);
		createCylinderPage.selectValveType(valveType);

		log.info("TC_Product_01_CreateProduct - Step 06 --> Input to weight textbox: " + weight);
		createCylinderPage.sendKeyToWeight(weight);

		log.info("TC_Product_01_CreateProduct - Step 07 --> Choose verification date: " + verificationDate);
		createCylinderPage.sendKeyToVerifycationDate(verificationDate);

		log.info("TC_Product_01_CreateProduct - Step 08 --> Select Brand: " + brand);
		createCylinderPage.selectBrand(brand);

		log.info("TC_Product_01_CreateProduct - Step 09 --> Click to Upload Cylinder Button");
		createCylinderPage.clickToUploadButton();
		
		log.info("TC_Product_01_CreateProduct - Step 10 --> Verify exist cylinder code message");
		message = createCylinderPage.getAlertText();
		verifyEquals("Mã bình đã tồn tại. Vui lòng nhập mã khác!", message);
		createCylinderPage.acceptAlert(driver);
		
		createCylinderPage.clickToCloseButton();

		createCylinderPage.refreshPage();
	}

	@DataProvider
	public Object[][] getDataCreateCylinder() {
		Object[][] data = ExcelUtils.getTestData("Create Cylinder");
		return data;
	}

	@Test(dataProvider = "getDataCreateCylinder")
	public void TC_Product_02_CreateProduct(String code, String type, String color, String valveType, String weight,
			String verificationDate, String brand) throws Exception {
		log.info("************* TC02 - CREATE PRODUCT  **************");
		log.info("TC_Product_02_CreateProduct - Step 01 --> Open Import Cylinder Page");
		createCylinderPage = homePage.openCreateCylinderPage(driver);

		log.info("TC_Product_02_CreateProduct - Step 02 --> Input to Cylinder Code: " + code);
		createCylinderPage.sendKeyToCylinderCode(code);

		log.info("TC_Product_02_CreateProduct - Step 03 --> Select Cylinder Type: " + type);
		createCylinderPage.selectCylinderType(type);

		log.info("TC_Product_02_CreateProduct - Step 04 --> Select Color: " + color);
		createCylinderPage.selectCylinderColor(color);

		log.info("TC_Product_02_CreateProduct - Step 05 --> Select Valve Type: " + valveType);
		createCylinderPage.selectValveType(valveType);

		log.info("TC_Product_02_CreateProduct - Step 06 --> Input to weight textbox: " + weight);
		createCylinderPage.sendKeyToWeight(weight);

		log.info("TC_Product_02_CreateProduct - Step 07 --> Choose verification date: " + verificationDate);
		createCylinderPage.sendKeyToVerifycationDate(verificationDate);

		log.info("TC_Product_02_CreateProduct - Step 08 --> Select Brand: " + brand);
		createCylinderPage.selectBrand(brand);

		log.info("TC_Product_02_CreateProduct - Step 09 --> Click to Upload Cylinder Button");
		createCylinderPage.clickToUploadButton();

		Thread.sleep(3000);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
