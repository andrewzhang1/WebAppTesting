/*
 * UCSC Extension - Web Testing Tools Assignment 1
 * 
 * 1. Use Selenium to - Go to http://www.amazon.com/;
 * 2. Search “Java introduction” using the search box in the home page;
 * 3. In the result page, print out the number of books listed in the first result page
 *    and the book title and its first paperback price for each listed book. 
 *    Note: 1) The paperback price is optional with bonus points.
 *          2) Make sure that you print out the first price immediately below the “Paperback”
 *             text, as shown below.
 * 
 *  Instructor: Min Wu
 *  Student:    Andrew Zhang
 *  
 *  Date: 11/5/2017
 */

package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTestAssignment1 {

	public static void main(String[] args) {

		// Set chrome web driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");
		
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
		input.clear();
		input.sendKeys("Java introduction");
		WebElement searchIcon = driver.findElement(By.cssSelector("#nav-search input[type='submit']"));
		searchIcon.click();
		
		// define a array list
		List<WebElement> bookItem = driver.findElements(By.cssSelector("#s-results-list-atf > li"));
		
		System.out.println("\nNumber of Books Listed in This Page: ");
		System.out.println("========================================");

		System.out.println(bookItem.size());
		
		for (WebElement elem : bookItem) {
			System.out.println();
			WebElement title = elem.findElement(By.tagName("h2"));
			System.out.println(title.getAttribute("innerText"));
			try {
				WebElement priceRow = elem.findElement(By.xpath(".//h3[text()='Paperback']/../../following-sibling::div[1]"));
				
				try {
					WebElement price = priceRow.findElement(By.cssSelector(".sx-price"));
					List<WebElement> parts = price.findElements(By.xpath("./*"));
					System.out.println(parts.get(0).getText() + parts.get(1).getText() + "." + parts.get(2).getText());

					continue;
				} catch (NoSuchElementException e) {}
				
				try {
					WebElement price = priceRow.findElement(By.cssSelector(".a-size-base"));
					System.out.println(price.getText());
					continue;
				} catch (NoSuchElementException e) {}
				
			} catch (NoSuchElementException e) {}
			System.out.println("\nNo Paperback Price Found!");
		}		
	}
}

/*
Output:

	Number of Books Listed in This Page: 
		========================================
		20

		[Sponsored]Do-It-Yourself Java Games: An Introduction to Java Computer Programming

		No Paperback Price Found!

		Java: An Introduction to Problem Solving and Programming (7th Edition)
		$25.17

		Java: An Introduction to Problem Solving and Programming (8th Edition)
		$63.00

		Java: An Introduction to Problem Solving and Programming Plus MyProgrammingLab with Pearson eText -- Access Card Package (8th Edition)
		$157.00

		Java: Introduction to Problem Solving and Programming (5th Edition)
		$12.69

		Java: An Introduction to Problem Solving and Programming (6th Edition)
		$16.40

		Java: Introduction to Problem Solving and Programming & MyProgrammingLab with Pearson eText Student Access Code Card for Java (6th Edition) 6th (sixth) Edition by Savitch, Walter published by Addison-Wesley (2011)
		$29.29

		Introduction to Java Programming (Introduction to Programming)
		$11.99

		Introduction to Java Programming and Data Structures, Comprehensive Version (11th Edition)
		$66.51

		Learn Java the Easy Way: A Hands-On Introduction to Programming
		$24.54

		Objects First with Java: A Practical Introduction Using BlueJ (6th Edition)
		$47.68

		Java Foundations: Introduction to Program Design and Data Structures (4th Edition)
		$47.92

		Java: An Introduction to Computer Science & Programming (2nd Edition)
		$27.94

		Introduction to Computing and Programming with Java: A Multimedia Approach
		$24.92

		Introduction to Programming with Java: A Problem Solving Approach
		$25.84

		Introduction to Java Programming, Comprehensive Version (9th Edition)
		$37.74

		Introduction to Programming with Greenfoot: Object-Oriented Programming in Java with Games and Simulations (2nd Edition)
		$27.61

		[Sponsored]Programming: Computer Programming for Beginners: Learn the Basics of Java, SQL & C++ (2017)

		No Paperback Price Found!

		[Sponsored]Java: The Ultimate Beginners Guide to Java Programming

		No Paperback Price Found!

		[Sponsored]Hacking: Computer Hacking Beginners Guide How to Hack Wireless Network, Basic Security and Penetration Testing, Kali Linux, Your First Hack

		No Paperback Price Found!

		
	*/