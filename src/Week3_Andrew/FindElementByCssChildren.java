package Week3_Andrew;

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

public class FindElementByCssChildren {
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
	public void testFindElementInForm() {
		driver.get("http://azhang1/workspace/xpath.html");
		WebElement label = 
			driver.findElement(By.cssSelector("form label:first-child"));
		assertEquals("Username:", label.getText());
		
		WebElement label2 = 
			driver.findElement(By.cssSelector("form label:last-of-type"));
		assertEquals("Password:", label2.getText());
		
		WebElement input = 
			driver.findElement(By.cssSelector("form input:nth-child(5)"));
		assertEquals("secret", input.getAttribute("value"));
		WebElement input2 = 
			driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
		assertEquals("secret", input2.getAttribute("value"));	
	}
	
	@Test
	public void findCheckboxes() {
		driver.get("http://azhang1/workspace/xpath.html");
		List<WebElement> checkedLabels = 
			driver.findElements(By.cssSelector("ul#languages input:checked + label"));
		
		String[] expected = {"English", "Spanish"};
		
		List<String> actual = new ArrayList();
		
		for (WebElement label: checkedLabels) {
			actual.add(label.getText());
		}
		
		assertArrayEquals(expected, actual.toArray());
	}
	
	// first to find check/check box
	
	
	
	
}
