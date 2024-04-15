package ecommerce_automation.E2E_testframework.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ecommerce_automation.E2E_testframework.TestComponents.BaseTest;
import ecommerce_automation.E2E_testframework.pageobjects.LandingPage;

public class End2End_Test extends BaseTest {

	@Test
	public void end2endTest() throws IOException {

		LandingPage landingPage = launchApplication();

		landingPage.accountCreation("Demo", "Shreyas19@", "DemoShreyas19@mail.com", "1234567898", "Shreyas19@",
				"Shreyas19@");
		Assert.assertEquals("Registered Successfully", landingPage.getRegisterMessage());
        landingPage.signInAccount();

		landingPage.loginApplication("DemoShreyas19@mail.com", "Shreyas19@");
		Assert.assertEquals("Login Successfully", landingPage.getLoginMessage());

		landingPage.logoutApplication();
		Assert.assertEquals("Logout Successfully", landingPage.getLogoutMessage());

		closeBrowser();
	}
}