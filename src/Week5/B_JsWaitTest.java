package Week5;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class B_JsWaitTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"./drivers/chromedriver.exe"
				);
		driver = new ChromeDriver();

		// implicit wait is very generic
		// cannot specify which element to wait
		// only wait for the case that the element is not in DOM tree.
		driver.manage()
			.timeouts()
			.implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After	
	public void tearDown() {
		driver.quit();	
	}
	
	@Test
	public void testSubmit() {
		driver.get("http://azhang1/workspace/jswait.html");
		WebElement input = driver.findElement(By.id("name"));
		input.clear();
		input.sendKeys("John");
		WebElement btn = driver.findElement(By.id("btn"));
		btn.click();
		
		// Since there is no page reload,
		// selenium cannot wait by default.
		
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("John", display.getText());
	}
}
