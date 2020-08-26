package vn.sopetgasone.product;

import org.testng.annotations.Test;

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
	String email = "thanhbinhtester@dvs.vn";
	String password = "A123!@#";
    String success_message = "Tạo mới thành công!";
    String existcode_message = "Mã bình đã tồn tại. Vui lòng nhập mã khác!";
    String emptycode_message = "Không được để trống.";

	private static CreateCylinderPage createCylinderPage;
	private static LoginPage loginPage;
	private static HomePage homePage;

	@BeforeClass
	public void beforeClass() {
		driver = openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
	}
	
	@DataProvider
	public Object[][] getDataCreateCylinder() {
		Object[][] data = ExcelUtils.getTestData("Create Cylinder");
		return data;
	}

	@Test(dataProvider = "getDataCreateCylinder")
	public void TC_Product_01_CreateProductSuccess(String code, String type, String color, String valveType, String weight,
			String verificationDate, String brand) throws Exception {
		log.info("************* TC01 - CREATE PRODUCT SUCCESS  **************");
		log.info("TC_Product_01_CreateProductSuccess - Step 01 --> Open Import Cylinder Page");
		createCylinderPage = homePage.openCreateCylinderPage(driver);
		
		log.info("TC_Product_01_CreateProductSuccess - Step 02 --> Input to Cylinder Code: " + code);
		createCylinderPage.sendKeyToCylinderCode(code);

		log.info("TC_Product_01_CreateProductSuccess - Step 03 --> Select Cylinder Type: " + type);
		createCylinderPage.selectCylinderType(type);

		log.info("TC_Product_01_CreateProductSuccess - Step 04 --> Select Color: " + color);
		createCylinderPage.selectCylinderColor(color);

		log.info("TC_Product_01_CreateProductSuccess - Step 05 --> Select Valve Type: " + valveType);
		createCylinderPage.selectValveType(valveType);

		log.info("TC_Product_01_CreateProductSuccess - Step 06 --> Input to weight textbox: " + weight);
		createCylinderPage.sendKeyToWeight(weight);

		log.info("TC_Product_01_CreateProductSuccess - Step 07 --> Choose verification date: " + verificationDate);
		createCylinderPage.sendKeyToVerifycationDate(verificationDate);

		log.info("TC_Product_01_CreateProductSuccess - Step 08 --> Select Brand: " + brand);
		createCylinderPage.selectBrand(brand);

		log.info("TC_Product_01_CreateProductSuccess - Step 09 --> Click to Upload Cylinder Button");
		createCylinderPage.clickToUploadButton();
		
		log.info("TC_Product_01_CreateProductSuccess - Step 10 --> Verify success message: " + success_message);
		verifyEquals(success_message, createCylinderPage.getMessageSuccess());
		
		Thread.sleep(3000);
	}

	@DataProvider
	public Object[][] getDataCreateCylinderWithExistCode() {
		Object[][] data = ExcelUtils.getTestData("CreateWithExistCode");
		return data;
	}
	
	@Test(dataProvider = "getDataCreateCylinderWithExistCode")
	public void TC_Product_02_CreateCylinderWithEmptyCode(String code, String type, String color, String valveType,
			String weight, String verificationDate, String brand) throws Exception {
		log.info("************* TC02 - CREATE PRODUCT WITH EMPTY CODE **************");
		log.info("TC_Product_02_CreateCylinderWithEmptyCode - Step 01 --> Open Import Cylinder Page");
		createCylinderPage = homePage.openCreateCylinderPage(driver);

		log.info("TC_Product_02_CreateCylinderWithEmptyCode - Step 02 --> Input to Cylinder Code: " + " ");
		createCylinderPage.sendKeyToCylinderCode(" ");

		log.info("TC_Product_02_CreateCylinderWithEmptyCode - Step 03 --> Select Cylinder Type: " + type);
		createCylinderPage.selectCylinderType(type);
		
		log.info("TC_Product_02_CreateCylinderWithEmptyCode - Step 04 --> Verify empty cylinder code message: " + emptycode_message);
		verifyEquals(emptycode_message, createCylinderPage.getEmptyMessage());
		
		createCylinderPage.refreshPage();
	}
 
	@Test(dataProvider = "getDataCreateCylinderWithExistCode")
	public void TC_Product_03_CreateCylinderWithExistCode(String code, String type, String color, String valveType,
			String weight, String verificationDate, String brand) throws Exception {
		log.info("************* TC03 - CREATE PRODUCT WITH EXIST CODE  **************");
		log.info("TC_Product_03_CreateCylinderWithExistCode - Step 01 --> Open Import Cylinder Page");
		createCylinderPage = homePage.openCreateCylinderPage(driver);

		log.info("TC_Product_03_CreateCylinderWithExistCode - Step 02 --> Input to Cylinder Code: " + code);
		createCylinderPage.sendKeyToCylinderCode(code);

		log.info("TC_Product_03_CreateCylinderWithExistCode - Step 03 --> Select Cylinder Type: " + type);
		createCylinderPage.selectCylinderType(type);

		log.info("TC_Product_03_CreateCylinderWithExistCode - Step 04 --> Select Color: " + color);
		createCylinderPage.selectCylinderColor(color);

		log.info("TC_Product_03_CreateCylinderWithExistCode - Step 05 --> Select Valve Type: " + valveType);
		createCylinderPage.selectValveType(valveType);

		log.info("TC_Product_03_CreateCylinderWithExistCode - Step 06 --> Input to weight textbox: " + weight);
		createCylinderPage.sendKeyToWeight(weight);

		log.info("TC_Product_03_CreateCylinderWithExistCode - Step 07 --> Choose verification date: " + verificationDate);
		createCylinderPage.sendKeyToVerifycationDate(verificationDate);

		log.info("TC_Product_03_CreateCylinderWithExistCode - Step 08 --> Select Brand: " + brand);
		createCylinderPage.selectBrand(brand);

		log.info("TC_Product_03_CreateCylinderWithExistCode - Step 09 --> Click to Upload Cylinder Button");
		createCylinderPage.clickToUploadButton();
		
		log.info("TC_Product_03_CreateCylinderWithExistCode - Step 10 --> Verify exist cylinder code message : " + existcode_message);
		verifyEquals(existcode_message, createCylinderPage.getAlertText());
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
