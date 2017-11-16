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

public class FindElementByXPathDemo2 {
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
			driver.findElements(By.xpath("//*[@target]"));
		
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
}
