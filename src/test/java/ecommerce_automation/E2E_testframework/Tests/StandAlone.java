package ecommerce_automation.E2E_testframework.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAlone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Documents/chromedriver-win64/chromedriver.exe");

		// Create a object for browser driver class.
		WebDriver driver = new ChromeDriver();

		// Implicit wait until browser loads
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		// Hit the Login URL.
		driver.get("https://rahulshettyacademy.com/client/");

		// Maximize the web page
		driver.manage().window().maximize();

		driver.findElement(By.className("btn1")).click();

		driver.findElement(By.id("firstName")).sendKeys("Demo");
		driver.findElement(By.id("lastName")).sendKeys("Shreyas3@");
		driver.findElement(By.id("userEmail")).sendKeys("DemoShreyas3@mail.com");
		driver.findElement(By.id("userMobile")).sendKeys("1234567898");
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		driver.findElement(By.id("userPassword")).sendKeys("Shreyas3@");
		driver.findElement(By.id("confirmPassword")).sendKeys("Shreyas3@");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();

		driver.findElement(By.id("login")).click();

		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();

		driver.findElement(By.xpath("//p[@class='login-wrapper-footer-text']")).click();
		driver.findElement(By.id("userPassword")).sendKeys("Shreyas3@");

		driver.findElement(By.id("userEmail")).sendKeys("DemoShreyas3@mail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Shreyas3@");
		driver.findElement(By.id("login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Login Successfully']")));
		String loginMessage = driver.findElement(By.xpath("//div[@aria-label='Login Successfully']")).getText();
		Assert.assertEquals("Login Successfully", loginMessage);
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-label='Login Successfully']")));

		driver.findElement(By.xpath("//nav/label/following-sibling::ul/li[5]/button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Logout Successfully']")));
		String logoutMessage = driver.findElement(By.xpath("//div[@aria-label='Logout Successfully']")).getText();
		Assert.assertEquals("Logout Successfully", logoutMessage);
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-label='Logout Successfully']")));
	}

}
