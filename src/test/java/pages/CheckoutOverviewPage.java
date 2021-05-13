package pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import storage.Product;


public class CheckoutOverviewPage {
	
    WebDriver driver;
	By pageTitle = By.cssSelector(".title");
	By elementsAdded = By.cssSelector(".cart_item");
	By elementName = By.cssSelector(".inventory_item_name");
	By elementPrice = By.cssSelector(".inventory_item_price");
	By elementQuantity = By.cssSelector(".cart_quantity");
	By cancelButton = By.cssSelector("#cancel");
	By finishButton = By.cssSelector("#finish");
	By subTotal = By.cssSelector(".summary_subtotal_label");
	By taxes = By.cssSelector(".summary_tax_label");
	By total = By.cssSelector(".summary_total_label");
	
	
	public CheckoutOverviewPage(WebDriver driver){

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
	
	public boolean checkSubtotal (List<Product> products) {
		float subtotal = 0;
		for (Product p: products) {
			subtotal += p.getPrice();
		}
		return Float.parseFloat(driver.findElement(subTotal).getText().replace("Item total: $","")) == subtotal;
	}
	
	public boolean checkTotal (List<Product> products) {
		boolean result;
		float fsubtotal, ftaxes, ftotal;
		fsubtotal = Float.parseFloat(driver.findElement(subTotal).getText().replace("Item total: $",""));
		ftaxes = Float.parseFloat(driver.findElement(taxes).getText().replace("Tax: $",""));
		ftotal = Float.parseFloat(driver.findElement(total).getText().replace("Total: $",""));
		System.out.println("subtotal: " + fsubtotal + " taxes: " + ftaxes + " total: "+ ftotal);
		
		result = (ftotal == (fsubtotal + ftaxes));
		System.out.println("result vale: "+result);
		return result;
	}
	
	public void goToCheckoutComplete(){
		driver.findElement(finishButton).click();
	}


}
