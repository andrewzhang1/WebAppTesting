package Week4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_phpFormTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"./drivers/chromedriver.exe"
				);
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();	
	}
	
	@Test
	public void testPhpForm() {
		driver.get("http://azhang1/workspace/form.php");
		
		// I am in the first page
		WebElement display = 
			driver.findElement(By.id("display"));
		assertEquals("", display.getText());
		
		WebElement input = 
			driver.findElement(By.id("id"));
//		WebElement btn = 
//			driver.findElement(By.id("btn"));
		input.clear();
		input.sendKeys("John");
		input.submit();
//		btn.click();
		
		// I am in the second NEW page: Selenium is very good at waiting!!
		display = driver.findElement(By.id("display"));
		input = driver.findElement(By.id("id"));
		assertEquals("John", display.getText());
		assertEquals("", input.getAttribute("value"));
	}
}
