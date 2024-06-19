package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OurWorkUniversitiesPage {

	public static WebElement locationSelectorUl(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"fdm-location-selector\"]/ul"));
	}

	public static WebElement locationSelectorLink(WebDriver driver) {
        return driver.findElement(By.xpath("///*[@id=\"fdm-location-selector\"]/div/a"));
    }

    public static WebElement locationSelectorLanguageLink(WebDriver driver, String language) {
        return locationSelectorLink(driver).findElement(By.linkText(language));
    }

    public static WebElement brochureLink(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main\"]/section[1]/div/div/div/div/a"));
    }

    public static WebElement contentHeading1(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"section_2\"]/div/div[1]/h2"));
    }

    public static WebElement partnershipsParagraph(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"section_2\"]/div/div[1]/p[1]"));
    }

    public static WebElement recruitmentLeftButton(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"section_2\"]/div/div[2]/div/button[1]"));
    }

    public static WebElement universitySlideDiv(WebDriver driver) {
    	return driver.findElement(By.xpath("//*[@id=\"slick-slide01\"]/p"));
    }

    public static WebElement worldwideClientsSlideDiv(WebDriver driver) {
    	return driver.findElement(By.xpath("//*[@id=\"slick-slide06\"]/p"));
    }

    public static WebElement scrollButton(WebDriver driver) {
    	return driver.findElement(By.id("scroll"));
    }

}
