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

public class Product_01_CreateCylinder extends AbstractTest  {
	WebDriver driver;
	static String loginUrl, email, password, filePath, brand, type, location;
	
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
	public Object[][] getDataCreateCylinder(){
		Object[][] data = ExcelUtils.getTestData("Create Cylinder");
		return data;
	}
	 
	
	 @Test(dataProvider = "getDataCreateCylinder")
	 public void TC_Product_01_CreateProduct(String code, String type, String color, String valveType, String weight, String brand) throws Exception {
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
		 
		 log.info("TC_Product_01_CreateProduct - Step 07 --> Select Brand: " + brand);
		 createCylinderPage.selectBrand(brand);

		 log.info("TC_Product_01_CreateProduct - Step 06 --> Click to Upload Cylinder: ");
		 createCylinderPage.clickToUploadButton();
		 
		 Thread.sleep(5000);
	 }

	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }

}
