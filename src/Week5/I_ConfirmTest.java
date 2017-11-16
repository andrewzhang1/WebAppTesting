package Week5;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class I_ConfirmTest {
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
	public void testAccept() {
		driver.get("http://azhang1/workspace/confirm.html");
		
		WebElement btn = 
			driver.findElement(By.cssSelector("[value='Leave this page']"));
		btn.click();

		WebDriverWait wait = 
			new WebDriverWait(driver, 10);
			
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String url = driver.getCurrentUrl();
		//System.out.println(url);
		
		try {
			String host = new URI(url).getHost();
			assertEquals("www.google.com", host);
		} catch (URISyntaxException e) {
			fail("bad url string");
		}
	}
	
	@Test
	public void testDismiss() {
		driver.get("http:/azhang1/workspace/confirm.html");
		
		WebElement btn = 
			driver.findElement(By.cssSelector("[value='Leave this page']"));
		btn.click();

		WebDriverWait wait = 
			new WebDriverWait(driver, 10);
			
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		WebElement message =
			driver.findElement(By.tagName("p"));
		assertEquals("Thank you!", message.getText());
	}
}
