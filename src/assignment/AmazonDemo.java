package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
		input.clear();
		input.sendKeys("Selenium WebDriver");
		input.submit();
		
		// the result page
		List<WebElement> entries = 
			driver.findElements(By.cssSelector("#s-results-list-atf > li"));
		
		for (WebElement entry: entries) {
			WebElement title = entry.findElement(By.tagName("h2"));
			System.out.println(title.getText());
			
			try {
				WebElement paperBackH3 = entry.findElement(By.cssSelector("[data-attribute='Paperback']"));
				WebElement paperBackPrice = paperBackH3.findElement(By.xpath("./ancestor::div/following-sibling::div//span[starts-with(@class, 'sx-price')]"));
				System.out.println(paperBackPrice.getText());
			} catch (NoSuchElementException e) {
				System.out.println("No paperback price");
			}
		}
	}
}
