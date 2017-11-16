package Week3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputDemo {

	public static void main(String[] args) {
		System.setProperty(
				"webdriver.chrome.driver", 
				"./drivers/chromedriver.exe"
			);
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://azhang1/workspace/input.html");
		
		WebElement name = 
			driver.findElement(By.id("name"));
		WebElement password = 
			driver.findElement(By.id("password"));
		
		name.clear();
		name.sendKeys("John");
		password.clear();
		password.sendKeys("secret");
	}

}
