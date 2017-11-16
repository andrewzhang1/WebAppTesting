package Week3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByCssDemo {
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
	public void testFindElementByClassname() {
		driver.get("http://azhang1/workspace/search.html");

		WebElement label = 
				driver.findElement(By.cssSelector(".label"));
		
		assertEquals(
			"Search",
			label.getText()
		);
	}

	@Test
	public void testFindElements() {
		driver.get("http://azhang1/workspace/search.html");

		List<WebElement> labels = 
				driver.findElements(By.cssSelector("label"));
		
		assertEquals(
				labels.size(), 2
			);		
		
		String[] expected = new String[] {
			"Search2", "Search"
		};
		
		List<String> actual = new ArrayList();
		for (WebElement label : labels) {
			actual.add(label.getText());
		}
		
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void testFindElementById() {
		driver.get("http://azhang1/workspace/search.html");

		WebElement input = 
				driver.findElement(By.cssSelector("#search"));
		
		assertEquals(
			"Type in your keyword",
			input.getAttribute("value")
		);
	}
	
	@Test
	public void testFindElementByName() {
		driver.get("http://azhang1/workspace/search.html");

		WebElement input = 
				driver.findElement(By.cssSelector("[name='keyword']"));
		
		assertEquals(
			"Type in your keyword",
			input.getAttribute("value")
		);
	}
	
	// There is no CSS rule based on the contained text
	// So, cannot use CSS selector to search link text
//	@Test
//	public void testFindElementByLinkText() {
//		driver.get("http://10.20.8.231:8080/workspace/links.html");
//		
//		WebElement link = 
//			driver.findElement(By.linkText("Facebook"));
//		
//		assertEquals(
//			"https://www.facebook.com/",
//			link.getAttribute("href")
//		);
//		
//	}
	
//	@Test
//	public void testFindElementByPartialText() {
//		driver.get("http://10.20.8.231:8080/workspace/links.html");
//		
//		WebElement link = 
//			driver.findElement(By.partialLinkText("Digg"));
//		
//		assertEquals(
//			"http://www.digg.com/",
//			link.getAttribute("href")
//		);		
//	}
	
}
