package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class CheckoutCompletePage {
	
    WebDriver driver;
	By pageTitle = By.cssSelector(".title");
	By header = By.cssSelector(".complete-header");
	By backButton = By.cssSelector("#back-to-products");
	
	
	public CheckoutCompletePage(WebDriver driver){

        this.driver = driver;

    }
	
    public String getHomePageTitle(){

        return driver.findElement(pageTitle).getText().toLowerCase();

    }
 
	public void goBack(){

		driver.findElement(backButton).click();

	}
	
	public boolean purchaseSuccessful(){
		System.out.println("Texto: " + driver.findElement(header).getText().toLowerCase());
		return driver.findElement(header).getText().toLowerCase().contains("thank you for your order");

	}

}
