package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseClass {

	@Test
	public void TC01_AddToCartTest() {
		LoginPage lp = new LoginPage();
		lp.LoginFunction("standard_user", "secret_sauce");
		HomePage hp = new HomePage();
		hp.addToCart("Sauce Labs Backpack");
		hp.verifyItemNumberAddedToCart(1);
		
	}
	
	
}
