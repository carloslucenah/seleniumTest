package steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java8.En;
import pages.LoginPage;



public class LoginSteps extends BaseSteps implements En {

	public LoginSteps() {

		Given("Nos encontramos en la pagina de login", () -> {
			LoginPage login_page = new LoginPage(driver);
			assertTrue(login_page.existsLoginButton());			
		});
		
		When("^Hacemos login con usuario (.+?) y password (.+?)$", (String user, String password) -> {
			LoginPage login_page = new LoginPage(driver);
			login_page.doLogin(user, password);			
		});
		
		Then("Se muestra error de usuario invalido", () -> {
			LoginPage login_page = new LoginPage(driver);
			assertTrue(login_page.userInvalid());			
		});
		
	}
}