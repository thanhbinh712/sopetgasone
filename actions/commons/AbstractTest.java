package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {
	public final Log log;
	
	public AbstractTest() {
		// khởi tạo constructor
		log = LogFactory.getLog(getClass());
	}
	
	WebDriver driver;
	
	public WebDriver openBrowser() {
		System.setProperty("webdriver.chrome.driver", "browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GlobalConstants.TEST_URL);
		return driver;
	}
	
	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(9999);
		return number;
	}
	
	protected boolean verifyPassed(boolean condition, boolean flag) {
		boolean pass = true;
		if(flag == false) {
			try {
				if(condition == true) 
					log.info("[PASSED]");
				else
					log.info("[FAILED]");
				Assert.assertTrue(condition);
			}catch(Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		}
		else {
			Assert.assertTrue(condition);
		}
		return pass;
	}
	
	protected boolean verifyTrue(boolean condition) {
		return verifyPassed(condition, false);
	}
	
	protected boolean verifyFailed(boolean condition, boolean flag) {
		boolean pass = true;
		if(flag == false) {
			try {
				if(condition == false) 
					log.info("[PASSED]");
				else
					log.info("[FAILED]");
				Assert.assertTrue(condition);
			}catch(Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		}
		else {
			Assert.assertTrue(condition);
		}
		return pass;
	}
	
	protected boolean verifyFalse(boolean condition) {
		return verifyFailed(condition, false);
	}
	
	protected boolean verifyEquals(Object actual, Object expected, boolean flag) {
		boolean pass = true;
		if(flag == false) {
			try {
				Assert.assertEquals(actual, expected);
			}catch(Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		}
		else {
			Assert.assertEquals(actual, expected);
		}
		return pass;
	}
	
	protected boolean verifyEquals(Object actual, Object expected) {
		return verifyEquals(actual, expected, false);
	}
	
	public void closeBrowser() {
		try {
			driver.quit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
