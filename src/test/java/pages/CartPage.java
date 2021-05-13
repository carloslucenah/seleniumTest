package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import storage.Product;


public class CartPage {
	
    WebDriver driver;
	By pageTitle = By.cssSelector(".title");
	By elementsAdded = By.cssSelector(".cart_item");
	By elementName = By.cssSelector(".inventory_item_name");
	By elementPrice = By.cssSelector(".inventory_item_price");
	By checkoutButton = By.cssSelector("#checkout");

	
	public CartPage(WebDriver driver){

        this.driver = driver;

    }
	
    public String getHomePageTitle(){

        return driver.findElement(pageTitle).getText().toLowerCase();

    }
 
	public boolean addedToCart (Product product) {
		WebElement name;
		WebElement price;
		for (WebElement addedElement:driver.findElements(elementsAdded)) {
			name = addedElement.findElement(elementName);
			price = addedElement.findElement(elementPrice);
			if (product.getName().toLowerCase().equals(name.getText().toLowerCase())) {
				if (product.getPrice() == Float.parseFloat(price.getText().replace("$", "")))
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	public void goToCheckout () {
		
		driver.findElement(checkoutButton).click();
		
	}

}
