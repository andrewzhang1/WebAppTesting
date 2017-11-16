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
	
//	@Test
//	public void testFindLinksWithTargetAttribute() {
//		driver.get("http://10.20.9.17:8080/workspace/links.html");
//		List<WebElement> links = 
//			driver.findElements(By.xpath("//*[@target]"));
//		
//		String[] expected = {
//			"https://www.google.com/",
//			"http://www.msn.com/"
//		};
//		
//		List<String> actual = new ArrayList();
//		for (WebElement link: links) {
//			actual.add(link.getAttribute("href"));
//		}
//		
//		assertArrayEquals(expected, actual.toArray());
//	}
//	
//	@Test
//	public void testFindFirstLinkThatOpenInNewTab() {
//		driver.get("http://10.20.9.17:8080/workspace/links.html");
//		WebElement link = 
//			driver.findElement(By.xpath("//a[@target='_blank']"));
//		assertEquals("MSN Link", link.getText());
//	}
//	
//	@Test
//	public void testFindAllSecureLinks() {
//		driver.get("http://10.20.9.17:8080/workspace/links.html");
//		List<WebElement> links =
//			driver.findElements(By.xpath("//a[starts-with(@href, 'https')]"));
//		assertEquals(4, links.size());
//	}
	
	@Test
	public void testAncestors() {
		driver.get("http://azhang1/workspace/xpath.html");
		
		List<WebElement> divs = 
			driver.findElements(By.xpath("//p[@id='bye']/ancestor::div"));
		
		for (WebElement div: divs) {
			System.out.println(div.getAttribute("id"));
		}
		
		// find the out-most ancestor
		WebElement divOuter =
			driver.findElement(By.xpath("//p[@id='bye']/ancestor::div"));
		
		assertEquals("outer", divOuter.getAttribute("id"));
		
		// find the parent
		WebElement divInner = 
			driver.findElement(By.xpath("//p[@id='bye']/ancestor::div[1]"));
		
		assertEquals("inner", divInner.getAttribute("id"));
		
		WebElement divParent = 
			driver.findElement(By.xpath("//p[@id='bye']/parent::*"));
			
		assertEquals("inner", divParent.getAttribute("id"));		
		
		WebElement divClass = 
			driver.findElement(By.xpath("//p[@id='bye']/ancestor::div[contains(@class, 'a-row')]"));
		
		assertEquals("div", divClass.getAttribute("id"));
	}
	
	@Test
	public void testFindSiblings() {
		driver.get("http://azhang1/workspace/xpath.html");
		
		// //*[@id='row'] element with id 'row'
		// /following-sibling::tr[2] 2nd following sibling
		// /child::td[3] 3rd child
		WebElement quantity = 
			driver.findElement(By.xpath("//*[@id='row']/following-sibling::tr[2]/child::td[3]"));
		
		assertEquals("35", quantity.getText());
		
		// //table[@id='tbl'] find table with id 'tbl'
		// //td[text()='$45'] inside table, find td with text $45
		// /preceding-sibling::td previous td cell
		WebElement product = 
			driver.findElement(By.xpath("//table[@id='tbl']//td[text()='$45']/preceding-sibling::td"));
		
		assertEquals("DVDs", product.getText());
	}
}
