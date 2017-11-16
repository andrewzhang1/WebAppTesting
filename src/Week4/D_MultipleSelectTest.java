package Week4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D_MultipleSelectTest {
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
	
//	@Test
//	public void testIsMultiple() {
//		driver.get("http://10.20.8.237:8080/workspace/multiple.html");
//		Select select = 
//			new Select(
//				driver.findElement(By.id("color"))
//			);
//		assertTrue(select.isMultiple());
//	}
	
	@Test
	public void testSelection() {
		driver.get("http://azhang1/workspace/multiple.html");
		Select select = 
			new Select(
				driver.findElement(By.id("color"))
			);
		
		select.selectByIndex(2);
		select.selectByIndex(1);
		select.deselectByValue("wt");
		select.selectByVisibleText("Brown");
		select.deselectByIndex(2);
		select.selectByValue("bl");
		
		WebElement display = 
			driver.findElement(By.id("display"));
		assertEquals("Black,Brown", display.getText());
	}
}
