package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartLoginPage {

	static By userName = By.xpath("//input[contains(@class,'VJZDxU') and @type='text']");
	static By password = By.xpath("//input[contains(@class,'VJZDxU') and @type='password']");
	static By LoginButton = By.xpath("//button[contains(@class,'3AWRsL') and @type='submit']");
	static By errorMessage = By.xpath("//*[contains(text(),'Your username or password is incorrect')]");
		
	public static WebElement getUserNameBox(WebDriver driver) {
		return driver.findElement(userName);
	}
	
	public static WebElement getPasswordBox(WebDriver driver) {
		return driver.findElement(password);
	}
	
	public static WebElement getLoginButton(WebDriver driver) {
		return driver.findElement(LoginButton);
	}
	
	public static WebElement getErrorMessage(WebDriver driver) {
		return driver.findElement(errorMessage);
	}
}
