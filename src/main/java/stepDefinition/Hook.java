package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import common.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


//import com.applitools.eyes.BatchInfo;
//import com.applitools.eyes.EyesRunner;
//import com.applitools.eyes.selenium.ClassicRunner;
//import com.applitools.eyes.selenium.Eyes

public class Hook extends BaseClass{
	
	//private static EyesRunner runner;
	//static Eyes eyes;
	//private static BatchInfo batch;
	//static String API_KEY = "UJcUXK103uZ2c108ihDP98heOdd15MtKXfyc4Bgvh2ub0n3Y110";
	
	
	@Before(order = 0)
	public static void initDriver(Scenario scenario) throws Exception {
		/*batch = new BatchInfo(scenario.getName());
		runner = new ClassicRunner();
		eyes = new Eyes(runner);
		eyes.setApiKey(API_KEY);
		eyes.setBatch(batch);*/
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model
		options.addArguments("--headless"); // Bypass OS security model
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--start-maximized");
		BaseClass.driver = new ChromeDriver(options);
		//stepDefinition.Hook.eyes.open(driver,scenario.getName(),"tC01");
		BaseClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Before(order = 1)
	public static void maximizeWindow() {
		BaseClass.driver.manage().window().maximize();
	}

	@After(order = 0)
	public void teardown() {
		BaseClass.driver.quit();
		//eyes.closeAsync();
	}

}