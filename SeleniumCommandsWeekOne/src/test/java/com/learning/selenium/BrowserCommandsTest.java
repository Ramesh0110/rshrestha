package com.learning.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //never type urself
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserCommandsTest {
	public WebDriver driver;

	@BeforeMethod
	public void set_up() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();// open Chrome browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// wait
																		// time
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// maximum
																			// wait
																			// time
		//driver.manage().window().maximize(); // maximize
		//driver.manage().window().maximize(); // maximize
		//driver.manage().window().maximize(); // maximize
		//driver.manage().window().maximize(); // maximize
	}

	@AfterMethod // run after every single test method
	public void tearDown() {
		driver.close(); // closing the browser
		if (driver != null) 
			driver.quit();
		
	}

	@Test(enabled = true, priority = 1)
	public void findAllLinks() {
		driver.get("http://www.amazon.com/");
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		int totalNumber = totalLinks.size();
		System.out.println("Total Number of links:" + totalNumber);
		
		int counter=1;// counter don't put inside the loop
		
		for(WebElement link : totalLinks) { // Enhance for loop link for single link(webelement)
			String linkTxt =link.getText();
			System.out.println(counter+ ": [" + linkTxt+ "]");
			//counter++;
			counter=counter+1; // read from right side
			
		}
	}

	@Test(enabled = false, priority = 2)
	public void findAllButtons() {
		driver.get("http://www.walmart.com/");
	}

	@Test(enabled = false)
	public void firstTest() {
		try {
			driver.get("http://www.google.com/");// navigate
			Thread.sleep(5 * 1000);// wait for 5 second
			driver.navigate().to("http://www.costco.com/");
			Thread.sleep(5 * 1000);
			driver.navigate().refresh();// reload or refresh the current page
			Thread.sleep(5 * 1000);// pause
			driver.navigate().back();// navigate to previous page
			Thread.sleep(5 * 1000);
			driver.navigate().forward();// navigate to previous webpage visited
			Thread.sleep(5 * 1000);
			driver.close(); // closing the browser
			// if (driver != null) {
			// driver.quit(); // checking the statue
			// }
			// taskkill/im chromedriver.exe/f
		} catch (Exception e) {// original class subject
			e.printStackTrace();// default method
		}
	}
}

/*
 * package com.learning.selenium;
 * 
 * import java.util.List; import java.util.concurrent.TimeUnit;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver;// never
 * type import, eclipse automatically gives import library which referencies
 * code import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.testng.annotations.AfterMethod; import
 * org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;
 * 
 * public class BrowserCommandsTest { public WebDriver driver; // driver is name
 * or object, driver is common word \
 * 
 * @BeforeMethod // this method will run before every single test method public
 * void set_up() { System.setProperty("webdriver.chrome.driver",
 * "src/test/resources/chromedriver.exe"); // remove backslash\\// and // put
 * single line // forward slash /
 * 
 * WebDriver driver = new ChromeDriver(); // opens the Chrome browser
 * 
 * driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);// try to
 * automatically synchronize the page
 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// to
 * complete pageload driver.manage().window().maximize(); // maximize browser
 * window
 * 
 * }
 * 
 * @AfterMethod // this method will run after every single test method public
 * void tearDown() { driver.close();// closing browser, its not gonna kill the
 * program.
 * 
 * if (driver!=null) { // check if the driver is live or not, if condition meet
 * then driver.quit(); // this will kill the driver from computer memory, from
 * task manager }
 * 
 * }
 * 
 * @Test (enabled=true, priority=1) public void findAllLinks() {
 * driver.get("https://www.walmart.com/"); List<WebElement>
 * totalLinks=driver.findElements(By.tagName("a")); int
 * totalNumber=totalLinks.size(); System.out.println("Total Number of links :"
 * +totalNumber); }
 * 
 * @Test (enabled=false, priority=2) public void findAllButtons() {
 * driver.get("http://www.walmart.com/");
 * 
 * }
 * 
 * 
 * @Test (enabled=false)// @ testNG annotation --> import testNG from list
 * public void firstTest() { try {
 * 
 * driver.get(" http://www.google.com/"); // navigate url of google.com--> one
 * forward slash at the end Thread.sleep(5 * 1000);
 * 
 * driver.navigate().to("http://www.costco.com/ "); Thread.sleep(5 * 1000);
 * 
 * driver.navigate().refresh();// reload and refresh the current page
 * Thread.sleep(5 * 1000);
 * 
 * driver.navigate().back(); // navigate to previos page or site Thread.sleep(5
 * * 1000);
 * 
 * driver.navigate().forward();// navigate to previous webpage that we visited
 * Thread.sleep(5 * 1000);
 * 
 * 
 * } catch (Exception e) { // Exception is the original class object, Exception
 * should be inside try catch // block e.printStackTrace(); // default method
 * from Exception, it trace the code }
 * 
 * }
 * 
 * }
 */