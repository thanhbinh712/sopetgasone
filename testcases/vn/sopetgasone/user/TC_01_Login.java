package vn.sopetgasone.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.LoginPage;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC_01_Login extends AbstractTest{
	WebDriver driver;
	String email, password, loginUrl;
	
	private LoginPage loginPage;
	
	int steps = 0;
	
	@BeforeClass
	  public void beforeClass() {
		log.info("----------OPEN BROWSER----------");
		driver = openBrowser();
		
		loginPage = PageFactoryManager.getLoginPage(driver);
		
		loginUrl = loginPage.getLoginPageUrl();
		email = "thuongnhansohuu1@gmail.com";
		log.info("Step: " + (steps + 1) + "--> " + "Login with email: " + email);
	  }
	
  @Test
  public void login() {
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("binhtest2407@gmail.com");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("A123!@#");
	  driver.findElement(By.xpath("//button[@class='btn btn-bold btn-block btn-primary']")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//button[@class='btn btn-sm btn-create excell kiemdinh']")).click();
	  driver.findElement(By.xpath("//div[@id='import-product']//div//div//div//form//div//div//div//div"
	  		+ "//div//div//input[@name='upload_file']")).sendKeys("C:\\Users\\n16dc\\Desktop\\TestData.xlsx");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
