package ecommerce_automation.E2E_testframework.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ecommerce_automation.E2E_testframework.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void errorValidationRegisterTab(String firstname, String lastname, String email, String phonenumber,
			String password, String confirmpassword) throws IOException, InterruptedException {
		if (password != confirmpassword) {
			landingPage.accountCreation(firstname, lastname, email, phonenumber, password, confirmpassword);
			Assert.assertEquals("Password and Confirm Password must match with each other.",
					landingPage.getPasswordMismatchErrorMessage());
		} else {
			landingPage.accountCreation(firstname, lastname, email, phonenumber, password, confirmpassword);
			Assert.assertEquals("User already exisits with this Email Id!",
					landingPage.getExistingEmailidErrorMessage());
		}

		landingPage.goToLoginPage();
	}

	@Test(dependsOnMethods = { "errorValidationRegisterTab" }, dataProvider = "getData")
	public void errorValidationLoginTab(String firstname, String lastname, String email, String phonenumber,
			String password, String confirmpassword) throws IOException, InterruptedException {
		landingPage.loginApplication(email, password);
		Assert.assertEquals("Incorrect email or password.", landingPage.getInvalidCredentialErrorMessage());
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
				{ "Demo", "Shreyas20@", "DemoShreyas23@mail.com", "1234567898", "Shreyas23@", "Shreyas22@" },
				{ "Demo", "Shreyas20@", "DemoShreyas20@mail.com", "1234567898", "Shreyas23@", "Shreyas23@" } };
	}
}