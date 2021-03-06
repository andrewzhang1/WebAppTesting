package Week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author student
 *
 */
public class WebAutomationDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty(
			"webdriver.chrome.driver", 
			"./drivers/chromedriver.exe"
		);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");
		
		// I am in amazon page now!
		
		WebElement input = 
			driver.findElement(By.id("twotabsearchtextbox"));
		input.sendKeys("selenium webdriver");
		input.submit();
//		WebElement searchIcon =
//			driver.findElement(
//				By.xpath(
//					"//*[@id=\"nav-search\"]/form/div[2]/div/input"
//				));
//		searchIcon.click();
		
		// I am already in the result page
		WebElement status = 
			driver.findElement(By.id("s-result-count"));
		System.out.println(status.getText());
		
		driver.quit();
	}

}
