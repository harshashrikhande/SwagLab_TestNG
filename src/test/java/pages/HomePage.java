package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testCases.BaseClass;

public class HomePage {
	WebDriver driver = BaseClass.driver;

	// =============Locator repository==============

	//@FindBy(xpath = "//div[@id='shopping_cart_container']/span")
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
	WebElement itemNumberAddedToCart;
	
	@FindBy(id = "shopping_cart_container")
	WebElement shoppingCartContainer;
	
	@FindBy(xpath = "//select[contains(@class,'product_sort_container')]")
	WebElement productLabel;
	// =================Functions=================
	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public void addToCart(String productName) {
	
		driver.findElement(By.xpath("//div[text()='"+ productName +"']/ancestor::div[@class='inventory_item']//button")).click();
	}
	
	public void verifyItemNumberAddedToCart(String ExpNumberOfItem) {
		String actualItemNumber=itemNumberAddedToCart.getText();
		Assert.assertEquals(ExpNumberOfItem, actualItemNumber);
	}
}
