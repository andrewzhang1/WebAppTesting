package Week2;

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

public class FindElementBasicDemo {
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
				driver.findElement(By.className("label"));
		
		assertEquals(
			"Search",
			label.getText()
		);
	}

	@Test
	public void testFindElementByName() {
		driver.get("http://azhang1/workspace/search.html");

		WebElement input = 
				driver.findElement(By.name("keyword"));
		
		assertEquals(
			"Type in your keyword",
			input.getAttribute("value")
		);
	}
	
	@Test
	public void testFindElements() {
		driver.get("http://azhang1/workspace/search.html");

		List<WebElement> labels = 
				driver.findElements(By.tagName("label"));
		
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
	
	// Andrew Why do I have to have this method? Min's code doesn't have this one!
	private void assertArrayEquals(String[] expected, Object[] array) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testFindElementByLinkText() {
		driver.get("http://azhang1/workspace/links.html");
		
		WebElement link = 
			driver.findElement(By.linkText("Facebook"));
		
		assertEquals(
			"https://www.facebook.com/",
			link.getAttribute("href")
		);
		
	}
	
	@Test
	public void testFindElementByPartialText() {
		driver.get("http://azhang1/workspace/links.html");
		
		WebElement link = 
			driver.findElement(By.partialLinkText("Digg"));
		
		assertEquals(
			"http://www.digg.com/",
			link.getAttribute("href")
		);		
	}
	
	@Test
	public void testFindElementInsideElement() {
		driver.get("http://azhang1/workspace/links.html");

		WebElement firstOrderedList =
			driver.findElement(By.tagName("ol"));
		
		WebElement firstListItem = 
			driver.findElement(By.tagName("li"));
		
		WebElement firstListItemInFirstOrderedList =
			firstOrderedList.findElement(By.tagName("li"));
		
		assertEquals(
			"Google site",
			firstListItem.getText()
		);
		
		assertEquals(
			"Testing purpose",
			firstListItemInFirstOrderedList.getText()
		);
	}
}
