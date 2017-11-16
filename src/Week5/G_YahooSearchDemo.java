package Week5;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class G_YahooSearchDemo {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.yahoo.com/");

		WebElement search = driver.findElement(By.id("uh-search-box"));
		search.clear();
		search.sendKeys("QA jobs in bay area");
		search.submit();

		File srcFile = 
			((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("./screenshots/yahoo-1.png"));
		
		driver.navigate().back();
		
		search = driver.findElement(By.id("uh-search-box"));
		search.clear();
		search.sendKeys("QA jobs in NYC");
		search.submit();

		srcFile = 
			((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("./screenshots/yahoo-2.png"));	
		
		driver.quit();
	}

}
