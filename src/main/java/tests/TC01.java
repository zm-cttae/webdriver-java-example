package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import driverutilities.DriverUtilities;
import pageobjects.ContactPage;
import pageobjects.HomePage;
import testdata.TC01Data;
import testdata.TC03Data;
import usefulmethods.Screenshot;

public class TC01 {

	WebDriver driver;

	@Before public void preConditions() {
		DriverUtilities myDriverUtilities = new DriverUtilities();

		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(TC03Data.FDMUrl);
		HomePage.denyCookiesButton(driver).click();
	}

	@Test public void incorrectDetails() throws IOException {

		HomePage.contactLink(driver).click();
		Assert.assertEquals(driver.getCurrentUrl(), TC01Data.contactPageUrl);
		Assert.assertEquals(ContactPage.heading(driver).getText(), TC01Data.contactPageHeading);

		Select departmentField = new Select(ContactPage.departmentDropDownList(driver));
		departmentField.selectByVisibleText(TC01Data.itDepartment);
		Screenshot.takeScreenshot(driver, "departmentShot");

		ContactPage.firstNameField(driver).sendKeys(TC01Data.firstName);
		Assert.assertEquals(ContactPage.firstNameField(driver).getAttribute("value"), TC01Data.firstName);

		ContactPage.emailAddressField(driver).sendKeys(TC01Data.emailAddress);
		Assert.assertEquals(ContactPage.emailAddressField(driver).getAttribute("value"), TC01Data.emailAddress);

		ContactPage.phoneNumberField(driver).sendKeys(TC01Data.phoneNumber);
		Assert.assertEquals(ContactPage.phoneNumberField(driver).getAttribute("value"), TC01Data.phoneNumber);

		ContactPage.messageField(driver).sendKeys(TC01Data.message);
		Assert.assertEquals(ContactPage.messageField(driver).getAttribute("value"), TC01Data.message);

		ContactPage.submitButton(driver).submit();
		Assert.assertEquals(driver.getCurrentUrl(), TC01Data.contactPageUrl);
		Assert.assertTrue(ContactPage.lastNameError(driver).isDisplayed());
		Assert.assertEquals(ContactPage.lastNameError(driver).getText(), TC01Data.lastNameError);
		Screenshot.takeScreenshot(driver, "lastNameErrorPosition");

	}

	@After public void tearDown() {
		driver.quit();
	}

}
