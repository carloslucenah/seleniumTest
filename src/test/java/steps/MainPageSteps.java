package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java8.En;
import pages.MainPage;
import storage.Storage;



public class MainPageSteps extends BaseSteps implements En {

	public MainPageSteps() {

		Then("Estamos en Products", () -> {
			MainPage main_page = new MainPage(driver);			
			String title = main_page.getHomePageTitle();			
			assertEquals(title, "products");
		});

		
		When("Pulsamos ordenar precio de bajo a alto", () -> {
			MainPage main_page = new MainPage(driver);
			main_page.orderProducts("lohi");			
		});
		
		When("Los productos estan ordenados por precio ascendentemente", () -> {
			MainPage main_page = new MainPage(driver);
			assertTrue(main_page.checkLowToHigh(main_page.getPrices()));			
		});
		

		When("^Agregamos (.+?) elementos al carro$", (String productos) -> 
		
		{
			MainPage main_page = new MainPage(driver);
			Storage.products = main_page.clickRandomButtons(main_page.getItems(), Integer.parseInt((productos)));
		});
		
		When("^Agregamos elemento (.+?) al carro$", (String producto) -> 
		
		{
			MainPage main_page = new MainPage(driver);
			Storage.products = main_page.addElement(main_page.getItems(), producto);
		});
		
		When("Accedemos al carro", () -> {
			MainPage main_page = new MainPage(driver);			
			main_page.goToCart();			
		});
		
		Then("^Hay (.+?) elementos en el carro$", (String quantity) -> {
			MainPage main_page = new MainPage(driver);			
			assertTrue(main_page.getNumberItemsInCart() == Integer.parseInt(quantity));			
		});
		
		
	}
}