package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinancialHighlightsPage {

	public static WebElement revenue2021ResultTd(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"section_3\"]/div/div[1]/div/table/tbody/tr[2]/td[2]"));
	}

	public static WebElement revenue2020ResultTd(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"section_3\"]/div/div[1]/div/table/tbody/tr[2]/td[3]"));
	}

	public static List<WebElement> positiveChangeTdList(WebDriver driver) {
		return driver.findElements(By.xpath("//*[@id=\"section_3\"]/div/div[1]/div/table/tbody/tr/td[4 and starts-with(text(), '+')]/../td[1]"));
	}

}
