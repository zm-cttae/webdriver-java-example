package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public static WebElement cultureLink(WebDriver driver) {
		return driver.findElement(By.linkText("Culture"));
	}

	public static WebElement ourWorkLink(WebDriver driver) {
		return driver.findElement(By.linkText("Our Work"));
	}

	public static WebElement servicesLink(WebDriver driver) {
		return driver.findElement(By.linkText("Services"));
	}

	public static WebElement careersLink(WebDriver driver) {
		return driver.findElement(By.linkText("Careers"));
	}

	public static WebElement investorsLink(WebDriver driver) {
		return driver.findElement(By.linkText("Investors"));
	}

	public static WebElement contactLink(WebDriver driver) {
		return driver.findElement(By.linkText("Contact"));
	}

	public static WebElement universitiesLink(WebDriver driver) {
		return driver.findElement(By.linkText("Universities"));
	}

	public static WebElement denyCookiesButton(WebDriver driver) {
		return driver.findElement(By.id("denycookies"));
	}

}
