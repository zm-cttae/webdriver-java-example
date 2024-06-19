package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {

	public static WebElement heading(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}

	public static WebElement departmentDropDownList(WebDriver driver) {
		return driver.findElement(By.name("Department"));
	}

	public static WebElement firstNameField(WebDriver driver) {
		return driver.findElement(By.name("FirstName"));
	}

	public static WebElement lastNameField(WebDriver driver) {
		return driver.findElement(By.name("LastName"));
	}

	public static WebElement emailAddressField(WebDriver driver) {
		return driver.findElement(By.name("Email"));
	}

	public static WebElement phoneNumberField(WebDriver driver) {
		return driver.findElement(By.name("Phone"));
	}

	public static WebElement messageField(WebDriver driver) {
		return driver.findElement(By.name("Message"));
	}

	public static WebElement submitButton(WebDriver driver) {
		return driver.findElement(By.name("submit"));
	}

	public static WebElement lastNameError(WebDriver driver) {
		return driver.findElement(By.id("lastname-error"));
	}
}
