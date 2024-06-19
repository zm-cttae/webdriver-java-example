package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverutilities.DriverUtilities;
import pageobjects.HomePage;
import testdata.TC02Data;

public class Day3Exercise {

	WebDriver driver;

	@Before public void preConditions() {
		DriverUtilities myDriverUtilities = new DriverUtilities();

		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(TC02Data.careersPageUrl);
		HomePage.denyCookiesButton(driver).click();
	}

	@Test public void xpathPractice() throws InterruptedException {

		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'Zain')]")).isDisplayed());
		driver.findElement(By.xpath("//img[starts-with(@alt,'Zain')]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Our People']")).isDisplayed());

	}

	@After public void tearDown() {
		driver.quit();
	}

}
