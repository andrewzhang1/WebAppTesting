package Week4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class C_SelectTest {
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
	public void testIsMultiple() {
		driver.get("http://azhang1/workspace/select.html");
		Select select = 
			new Select(
				driver.findElement(By.id("car"))
			);
		assertFalse(select.isMultiple());
	}
	
	@Test
	public void testOptions() {
		driver.get("http://azhang1/workspace/select.html");
		Select select = 
			new Select(
				driver.findElement(By.id("car"))
			);
		List<WebElement> options = select.getOptions();
		
		assertEquals(5, options.size());
		
		String[] expected = {
			"Pick a car", "Volvo", "Saab", "Mercedes", "Audi"
		};
		
		List<String> actual = new ArrayList();
		for (WebElement option: options) {
			actual.add(option.getText());
		}
		
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testSelect() {
		driver.get("http://azhang1/workspace/select.html");
		Select select = 
				new Select(
					driver.findElement(By.id("car"))
				);
		
		// default selected value
		WebElement selected = 
				select.getFirstSelectedOption();
		assertEquals("Pick a car", selected.getText());
		
		WebElement display = 
			driver.findElement(By.id("display"));
		
		// first selection
		select.selectByVisibleText("Audi");
		selected = 
			select.getFirstSelectedOption();
		
		assertEquals("Audi", selected.getText());
		assertEquals("Audi", display.getText());
		
		// second selection
		select.selectByValue("");
		selected = select.getFirstSelectedOption();
		assertEquals("Pick a car", selected.getText());
		
		// third selection
		select.selectByIndex(3);
		selected = select.getFirstSelectedOption();
		assertEquals("Mercedes", selected.getText());
	}
}
