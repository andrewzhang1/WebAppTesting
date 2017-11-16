package Week1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestDemo {
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
	public void testResult() {
		driver.get("http://azhang1/workspace/helloworld.html");

		WebElement h1 = 
				driver.findElement(By.tagName("h1"));
		
		assertEquals(
			"Hello World",
			h1.getText()
		);
	}
}
