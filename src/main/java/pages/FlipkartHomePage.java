package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartHomePage {
	static By loginLinkLocator = By.name("_1_3w1N");
	static By MyAccountLink = By.xpath("//*[contains(text(),'My Account')]");
	
	public static WebElement getLoginLink(WebDriver driver) {
		return driver.findElement(loginLinkLocator);
	}
	
	public static WebElement getMyAccount(WebDriver driver) {
		return driver.findElement(MyAccountLink);
	}
}
