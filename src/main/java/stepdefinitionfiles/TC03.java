package stepdefinitionfiles;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.junit.Before;
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
	private WebElement brochureLink;
	private WebElement scrollButton;
	private WebElement locationSelectorUnorderedList;
	private WebElement locationSelectorLanguageLink;
	private String languageUniversitiesPageUrl;
	private WebElement universitySlideDiv;

	@Before public void preConditions() {
	}

	@Given("that the browser is open")
	public void that_the_browser_is_open() {
		DriverUtilities myDriverUtilities = new DriverUtilities();

		driver = myDriverUtilities.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		actions = new Actions(driver);
		slideWait = new WebDriverWait(driver, 15);
	}

	@Given("the user is on the FDM webpage")
	public void the_user_is_on_the_fdm_webpage() {
		driver.get(TC03Data.FDMUrl);
		HomePage.denyCookiesButton(driver).click();
	}

	@When("I hover over the OUR WORK link")
	public void i_hover_over_the_our_work_link() {
		actions.moveToElement(HomePage.ourWorkLink(driver)).perform();
	}

	@Then("The UNIVERSITIES button is displayed")
	public void the_universities_button_is_displayed() {
		Assert.assertTrue(HomePage.universitiesLink(driver).isDisplayed());
	}

	@When("I click the UNIVERSITIES button")
	public void i_click_the_universities_button() {
		HomePage.universitiesLink(driver).click();
	}

	@Then("The universities page is displayed")
	public void the_universities_page_is_displayed() {
		Assert.assertEquals(driver.getCurrentUrl(), TC03Data.universitiesPageUrl);
	}

	@Then("A slide shows that there are ninety+ uni partnerships")
	public void a_slide_shows_that_there_are_ninety_uni_partnerships() {
		WebElement partnershipsParagraph = OurWorkUniversitiesPage.partnershipsParagraph(driver);
		Assert.assertTrue(partnershipsParagraph.getText().contains(" 90 partnerships "));
	}

	@Then("A slide mentions four-hundred-and-eighty+ universities")
	public void a_slide_mentions_four_hundred_and_eighty_universities() {
		universitySlideDiv = OurWorkUniversitiesPage.universitySlideDiv(driver);
		slideWait.until(ExpectedConditions.attributeContains(universitySlideDiv, "tabindex", "0"));
		Assert.assertTrue(universitySlideDiv.getText().contains(" 480+ universities"));
	}

	@When("I click the left arrow under Global Recruitment'")
	public void i_click_the_left_arrow_under_global_recruitment() {
		slideWait.until(ExpectedConditions.attributeContains(universitySlideDiv, "tabindex", "0"));
		actions.moveToElement(OurWorkUniversitiesPage.recruitmentLeftButton(driver));
		OurWorkUniversitiesPage.recruitmentLeftButton(driver).click();
	}

	@Then("A slide mentions two-hundred+ high-profile clients")
	public void a_slide_mentions_two_hundred_high_profile_clients() {
		WebElement worldwideClientsSlideDiv = OurWorkUniversitiesPage.worldwideClientsSlideDiv(driver);
		slideWait.until(ExpectedConditions.attributeContains(worldwideClientsSlideDiv, "tabindex", "0"));
		Assert.assertTrue(worldwideClientsSlideDiv.getText().contains(" 200+ high profile clients "));
	}

	@When("I click View brochure button")
	public void i_click_view_brochure_button() {
		scrollButton = OurWorkUniversitiesPage.scrollButton(driver);
		brochureLink = OurWorkUniversitiesPage.brochureLink(driver);
		scrollButton.click();
		slideWait.until(ExpectedConditions.invisibilityOf(scrollButton));
		brochureLink.click();
	}

	@Then("The FDM brochure is displayed")
	public void the_fdm_brochure_is_displayed() {
		slideWait.until(ExpectedConditions.stalenessOf(brochureLink));
		Assert.assertEquals(driver.getCurrentUrl(), TC03Data.brochureUploadUrl);
	}

	@When("I click the browser back button")
	public void i_click_the_browser_back_button() {
		driver.navigate().back();
	}

	@When("I click the GBR button")
	public void i_click_the_gbr_button() {
		OurWorkUniversitiesPage.locationSelectorLink(driver).click();
	}

	@Then("A dropdown list is displayed")
	public void a_dropdown_list_is_displayed() {
		locationSelectorUnorderedList = OurWorkUniversitiesPage.locationSelectorUl(driver);
		Assert.assertTrue(locationSelectorUnorderedList.isDisplayed());
	}

	@Then("The list contains an option to switch to {string}")
	public void the_list_contains_an_option_to_switch_to(String language) {
		locationSelectorLanguageLink = OurWorkUniversitiesPage.locationSelectorLanguageLink(driver, language);
		Assert.assertTrue(locationSelectorLanguageLink.isDisplayed());
	}

	@When("I click the {string} button")
	public void i_click_the_button(String language) {
		languageUniversitiesPageUrl = locationSelectorLanguageLink.getAttribute("href");
		locationSelectorLanguageLink.click();
	}

	@Then("The {string} universities page is displayed")
	public void the_universities_page_is_displayed(String language) {
		Assert.assertNotEquals(driver.getCurrentUrl(), TC03Data.universitiesPageUrl);
		Assert.assertEquals(driver.getCurrentUrl(), languageUniversitiesPageUrl);
	}

	@Then("The universities page heading is now known as {string}")
	public void the_universities_page_heading_is_now_known_as(String heading) {
		String contentHeading1Text = OurWorkUniversitiesPage.contentHeading1(driver).getText();
		Assert.assertEquals(contentHeading1Text, heading);
	}

}
