package tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverutilities.DriverUtilities;
import pageobjects.FinancialHighlightsPage;
import pageobjects.HomePage;
import testdata.TC04Data;

public class TC04 {

	WebDriver driver;

	@Before public void preConditions() {
		DriverUtilities myDriverUtilities = new DriverUtilities();

		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(TC04Data.financialHighlightsPageUrl);
		HomePage.denyCookiesButton(driver).click();
	}

	@Test public void financialHighlightsPage() throws InterruptedException, IOException {

		String revenue2020Text = FinancialHighlightsPage.revenue2020ResultTd(driver).getText();
		String revenue2021Text = FinancialHighlightsPage.revenue2021ResultTd(driver).getText();
		Assert.assertTrue(convertRevenueToDouble(revenue2020Text) > convertRevenueToDouble(revenue2021Text));

		List<WebElement> positiveChangeTdList = FinancialHighlightsPage.positiveChangeTdList(driver);

		List<String> expectedPositiveChangeFigures = Arrays.asList(
				"Cash flow generated from operations",
				"Cas conversion",
				"Dividend per share",
				"Cash position at the end of the period"
		);

		for (int i = 0; i < positiveChangeTdList.size(); i++) {
			WebElement td = positiveChangeTdList.get(i);
			String expectedPositiveChangeFigure = expectedPositiveChangeFigures.get(i);
			Assert.assertTrue(expectedPositiveChangeFigure.equals(td.getText()));
		}

	}
	
	public double convertRevenueToDouble(String revenue) {
		Pattern revenuePattern = Pattern.compile("^£(\\d+\\.\\d+)\\w$");
		Matcher revenueMatcher = revenuePattern.matcher(revenue);
		return Double.parseDouble(revenueMatcher.group(1));
	}

	@After public void tearDown() {
		driver.quit();
	}

}
