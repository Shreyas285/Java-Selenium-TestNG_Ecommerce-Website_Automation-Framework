package ecommerce_automation.E2E_testframework.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ecommerce_automation.E2E_testframework.pageobjects.LandingPage;

public class BaseTest {
	protected WebDriver driver;

	public WebDriver initializeDriver(WebDriver Driver) throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\ecommerce_automation\\E2E_testframework\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Lenovo/Documents/chromedriver-win64/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Lenovo/Documents/chromedriver-win64/chromedriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Lenovo/Documents/chromedriver-win64/chromedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	public LandingPage launchApplication() throws IOException {

		driver = initializeDriver(driver);
		driver.get("https://rahulshettyacademy.com/client/");
		LandingPage landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}
