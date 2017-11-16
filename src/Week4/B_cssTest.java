package Week4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class B_cssTest {
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
	public void testH1Style() {
		driver.get("http://azhang1/workspace/css.html");
		WebElement h1 = 
			driver.findElement(By.tagName("h1"));
		System.out.println(h1.getCssValue("color"));
		System.out.println(h1.getCssValue("background-color"));
		System.out.println(h1.getCssValue("text-align"));
		System.out.println(h1.getCssValue("font"));
		System.out.println(h1.getCssValue("font-family"));
	}
	
	@Test
	public void testH2Style() {
		driver.get("http://azhang1/workspace/css.html");
		WebElement h2 = 
			driver.findElement(By.tagName("h2"));
		System.out.println(h2.getCssValue("border"));
		System.out.println(h2.getCssValue("border-width"));
		System.out.println(h2.getCssValue("border-top-width"));
		System.out.println(h2.getCssValue("border-top-style"));
	}
}
