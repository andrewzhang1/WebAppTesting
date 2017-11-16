package Week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAutomationDemo {

	public static void main(String[] args) {

		System.setProperty(
				"webdriver.chrome.driver",
				"./drivers/chromedriver.exe"
				);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		
		// I'm in amazon page now!
		
		WebElement input =
				driver.findElement(By.id("twotabsearchtextbox"));
		input.sendKeys("selenium webdriver");
		
		WebElement searchIcon =
				driver.findElement(
				By.xpath(
						"//*[@id=\"nav-search\"]/form/div[2]/div/input"
						));
						
		searchIcon.click();
				
		WebElement status = 
				driver.findElement(By.id("s-result-count"));
		System.out.println(status.getText());	
				
	 // driver.quit();	

	}

}
