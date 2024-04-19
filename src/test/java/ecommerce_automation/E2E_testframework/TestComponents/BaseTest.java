package ecommerce_automation.E2E_testframework.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ecommerce_automation.E2E_testframework.pageobjects.LandingPage;

public class BaseTest {
	protected WebDriver driver;
	protected LandingPage landingPage;

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
			System.setProperty("webdriver.gecko.driver",
					"C:/Users/Lenovo/Documents/geckodriver-v0.34.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:/Users/Lenovo/Documents/edgedriver_win64/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
    
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {

		driver = initializeDriver(driver);
		driver.get("https://rahulshettyacademy.com/client/");
		landingPage = new LandingPage(driver);
		return landingPage;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
