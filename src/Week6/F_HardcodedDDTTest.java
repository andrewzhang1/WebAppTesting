package Week6;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class F_HardcodedDDTTest {
	
	private String height;
	private String weight;
	private String bmi;
	private String bmiCategory;

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
	
	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new String[][] {
			{"160", "45", "17.6", "Underweight"},
			{"168", "70", "24.8", "Normal"},
			{"181", "89", "27.2", "Overweight"},
			{"178", "100", "31.6", "Obesity"}
		});
	}
	
	public F_HardcodedDDTTest(
		String height,
		String weight,
		String bmi,
		String bmiCategory
	) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.bmiCategory = bmiCategory;
	}
	
	@Test
	public void testBmi() {
		driver.get("http://localhost/workspace/bmicalculator.html");
		
		WebElement heightField = 
			driver.findElement(By.id("heightCMS"));
		WebElement weightField = 
			driver.findElement(By.id("weightKg"));
		WebElement btn = 
			driver.findElement(By.id("Calculate"));
		WebElement bmiValueField = 
			driver.findElement(By.id("bmi"));
		WebElement bmiCategoryField =
			driver.findElement(By.id("bmi_category"));
		
		heightField.clear();
		heightField.sendKeys(height);
		weightField.clear();
		weightField.sendKeys(weight);
		btn.click();
		assertEquals(bmi, bmiValueField.getAttribute("value"));
		assertEquals(bmiCategory, bmiCategoryField.getAttribute("value"));		
	}
}
