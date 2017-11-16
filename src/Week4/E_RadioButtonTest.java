package Week4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E_RadioButtonTest {
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
	public void testMenu() {
		driver.get("http://azhang1/workspace/radiobuttons.html");
		
		WebElement fish = 
			driver.findElement(By.cssSelector(
				"input[type='radio'][name='burger'][value='fish']"
			));
		fish.click();
		
		WebElement pickle = 
			driver.findElement(By.cssSelector(
				"input[type='radio'][name='side'][value='pickle']"
			));
		pickle.click();		
		
		WebElement soda = 
			driver.findElement(By.cssSelector(
				"input[type='radio'][name='drink'][value='soda']"
			));
		soda.click();
		
		WebElement price = 
			driver.findElement(By.id("price"));
		assertEquals("6", price.getText());
		
		WebElement juice = 
			driver.findElement(By.cssSelector(
				"input[type='radio'][name='drink'][value='juice']"
			));
		juice.click();		
		
		// findElement is not required here because
		// we are in the same page.
		//price = driver.findElement(By.id("price"));
		assertEquals("8", price.getText());
	}
	
	@Test
	public void testDrinkMenu() {
		driver.get("http://azhang1/workspace/radiobuttons.html");
		WebElement juice = 
				driver.findElement(By.cssSelector(
					"input[type='radio'][name='drink'][value='juice']"
				));
			juice.click();
			
		List<WebElement> drinks = 
			driver.findElements(By.cssSelector(
				"ul:nth-of-type(3) input[type='radio']"
			));
		
		for (WebElement drink: drinks) {
			if (drink.getAttribute("value").equals("juice")) {
				assertTrue(drink.isSelected());
			} else {
				assertFalse(drink.isSelected());
			}
		}
	}
}
