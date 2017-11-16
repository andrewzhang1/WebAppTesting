package Week3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputTest {
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
		//driver.quit();	
	}
	
	@Test
	public void testForm() {
		driver.get("http://azhang1/workspace/input.html");
		
		WebElement name = 
				driver.findElement(By.id("name"));
		WebElement password = 
				driver.findElement(By.id("password"));
			
		name.clear();
		name.sendKeys("John");
		password.clear();
		password.sendKeys("secret");
		
		WebElement btn =
				driver.findElement(By.cssSelector("[type='button']"));
		btn.click();
		
		WebElement display =
				driver.findElement(By.id("display"));
		
		assertEquals("Hello John", display.getText());
		assertEquals("", name.getAttribute("value"));
	}
}
