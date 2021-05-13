package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java8.En;
import storage.Product;
import storage.Storage;
import pages.CheckoutOverviewPage;


public class CheckoutOverviewSteps extends BaseSteps implements En {

	public CheckoutOverviewSteps() {

		Then("Estamos en checkout overview", () -> {
			CheckoutOverviewPage checkoutOverview_page = new CheckoutOverviewPage(driver);			
			String title = checkoutOverview_page.getHomePageTitle();			
			assertEquals(title, "checkout: overview");
		});
		
		And("Los productos son correctos", () -> {		
			CheckoutOverviewPage checkoutOverview_page = new CheckoutOverviewPage(driver);			
			for (Product p: Storage.products) {
				assertTrue(checkoutOverview_page.addedToCart(p));
			}
		});
		
		And("Subtotal es correcto", () -> {
			CheckoutOverviewPage checkoutOverview_page = new CheckoutOverviewPage(driver);			
			assertTrue(checkoutOverview_page.checkSubtotal(Storage.products));
		});
		
		And("Total es correcto", () -> {
			CheckoutOverviewPage checkoutOverview_page = new CheckoutOverviewPage(driver);			
			assertTrue(checkoutOverview_page.checkTotal(Storage.products));
		});
		
		When("Pulsamos finish", () -> {
			CheckoutOverviewPage checkoutOverview_page = new CheckoutOverviewPage(driver);			
			checkoutOverview_page.goToCheckoutComplete();
		});
		
	}
}