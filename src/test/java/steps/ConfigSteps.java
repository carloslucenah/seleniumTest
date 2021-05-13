package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java8.En;


public class ConfigSteps extends BaseSteps implements En{

	public ConfigSteps() {
		
		Before(()->{
			System.setProperty("webdriver.gecko.driver", "/home/carloslucena/Selenium/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//ir a google
			driver.get("https://www.saucedemo.com/");
		});
		
	
		After(()->{
			driver.quit();
		});
		
	}
}