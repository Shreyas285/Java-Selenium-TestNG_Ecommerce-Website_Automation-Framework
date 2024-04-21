package ecommerce_automation.E2E_testframework.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import ecommerce_automation.E2E_testframework.TestComponents.BaseTest;

public class SanityTest extends BaseTest {

	@Test(dataProviderClass= BaseTest.class, dataProvider = "getExcelData")
	public void sanityTest(String email, String password) throws IOException {

		landingPage.loginApplication(email, password);
		landingPage.logoutApplication();
	}
}