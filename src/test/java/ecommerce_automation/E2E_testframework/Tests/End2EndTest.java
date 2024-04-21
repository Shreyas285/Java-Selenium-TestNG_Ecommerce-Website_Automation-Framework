package ecommerce_automation.E2E_testframework.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ecommerce_automation.E2E_testframework.TestComponents.BaseTest;

public class End2EndTest extends BaseTest {

	@Test(dataProviderClass= BaseTest.class, dataProvider = "getExcelData")
	public void end2endTest(String firstname, String lastname, String email, String phonenumber,
			String password, String confirmpassword) throws IOException {

		landingPage.accountCreation(firstname, lastname, email, phonenumber, password, confirmpassword);
		Assert.assertEquals("Registered Successfully", landingPage.getRegisterMessage());
		landingPage.signInAccount();

		landingPage.loginApplication(email, password);
		Assert.assertEquals("Login Successfully", landingPage.getLoginMessage());

		landingPage.logoutApplication();
		Assert.assertEquals("Logout Successfully", landingPage.getLogoutMessage());
	}
}