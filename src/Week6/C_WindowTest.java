package Week6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_WindowTest {
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
	public void testWindowByName() {
		driver.get("http://azhang1/workspace/childwindow.html");
		
		System.out.println(driver.getWindowHandle());
		
		WebElement btn1 = driver.findElement(By.id("btn1"));
		WebElement btn2 = driver.findElement(By.id("btn2"));
		WebElement btn3 = driver.findElement(By.id("btn3"));
		
		btn1.click();
		btn2.click();
		btn3.click();
		
		driver.switchTo().window("HelpWindow");
		assertEquals("Q & A",
			driver.findElement(By.tagName("h1")).getText());
	}
	
	@Test
	public void testWindowByUrl() {
		driver.get("http://azhang1/workspace/childwindow.html");
		
		WebElement btn1 = driver.findElement(By.id("btn1"));
		WebElement btn2 = driver.findElement(By.id("btn2"));
		WebElement btn3 = driver.findElement(By.id("btn3"));
		
		btn1.click();
		btn2.click();
		btn3.click();
		
		boolean tested = false;
		
		for (String windowId: driver.getWindowHandles()) {
			driver.switchTo().window(windowId);
			String url = driver.getCurrentUrl();
			System.out.println(url);
			System.out.println(windowId);
			
			if (url.endsWith("form.html")) {
				WebElement input = 
						driver.findElement(By.id("name"));
					input.clear();
					input.sendKeys("John");
					input.submit();
					
					WebElement message = 
						driver.findElement(By.tagName("p"));		
					assertEquals("Hello John",
						message.getText());
				
					tested = true;
			}
		}
		
		assertTrue(tested);
	}
}
