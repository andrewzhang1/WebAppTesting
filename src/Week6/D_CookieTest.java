package Week6;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D_CookieTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		testCookie(driver);
		
		// See the video for the AddCookie test
		//testAddCookie(driver);
	}
	
	static void testAddCookie(WebDriver driver) {
		driver.get("http://azhang1/workspace/helloworld.html");
		Cookie userCookie = new Cookie("user", "JohnSmith", "azhang1", "/", null);
		driver.manage().addCookie(userCookie);
		driver.get("http://azhang1/workspace/cookie.php");
	}
	
	static void testCookie(WebDriver driver) throws InterruptedException {
		driver.get("http://azhang1/workspace/cookie.php");
		
		// I am in the cookie.php page
		// I have received the set-cookie header
		// The cookies are already in my cookie jar.
		Set<Cookie> cookies = driver.manage().getCookies();
		
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + ": " + cookie.getValue());
			System.out.println(cookie.getExpiry());
			System.out.println(cookie.getDomain());
			System.out.println(cookie.getPath());
		}
		
		Thread.sleep(5000);
		
		driver.get("http://azhang1/workspace/cookie.php");
		
	}
}
