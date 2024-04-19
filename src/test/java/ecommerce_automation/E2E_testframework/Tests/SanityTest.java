package ecommerce_automation.E2E_testframework.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ecommerce_automation.E2E_testframework.TestComponents.BaseTest;

public class SanityTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void sanityTest(String email, String password) throws IOException {

		landingPage.loginApplication(email, password);
		Assert.assertEquals("Login Successfully", landingPage.getLoginMessage());

		landingPage.logoutApplication();
		Assert.assertEquals("Logout Successfully", landingPage.getLogoutMessage());
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "DemoShreyas20@mail.com", "Shreyas20@" } };
	}
}