package steps;

import io.cucumber.java8.En;
import pages.MenuPage;



public class MenuSteps extends BaseSteps implements En {

	public MenuSteps() {

		When("Hacemos logout", () -> {
			MenuPage menu_page = new MenuPage(driver);
			menu_page.doLogout();			
		});
		
	}
}