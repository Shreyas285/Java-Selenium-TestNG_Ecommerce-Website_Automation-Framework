package ecommerce_automation.E2E_testframework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

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

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {

		driver = initializeDriver(driver);
		driver.get("https://rahulshettyacademy.com/client/");
		landingPage = new LandingPage(driver);
		return landingPage;
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider
	public String[][] getExcelData(Method m) throws IOException {
		
		String excelSheetName = m.getName();
		File f = new File("C:\\Users\\Lenovo\\eclipse-workspace\\E2E-testframework\\test-data\\Test_Data.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);

		int totalRows = sheetName.getLastRowNum();
		// System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalColumns = rowCells.getLastCellNum();
		// System.out.println(totalColumns);

		DataFormatter format = new DataFormatter();

		String testdata[][] = new String[totalRows][totalColumns];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				testdata[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}
		return testdata;
	}
}
