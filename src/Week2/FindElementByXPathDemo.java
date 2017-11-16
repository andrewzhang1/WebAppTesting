package Week2;

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
import org.openqa.selenium.NoSuchElementException;

public class FindElementByXPathDemo {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().fullscreen(); //--? This is for Mac!

	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testFindFirstUL(){
		driver.get("http://azhang1/workspace/links.html");
		WebElement ul =
				driver.findElement(By.xpath("//ul"));
		assertEquals(
				"list1",
				ul.getAttribute("id"));
	}

	@Test(expected = NoSuchElementException.class)
	public void testFindFirstUlWrongWay() {
		driver.get("http://azhang1/workspace/links.html");
		WebElement ul =
			driver.findElement(By.xpath("/ul"));
	}	
	
	@Test
	public void testFindLis() {
		driver.get("http://azhang1/workspace/links.html");
		List<WebElement> lis = 
			driver.findElements(By.xpath("//li"));
		assertEquals(
				8,
				lis.size()
		);
		
		// all <li>s who are the immediate children of <ul>
		lis = 
				driver.findElements(By.xpath("//ul/li"));
			assertEquals(
					4,
					lis.size()
			);	
		
		// all <li>s who are the descendents of <ul>
		lis = 
				driver.findElements(By.xpath("//ul//li"));
			assertEquals(
					5,
					lis.size()
			);	
					
	}
	
	@Test
	public void testFindElementInElement() {
		driver.get("http://azhang1/workspace/divs.html");
		WebElement id1 =
			driver.findElement(By.id("id1"));
		// the immediate child <p> of id1
		WebElement p1 = 
			id1.findElement(By.xpath("./p"));
		// the descendent <p> of id1
		WebElement p2 = 
			id1.findElement(By.xpath(".//p"));
		// the first <p> in the web page
		WebElement p3 = 
			id1.findElement(By.xpath("//p"));
		
		assertEquals(
			"World", p1.getText()
		);
		assertEquals(
			"World", p2.getText()
		);
		assertEquals(
			"Hello", p3.getText()
		);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testFindElementInElementWrongWay() {
		driver.get("http://azhang/workspace/divs.html");
		WebElement id1 =
			driver.findElement(By.id("id1"));
		// the first root element <p>
		WebElement p1 = 
			id1.findElement(By.xpath("/p"));		
	}
	
	@Test
	public void testFindThirdElements() {
		driver.get("http://azhang/workspace/xpath.html");
		// find all <li>'s who are the 3rd child of their parent
		List<WebElement> thirdLis =
			driver.findElements(By.xpath("//li[3]"));
		
		String[] expected = {
			"3", "Google site", "Ruby", "Chinese"
		};
		
		
		List<String> actual = new ArrayList();
		for (WebElement li : thirdLis) {
			actual.add(li.getText());
			System.out.println(li.getText());
		}
		
		assertArrayEquals(expected, actual.toArray());
		
		// single global third <li>
		List<WebElement> globalThirdLi = 
			driver.findElements(By.xpath("(//li)[3]"));
		
		//assertEquals(1, globalThirdLi.size());
		//assertEquals("3", globalThirdLi.get(0).getText());
	}
}
