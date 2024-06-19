package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {

	public static List<WebElement> socialMediaButtonListItems(WebDriver driver) {
		return driver.findElements(By.xpath("//*[@id=\"right\"]/ul/li"));
	}

	public static WebElement facebookListItem(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"right\"]/ul/li[1]"));
	}

	public static WebElement twitterListItem(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"right\"]/ul/li[2]"));
	}

	public static WebElement inListItem(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"right\"]/ul/li[3]"));
	}

	public static WebElement ytListItem(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"right\"]/ul/li[4]"));
	}

	public static WebElement instaListItem(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"right\"]/ul/li[5]"));
	}

}
