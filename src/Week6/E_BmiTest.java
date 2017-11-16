package Week6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E_BmiTest {
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
	public void testUnderWeight() {
		driver.get("http://azhang1/workspace/bmicalculator.html");
		
		WebElement heightField = 
			driver.findElement(By.id("heightCMS"));
		WebElement weightField = 
			driver.findElement(By.id("weightKg"));
		WebElement btn = 
			driver.findElement(By.id("Calculate"));
		WebElement bmiValue = 
			driver.findElement(By.id("bmi"));
		WebElement bmiCategory =
			driver.findElement(By.id("bmi_category"));
		
		heightField.clear();
		heightField.sendKeys("160");
		weightField.clear();
		weightField.sendKeys("45");
		btn.click();
		assertEquals("17.6", bmiValue.getAttribute("value"));
		assertEquals("Underweight", bmiCategory.getAttribute("value"));
	}
	
	@Test
	public void testNormal() {
		driver.get("http://azhang1/workspace/bmicalculator.html");
		
		WebElement heightField = 
			driver.findElement(By.id("heightCMS"));
		WebElement weightField = 
			driver.findElement(By.id("weightKg"));
		WebElement btn = 
			driver.findElement(By.id("Calculate"));
		WebElement bmiValue = 
			driver.findElement(By.id("bmi"));
		WebElement bmiCategory =
			driver.findElement(By.id("bmi_category"));
		
		heightField.clear();
		heightField.sendKeys("168");
		weightField.clear();
		weightField.sendKeys("70");
		btn.click();
		assertEquals("24.8", bmiValue.getAttribute("value"));
		assertEquals("Normal", bmiCategory.getAttribute("value"));
	}	
}
