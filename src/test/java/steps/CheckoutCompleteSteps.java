package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java8.En;
import pages.CheckoutCompletePage;



public class CheckoutCompleteSteps extends BaseSteps implements En{

	public CheckoutCompleteSteps() {
		
	
		Then("Estamos en Checkout complete", () -> {
			CheckoutCompletePage checkout_complete_page = new CheckoutCompletePage(driver);			
			String title = checkout_complete_page.getHomePageTitle();			
			assertEquals(title, "checkout: complete!");
		});
		
		And("Se muestra el mensaje de compra correcta", () -> {
			CheckoutCompletePage checkout_complete_page = new CheckoutCompletePage(driver);			
			assertTrue(checkout_complete_page.purchaseSuccessful());
		});
		
		When("Pulsamos go back", () -> {
			CheckoutCompletePage checkout_complete_page = new CheckoutCompletePage(driver);			
			checkout_complete_page.goBack();
		});
		
	}
}