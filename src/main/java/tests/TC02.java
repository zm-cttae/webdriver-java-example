package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import driverutilities.DriverUtilities;
import pageobjects.Footer;
import pageobjects.HomePage;
import testdata.TC02Data;

public class TC02 {

	WebDriver driver;

	@Before public void preConditions() {
		DriverUtilities myDriverUtilities = new DriverUtilities();

		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(TC02Data.FDMUrl);
		HomePage.denyCookiesButton(driver).click();
	}

	@Test public void socialMediaButtons() throws InterruptedException {

		HomePage.cultureLink(driver).click();
		assertSocialMediaButtonsDisplayed(TC02Data.culturePageUrl);
		driver.navigate().back();

		HomePage.ourWorkLink(driver).click();
		assertSocialMediaButtonsDisplayed(TC02Data.ourWorkPageUrl);
		driver.navigate().back();

		HomePage.servicesLink(driver).click();
		assertSocialMediaButtonsDisplayed(TC02Data.servicesPageUrl);
		driver.navigate().back();

		HomePage.careersLink(driver).click();
		assertSocialMediaButtonsDisplayed(TC02Data.careersPageUrl);
		driver.navigate().back();

		HomePage.investorsLink(driver).click();
		assertSocialMediaButtonsDisplayed(TC02Data.investorsPageUrl);
		driver.navigate().back();

		HomePage.contactLink(driver).click();
		assertSocialMediaButtonsDisplayed(TC02Data.contactPageUrl);
		driver.navigate().back();

	}

	private void assertSocialMediaButtonsDisplayed(String url) throws AssertionError {
		Assert.assertEquals(driver.getCurrentUrl(), url);
		Assert.assertEquals(Footer.socialMediaButtonListItems(driver).size(), 5);
		Assert.assertTrue(Footer.ytListItem(driver).isDisplayed());
		Assert.assertTrue(Footer.twitterListItem(driver).isDisplayed());
		Assert.assertTrue(Footer.inListItem(driver).isDisplayed());
		Assert.assertTrue(Footer.instaListItem(driver).isDisplayed());
	}

	@After public void tearDown() {
		driver.quit();
	}

}
