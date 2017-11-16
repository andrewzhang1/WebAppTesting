package Week5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class F_AmazonAutoSuggestDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(
				"webdriver.chrome.driver", 
				"./drivers/chromedriver.exe"
			);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");

		WebElement searchBox = 
			driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.clear();
		searchBox.sendKeys("selenium webdriver");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("nav-flyout-searchAjax"))
		);
		
		searchBox.sendKeys(Keys.ARROW_DOWN);
		searchBox.sendKeys(Keys.ARROW_DOWN);
		searchBox.sendKeys(Keys.ARROW_DOWN);
		searchBox.sendKeys(Keys.ARROW_DOWN);
		
		
		searchBox.sendKeys(Keys.ENTER);
	}

}
