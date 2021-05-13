package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
	
    WebDriver driver;
	By menuButton = By.cssSelector("#react-burger-menu-btn");
	By logoutButton = By.cssSelector("#logout_sidebar_link");
	
	public MenuPage(WebDriver driver){

        this.driver = driver;

    }
    
	public void doLogout(){

		driver.findElement(menuButton).click();
		driver.findElement(logoutButton).click();

	}

}
