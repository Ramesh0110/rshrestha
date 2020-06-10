package com.learning.selenium;

import static org.testng.Assert.assertEquals;
//assert.* gives all imports

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MortgageCalculaorTests {

	public WebDriver driver;

	@BeforeMethod // this method will run before every single test method public
	void set_up() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver(); // opens Chrome browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // driver.manage().window().maximize(); //
																			// maximize browser window
	}

	@AfterMethod // this method will run after every single test method public
	void tearDown() {
		try {
			Thread.sleep(30 * 1000);
			driver.close(); // closing the browser
			if (driver != null) {
				driver.quit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void buyAHomeTest() throws Exception {
		driver.get("http://mortgagecalculator.net/");

		String pageTitleTxt = driver.getTitle();
		System.out.println("Page Title:" + pageTitleTxt);
		String expectedTitleTxt = "Mortgage Calculator 2020 - FREE Calculator Tool (ZERO Ads)";
		assertEquals(pageTitleTxt, expectedTitleTxt); // TestinG assertion to match actual vs expected selenium actual
														// is selenium gives
		// locating currency dropdown
		WebElement currencyElement = driver.findElement(By.id("currency"));// default cvalue of currencyElement is zero
		Select currencyDropDown = new Select(currencyElement);
		currencyDropDown.selectByIndex(1);

		Thread.sleep(1 * 1000);
		System.out.println("Step2: Selecting dropdown Dollar icon.");
		currencyDropDown.selectByValue("dollar");

		// locating mortgage amount text filed element
		WebElement amountElement = driver.findElement(By.name("amount"));
		amountElement.clear();// clean the existing text from the text field
		amountElement.sendKeys("450000");

		// locating interest rate using cssselector

		WebElement intRate = driver.findElement(By.cssSelector("#rate"));
		intRate.clear();
		intRate.sendKeys("3.8");

		// locating interest year
		WebElement yearElem = driver.findElement(By.xpath("//*[@id='amortizationYears']"));// eclipse automaticcally
																							// //*[@id="amortizationYears"]
		// or we can replace "" to '' quotation before pasting xpath

		yearElem.clear();
		yearElem.sendKeys("25");

		// locating interest type
		WebElement intType = driver.findElement(By.id("interestType"));
		Select intTypeDropDown = new Select(intType);
		intTypeDropDown.selectByVisibleText("Fixed");

		// clicking on calculate now
		WebElement button = driver.findElement(By.cssSelector("#button"));

		button.click();

	}
}
