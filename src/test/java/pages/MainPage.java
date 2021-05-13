package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import storage.Product;

public class MainPage {
	
    WebDriver driver;
	By pageTitle = By.cssSelector("#header_container>.header_secondary_container>.title");
	By menuButton = By.cssSelector("#react-burger-menu-btn");
	By logoutButton = By.cssSelector("#logout_sidebar_link");
	By orderSelector = By.cssSelector(".product_sort_container");
	By prices = By.cssSelector(".inventory_item_price");
	By addToCartButtons = By.cssSelector(".btn_inventory");
	By addOnesieToCartButton = By.cssSelector("#add-to-cart-sauce-labs-onesie");
	By cartButton = By.cssSelector(".shopping_cart_link");
	By elementsAdded = By.cssSelector(".inventory_item_name");
	By items = By.cssSelector(".inventory_item");
	By numberItemsInCart = By.cssSelector(".shopping_cart_badge");
	
	public MainPage(WebDriver driver){

        this.driver = driver;

    }
	
    public String getHomePageTitle(){

        return driver.findElement(pageTitle).getText().toLowerCase();

    }
    
	public void orderProducts(String value){
		
		Select selectObject = new Select(driver.findElement(orderSelector));
		selectObject.selectByValue(value);

	}
	
	public float[] getPrices(){
		
		List<WebElement> elements = driver.findElements(prices);
		float prices[] = new float [elements.size()];
		int i = 0;
		for (WebElement we: elements) {
			prices[i] = Float.parseFloat(we.getText().replace("$",""));
			i++;
		}
		return prices;
		
	}
	
	public boolean checkLowToHigh(float [] prices){
		
		for (int i = 0; i < prices.length-1; i ++) {
			if (prices[i] > prices [i+1])
				return false;
		}
		return true;
	}
	
	public List<Product> addElement(List <WebElement> items, String itemToClick){
		List<Product> elementsAdded = new ArrayList<Product>();
		String itemName;
		float price;
		WebElement button;
	
		for (WebElement item : items) {
		    itemName = item.findElement(By.cssSelector(".inventory_item_name")).getText().toLowerCase();
		    if (itemName.equals(itemToClick.toLowerCase())) {
			    price = Float.parseFloat(item.findElement(By.cssSelector(".inventory_item_price")).getText().replace("$", ""));
			    button = item.findElement(By.cssSelector(".btn_inventory"));
			    button.click();
			    elementsAdded.add(new Product(itemName,price));
			    return elementsAdded;
		    }
		    
		}
	    return elementsAdded;  
	}
	
	public List<Product> clickRandomButtons(List <WebElement> items, int quantity){
		String itemName;
		float price;
		WebElement button;
		List<Product> elementsAdded = new ArrayList<Product>();
		for (int i = 0; i < quantity; i ++) {
		    Random rand = new Random();
		    int randomElement = rand.nextInt(items.size());
		    WebElement item = items.get(randomElement);
		    itemName = item.findElement(By.cssSelector(".inventory_item_name")).getText().toLowerCase();
		    price = Float.parseFloat(item.findElement(By.cssSelector(".inventory_item_price")).getText().replace("$", ""));
		    button = item.findElement(By.cssSelector(".btn_inventory"));
		    button.click();
		    items.remove(item);
		    elementsAdded.add(new Product(itemName,price));
		}
		return elementsAdded;
	}
	
	public List <WebElement> getAddToCartButtons(){
		
		return driver.findElements(addToCartButtons);
	}
	
	public List <WebElement> getItems(){
		
		return driver.findElements(items);
	}

	public void goToCart(){

		driver.findElement(cartButton).click();

	}
	
	public int getNumberItemsInCart(){
		
		return Integer.parseInt(driver.findElement(numberItemsInCart).getText());
	}
}
