package steps;

import static org.junit.Assert.assertEquals;
import io.cucumber.java8.En;
import pages.CheckoutPage;


public class CheckoutSteps extends BaseSteps implements En {

	public CheckoutSteps() {

		Then("Estamos en checkout", () -> {
			CheckoutPage checkout_page = new CheckoutPage(driver);			
			String title = checkout_page.getHomePageTitle();	
			assertEquals(title, "checkout: your information");
		});
		
		When("^Rellenamos datos personales de compra con (.+?), (.+?), (.+?)$", (String name, String surname, String postalCode) -> {
			CheckoutPage checkout_page = new CheckoutPage(driver);	
			checkout_page.fillForm(name, surname, postalCode);
		});
		

		And("Pulsamos continue", () -> 
		
		{
			CheckoutPage checkout_page = new CheckoutPage(driver);	
			checkout_page.goToCheckoutOverview();
		});
		
		
	}
}