package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testCases.BaseClass;

public class HomePage {
	WebDriver driver = BaseClass.driver;

	// =============Locator repository==============

	@FindBy(xpath = "//div[@id='shopping_cart_container']/span")
	WebElement itemNumberAddedToCart;
	

	// =================Functions=================

	public void addToCart(String productName) {
	
		driver.findElement(By.xpath("//div[text()='"+ productName +"']/ancestor::div[@class='inventory_item']//button")).click();
		
	}
	
	public void verifyItemNumberAddedToCart(int ExpNumberOfItem) {
		Assert.assertEquals(ExpNumberOfItem, itemNumberAddedToCart.getText());
	}
}
