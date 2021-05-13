package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java8.En;
import storage.Product;
import storage.Storage;
import pages.CartPage;


public class CartSteps extends BaseSteps implements En {

	public CartSteps() {
		
		Then("Estamos en el carro", () -> {
			CartPage cart_page = new CartPage(driver);			
			String title = cart_page.getHomePageTitle();			
			assertEquals(title, "your cart");
		});
		
		Then("Los productos estan en el carro", () -> {
			CartPage cart_page = new CartPage(driver);			
			for (Product p: Storage.products) {
				assertTrue(cart_page.addedToCart(p));
			}
		});
		
		When("Pulsamos checkout", () -> {
			CartPage cart_page = new CartPage(driver);			
			cart_page.goToCheckout();
		});
		
	}
}