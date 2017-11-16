package Week6;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_FrameTest {
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
	public void testLeftFrame() {
		driver.get("http://azhang1/workspace/frames.html");
		driver.switchTo().frame("left");
		
		// I am in left-side HTML code.
		WebElement square = 
			driver.findElement(By.id("square"));
		assertEquals("rgba(255, 0, 0, 1)",
			square.getCssValue("background-color"));
	}
	
	@Test
	public void testMiddleFrame() {
		driver.get("http://azhang1/workspace/frames.html");
		driver.switchTo().frame(1);
		
		// I am in middle HTML code.
		WebElement title = 
			driver.findElement(By.tagName("h1"));
		assertEquals("Hello World",
			title.getText());
		
	}
	
	@Test
	public void testRightFrame() {
		driver.get("http://azhang1/workspace/frames.html");
		WebElement rightFrame = 
			driver.findElement(By.cssSelector("frame[src$='form.html']"));
		
		driver.switchTo().frame(rightFrame);
		
		// I am in right-side HTML code.
		WebElement input = 
			driver.findElement(By.id("name"));
		input.clear();
		input.sendKeys("John");
		input.submit();
		
		WebElement message = 
			driver.findElement(By.tagName("p"));		
		assertEquals("Hello John",
			message.getText());
		
	}
	
	@Test
	public void testAllFrames() {
		List<WebElement> frames =
			driver.findElements(By.tagName("frame"));
		
		int index = 0;
		
		for (WebElement frame : frames) {
			driver.switchTo().frame(frame);
			
			// I am inside a specific frame
			// test this frame
			
			switch(index) {
				case 0:
					WebElement square = 
						driver.findElement(By.id("square"));
					assertEquals("rgba(255, 0, 0, 1)",
						square.getCssValue("background-color"));					
				case 1:
					WebElement title = 
						driver.findElement(By.tagName("h1"));
					assertEquals("Hello World",
						title.getText());			
				case 2:
					WebElement input = 
						driver.findElement(By.id("name"));
					input.clear();
					input.sendKeys("John");
					input.submit();
					
					WebElement message = 
						driver.findElement(By.tagName("p"));		
					assertEquals("Hello John",
						message.getText());					
				default:
					fail("invalid frame");
			}
			
			index++;
			// After each iteration, I have to switch back
			// to the main page
			driver.switchTo().defaultContent();
		}
	}
}
