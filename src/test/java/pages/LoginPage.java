package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testCases.BaseClass;

public class LoginPage {

	WebDriver driver = BaseClass.driver;

	// =============Locator repository==============

	@FindBy(id = "user-name")
	WebElement UserName;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(id = "login-button")
	WebElement LoginBtn;
	
	@FindBy(css = "h3")
	WebElement Error;
	
	
	
	// =================Functions=================

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public void LoginFunction(String UserNameVal, String PwdVal) {

		UserName.sendKeys(UserNameVal);
		Password.sendKeys(PwdVal);
		LoginBtn.click();
	}
	
	public void ValidateLoginSuccessfully(String ExpTitle) {

		String ActTitle = driver.getTitle();
		Assert.assertEquals(ExpTitle, ActTitle);
	}
	
	public void ValidateErrorMsg(String ExpMsg) {

		String ActMsg = Error.getText();
		Assert.assertEquals(ExpMsg, ActMsg);
	}
}
