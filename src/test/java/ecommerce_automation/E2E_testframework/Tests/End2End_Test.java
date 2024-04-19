package ecommerce_automation.E2E_testframework.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ecommerce_automation.E2E_testframework.TestComponents.BaseTest;

public class End2End_Test extends BaseTest {

	@Test(dataProvider = "getData")
	public void end2endTest(String firstname, String lastname, String email, String phonenumber, String password,
			String confirmpassword) throws IOException {
   
		//landingPage.accountCreation(firstname, lastname, email, phonenumber, password,
		//		confirmpassword);
		//Assert.assertEquals("Registered Successfully",
		//landingPage.getRegisterMessage());
		//landingPage.signInAccount();

		landingPage.loginApplication(email, password);
		Assert.assertEquals("Login Successfully", landingPage.getLoginMessage());

		landingPage.logoutApplication();
		Assert.assertEquals("Logout Successfully", landingPage.getLogoutMessage());

		closeBrowser();
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
				{ "Demo", "Shreyas21@", "DemoShreyas21@mail.com", "1234567898", "Shreyas21@", "Shreyas21@" },
				{ "Demo", "Shreyas22@", "DemoShreyas22@mail.com", "1234567898", "Shreyas22@", "Shreyas22@" } };
	}
}