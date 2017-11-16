package Week4;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class I_DragTest {
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
		//driver.quit();	
	}
	
	@Test
	public void testDrag() {
		driver.get("http://www.dhtmlgoodies.com/scripts/dg-crop/dg-crop.html");
		WebElement move = 
			driver.findElement(By.className("dg-crop"));
		
		assertEquals("absolute", move.getCssValue("position"));
		assertEquals("66px", move.getCssValue("top"));
		assertEquals("66px", move.getCssValue("left"));
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(move)
			.moveByOffset(100, 50)
			.release()
			.perform();

		assertEquals("116px", move.getCssValue("top"));
		assertEquals("166px", move.getCssValue("left"));		
	}
}
