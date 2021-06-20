package stepDefinition;


import org.apache.commons.codec.binary.Base64;
//import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;

import common.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.FlipkartHomePage;
import pages.FlipkartLoginPage;
import io.cucumber.java.en.Then;

public class FlipkartLoginSteps {
	
	Base64 b64 = new Base64();
	String uname = null; 
	String pwd = null; 
    //JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;  
	
	@Given("The user has navigated to the Flipkart home Page")
	public void the_user_has_navigated_to_the_flipkart_home_page() {
	   BaseClass.driver.get("https://flipkart.com");
	}
	
	@Given("The user clicks on the Login link")
	public void the_user_clicks_on_the_login_link() throws Exception {
		if(FlipkartLoginPage.getPasswordBox(BaseClass.driver).isDisplayed())
			;
		else
			FlipkartHomePage.getLoginLink(BaseClass.driver).click();
	}
	
	@When("The user enters the {string}")
	public void the_user_enters_the(String encoded) throws Exception {
	    byte[] credentials = b64.decode(encoded);
	    String creds = new String(credentials);
	    String[] arr = creds.split(":");
	    try {
	    	uname = arr[0];
	    	pwd = arr[1];
	    }
	    catch(Exception e) {
	    	throw new Exception ("Credentails incomplete" + creds);
	    }
	    FlipkartLoginPage.getUserNameBox(BaseClass.driver).sendKeys(uname);
	    FlipkartLoginPage.getPasswordBox(BaseClass.driver).sendKeys(pwd);
	}
	
	@When("The user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		common.Utilities.halt(2000);
		FlipkartLoginPage.getLoginButton(BaseClass.driver).click();
	}
	
	@Then("The login should be {string}")
	public void the_login_should_be(String string) throws Exception {
		common.Utilities.halt(2000);
		if(string.equalsIgnoreCase("successful")){
			try{
				FlipkartHomePage.getMyAccount(BaseClass.driver).isDisplayed();
			}
			catch (Exception e) {
				Assert.fail("Login failed, Test case failed");
			}
		}
		else if(string.equalsIgnoreCase("unsuccessful")) {
			try{
				FlipkartLoginPage.getErrorMessage(BaseClass.driver).isDisplayed();
			}
			catch (Exception e) {
				Assert.fail("No error message displayed");
			}
		}
		else throw new Exception ("Results expected is not available");
	}
}
