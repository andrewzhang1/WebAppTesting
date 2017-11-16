package Week5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_PhpWaitTest {
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
	public void testSubmit() {
		driver.get("http://azhang1/workspace/wait.php");
		WebElement input = driver.findElement(By.id("name"));
		input.clear();
		input.sendKeys("John");
		input.submit();
		
		// selenium wait until the next page is loaded.
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("John", display.getText());
	}
}
