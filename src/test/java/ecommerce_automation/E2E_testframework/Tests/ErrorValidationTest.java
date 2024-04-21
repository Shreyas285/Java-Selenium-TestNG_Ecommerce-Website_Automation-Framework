package ecommerce_automation.E2E_testframework.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ecommerce_automation.E2E_testframework.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test(dataProviderClass= BaseTest.class, dataProvider = "getExcelData")
	public void errorValidationTest(String firstname, String lastname, String email, String phonenumber,
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

		landingPage.loginApplication(email, password);
		Assert.assertEquals("Incorrect email or password.", landingPage.getInvalidCredentialErrorMessage());
	}
}