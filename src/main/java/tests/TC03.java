package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverutilities.DriverUtilities;
import pageobjects.HomePage;
import pageobjects.OurWorkUniversitiesPage;
import testdata.TC03Data;

public class TC03 {

	WebDriver driver;
	Actions actions;
	WebDriverWait slideWait;

	@Before public void preConditions() {
		DriverUtilities myDriverUtilities = new DriverUtilities();

		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		actions = new Actions(driver);
		slideWait = new WebDriverWait(driver, 15);

		driver.get(TC03Data.FDMUrl);
		HomePage.denyCookiesButton(driver).click();
	}

	@Test public void universitiesPage() throws InterruptedException, IOException {

		actions.moveToElement(HomePage.ourWorkLink(driver)).perform();
		Assert.assertTrue(HomePage.universitiesLink(driver).isDisplayed());

		HomePage.universitiesLink(driver).click();
		Assert.assertEquals(driver.getCurrentUrl(), TC03Data.universitiesPageUrl);
		WebElement partnershipsParagraph = OurWorkUniversitiesPage.partnershipsParagraph(driver);
		Assert.assertTrue(partnershipsParagraph.getText().contains(" 90 partnerships "));
		WebElement universitySlideDiv = OurWorkUniversitiesPage.universitySlideDiv(driver);
		slideWait.until(ExpectedConditions.attributeContains(universitySlideDiv, "tabindex", "0"));
		Assert.assertTrue(universitySlideDiv.getText().contains(" 480+ universities"));

		slideWait.until(ExpectedConditions.attributeContains(universitySlideDiv, "tabindex", "0"));
		actions.moveToElement(OurWorkUniversitiesPage.recruitmentLeftButton(driver));
		OurWorkUniversitiesPage.recruitmentLeftButton(driver).click();
		WebElement worldwideClientsSlideDiv = OurWorkUniversitiesPage.worldwideClientsSlideDiv(driver);
		slideWait.until(ExpectedConditions.attributeContains(worldwideClientsSlideDiv, "tabindex", "0"));
		Assert.assertTrue(worldwideClientsSlideDiv.getText().contains(" 200+ high profile clients "));

		WebElement scrollButton = OurWorkUniversitiesPage.scrollButton(driver);
		WebElement brochureLink = OurWorkUniversitiesPage.brochureLink(driver);
		scrollButton.click();
		slideWait.until(ExpectedConditions.invisibilityOf(scrollButton));
		brochureLink.click();
		slideWait.until(ExpectedConditions.stalenessOf(brochureLink));
		Assert.assertEquals(driver.getCurrentUrl(), TC03Data.brochureUploadUrl);

		driver.navigate().back();
		Assert.assertEquals(driver.getCurrentUrl(), TC03Data.universitiesPageUrl);

		OurWorkUniversitiesPage.locationSelectorLink(driver).click();
		WebElement locationSelectorUl = OurWorkUniversitiesPage.locationSelectorUl(driver);
		Assert.assertTrue(locationSelectorUl.isDisplayed());
		WebElement locationSelectorLanguageLink = OurWorkUniversitiesPage.locationSelectorLanguageLink(driver, TC03Data.germanLanguageLinkText);
		Assert.assertTrue(locationSelectorLanguageLink.isDisplayed());
		String languageUniversitiesPageUrl = locationSelectorLanguageLink.getAttribute("href");
		locationSelectorLanguageLink.click();
		Assert.assertNotEquals(driver.getCurrentUrl(), TC03Data.universitiesPageUrl);
		Assert.assertEquals(driver.getCurrentUrl(), languageUniversitiesPageUrl);
		String contentHeading1Text = OurWorkUniversitiesPage.contentHeading1(driver).getText();
		Assert.assertEquals(contentHeading1Text, TC03Data.germanLanguageHeadingText);

		driver.navigate().back();
		Assert.assertEquals(driver.getCurrentUrl(), TC03Data.universitiesPageUrl);

	}

	@After public void tearDown() {
		driver.quit();
	}

}
