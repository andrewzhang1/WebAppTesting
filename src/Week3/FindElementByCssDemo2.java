package Week3;

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

public class FindElementByCssDemo2 {
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
	public void testFindLinksWithTargetAttribute() {
		driver.get("http://azhang1/workspace/links.html");
		List<WebElement> links = 
			driver.findElements(By.cssSelector("[target]"));
		
		String[] expected = {
			"https://www.google.com/",
			"http://www.msn.com/"
		};
		
		List<String> actual = new ArrayList();
		for (WebElement link: links) {
			actual.add(link.getAttribute("href"));
		}
		
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testFindFirstLinkThatOpenInNewTab() {
		driver.get("http://azhang1/workspace/links.html");
		WebElement link = 
			driver.findElement(By.cssSelector("[target='_blank']"));
		assertEquals("MSN Link", link.getText());
	}
	
	@Test
	public void testFindAllSecureLinks() {
		driver.get("http://azhang1/workspace/links.html");
		List<WebElement> links =
			driver.findElements(By.cssSelector("[href^='https']"));
		assertEquals(4, links.size());
	}	
	
	@Test
	public void testFindSomePDFLink() {
		driver.get("http://azhang1/workspace/links.html");
		WebElement pdf =
			driver.findElement(By.cssSelector("#list2 [href$='.pdf']"));
		
		assertEquals("Contract draft 2", pdf.getText());
	}
	
	@Test
	public void testFindPasswordInput() {
		driver.get("http://azhang1/workspace/xpath.html");
		WebElement password = 
			driver.findElement(By.cssSelector("[type='password']"));
		
		assertEquals("secret", password.getAttribute("value"));
	}
}
