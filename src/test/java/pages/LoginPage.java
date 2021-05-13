package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class LoginPage {

	WebDriver driver;
	
	By loginInput = By.cssSelector("#user-name");
	By loginPassword = By.cssSelector("#password");
	By loginButton = By.cssSelector("#login-button");
	By errorMessage = By.cssSelector(".error-message-container > h3:nth-child(1)");
	
	public LoginPage(WebDriver driver){

        this.driver = driver;

    }
	
	public boolean existsLoginButton(){

		return driver.findElement(loginButton).isDisplayed();

	}	
		
	public void doLogin(String user, String password){

		driver.findElement(loginInput).sendKeys(user);
		driver.findElement(loginPassword).sendKeys(password);
		driver.findElement(loginButton).click();

	}
	
	public String getErrorMessage(){

		return driver.findElement(errorMessage).getText();

	}
	
	public boolean userInvalid(){

		return this.getErrorMessage().toLowerCase().contains("username and password do not match any user in this service");

	}	
			
		
}
