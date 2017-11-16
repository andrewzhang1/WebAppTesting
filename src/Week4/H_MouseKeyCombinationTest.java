package Week4;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class H_MouseKeyCombinationTest {
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
	public void testCtrlClick() {
		driver.get("http://azhang1/workspace/longselect.html");
		List<WebElement> options = 
			driver.findElements(By.xpath("(//select)[1]/option"));
		Actions builder = new Actions(driver);
		
		builder.click(options.get(1))
			.keyDown(Keys.CONTROL)
			.click(options.get(5))
			.click(options.get(3))
			.click(options.get(4))
			.click(options.get(5))
			.keyUp(Keys.CONTROL)
			.perform();
		
		String[] expected = {"row 2", "row 4", "row 5"};
		
		List<String> actual = new ArrayList();
		
		// first approach
//		for (WebElement option:options) {
//			if (option.isSelected()) {
//				actual.add(option.getText());
//			}
//		}
		
		// second approach
		Select select = 
			new Select(driver.findElement(By.tagName("select")));
		for (WebElement option: select.getAllSelectedOptions()) {
			actual.add(option.getText());
		}
		assertArrayEquals(expected, actual.toArray());
	}
}
