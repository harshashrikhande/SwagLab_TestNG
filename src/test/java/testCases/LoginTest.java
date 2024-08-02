package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

@Listeners(Listener.class)
public class LoginTest extends BaseClass {

	
	
	@Test
	public void TC01_LoginSuccessTest() {
		LoginPage lp = new LoginPage();
		lp.LoginFunction("problem_user", "secret_sauce");
		lp.ValidateLoginSuccessfully("Swag Labs");
		
	}

	@Test
	public void TC02_LoginFailureTest() {
		LoginPage lp = new LoginPage();
		lp.LoginFunction("problem_user", "secret");
		lp.ValidateErrorMsg("Epic sadface: Username and password do not match any user in this service");
	}

	@Test
	public void TC03_LockedUserTest() {
		LoginPage lp = new LoginPage();
		lp.LoginFunction("locked_out_user", "secret_sauce");
		lp.ValidateErrorMsg("Epic sadface: Sorry, this user has been locked out.");
	}
	
	
}
