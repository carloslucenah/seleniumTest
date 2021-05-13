package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutPage {
	
    WebDriver driver;
	By pageTitle = By.cssSelector(".title");
	By firstName = By.cssSelector("#first-name");
	By lastName = By.cssSelector("#last-name");
	By postalCode = By.cssSelector("#postal-code");
	By cancelButton = By.cssSelector("#cancel");
	By continueButton = By.cssSelector("#continue");


	
	public CheckoutPage(WebDriver driver){

        this.driver = driver;

    }
	
    public String getHomePageTitle(){

        return driver.findElement(pageTitle).getText().toLowerCase();

    }
    
    public void fillForm(String name, String surname, String pcode){

        driver.findElement(firstName).sendKeys(name);
        driver.findElement(lastName).sendKeys(surname);
        driver.findElement(postalCode).sendKeys(pcode);

    }
    
    public void goToCheckoutOverview(){
    	WebElement button = driver.findElement(continueButton);
    	button.click();

    }
 

}
