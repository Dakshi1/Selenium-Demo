package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TestBankingApp {

	WebDriver webDriver;
	
	@BeforeClass
	public static void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/daksuri/Downloads/chromedriver_win32/chromedriver.exe");
	}
	
	@Before
	public void setup() {
		webDriver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		webDriver.quit();
	}
	
//	@Parameterized.Parameters
//	public static Collection<?> data() {
//		return Arrays.asList(new Object[][]{
//				{"John doe", "john.doe@example.com", "555 4844 231"},
//				{"Jane doe", "jane.doe@example.com", "555 2345 123"},
//				{"Ramesh Kumar", "ramesh.kumar@example.com", "984 4731 883"}
//			});
//	}
	
	@Test
	public void testLogin1() {
		
		webDriver.get("http://localhost:3000");
		WebElement elem = webDriver.findElement(By.id("username"));
		elem.sendKeys("Sharlene15");
		elem=webDriver.findElement(By.id("password"));
		elem.sendKeys("User123#");
		webDriver.findElement(By.id("submit")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elem=webDriver.findElement(By.id("welcome"));
		Assert.assertEquals(elem.getText(), "Welcome to Marcus");
	}
	@Test
	public void testLogin2() {
		
		webDriver.get("http://localhost:3000");
		WebElement elem = webDriver.findElement(By.id("username"));
		elem.sendKeys("Sharlene15");
		elem=webDriver.findElement(By.id("password"));
		elem.sendKeys("User123");
		webDriver.findElement(By.id("submit")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elem=webDriver.findElement(By.id("error"));
		Assert.assertEquals(elem.getText(), "incorrect username/password");
	}
	@Test
	public void testLogin3() {
		
		webDriver.get("http://localhost:3000");
		WebElement elem = webDriver.findElement(By.id("username"));
		elem.sendKeys("Sharlene15");
		elem=webDriver.findElement(By.id("password"));
		elem.sendKeys("User123#");
		webDriver.findElement(By.id("submit")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.id("payment")).click();
		webDriver.findElement(By.id("qTransfer")).click();
		elem=webDriver.findElement(By.id("user_tag"));
		Assert.assertEquals(elem.getText(), "Username");
	}

	@Test
	public void testLogin4() {
		
		webDriver.get("http://localhost:3000");
		WebElement elem = webDriver.findElement(By.id("username"));
		elem.sendKeys("Sharlene15");
		elem=webDriver.findElement(By.id("password"));
		elem.sendKeys("User123#");
		webDriver.findElement(By.id("submit")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.findElement(By.id("payment")).click();
		webDriver.findElement(By.id("qTransfer")).click();
		elem=webDriver.findElement(By.id("name"));
		elem.sendKeys("dakshi");
		elem=webDriver.findElement(By.id("account_number"));
		elem.sendKeys("20248699904");
		elem=webDriver.findElement(By.id("conf_account_number"));
		elem.sendKeys("dakshi");
		elem=webDriver.findElement(By.id("amount"));
		elem.sendKeys("10000");
		elem=webDriver.findElement(By.id("purpose"));
		elem.sendKeys("loan");
		webDriver.findElement(By.id("submit")).click();

		elem=webDriver.findElement(By.id("name"));
		Assert.assertEquals(elem.getText(), "dakshi");

		elem=webDriver.findElement(By.id("account_number"));
		Assert.assertEquals(elem.getText(), "20248699904");

		elem=webDriver.findElement(By.id("purpose"));
		Assert.assertEquals(elem.getText(), "loan");
	}
}
