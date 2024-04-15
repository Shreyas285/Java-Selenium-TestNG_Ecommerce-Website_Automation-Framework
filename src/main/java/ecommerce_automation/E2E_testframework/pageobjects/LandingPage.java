package ecommerce_automation.E2E_testframework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce_automation.E2E_testframework.abstractcomponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	protected WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "btn1")
	WebElement RegisterButton;

	@FindBy(id = "firstName")
	WebElement FirstName;

	@FindBy(id = "lastName")
	WebElement LastName;

	@FindBy(id = "userEmail")
	WebElement Email;

	@FindBy(id = "userMobile")
	WebElement PhoneNumber;

	@FindBy(css = "input[value='Male']")
	WebElement Gender;

	@FindBy(id = "userPassword")
	WebElement Password;

	@FindBy(id = "confirmPassword")
	WebElement ConfirmPassword;

	@FindBy(css = "input[type='checkbox']")
	WebElement AgeVerify;

	@FindBy(id = "login")
	WebElement Register;

	By RegisterMessage = By.id("toast-container");

	@FindBy(css = "button[class='btn btn-primary']")
	WebElement SignIn;

	@FindBy(id = "userEmail")
	WebElement UserEmail;

	@FindBy(id = "userPassword")
	WebElement UserPassword;

	@FindBy(id = "login")
	WebElement Login;

	By LoginMessage = By.xpath("//div[@aria-label='Login Successfully']");
	
	By LogoutMessage = By.xpath("//div[@aria-label='Logout Successfully']");

	public void accountCreation(String firstname, String lastname, String email, String phonenumber, String password,
			String confirmpassword) {
		RegisterButton.click();
		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		Email.sendKeys(email);
		PhoneNumber.sendKeys(phonenumber);
		Gender.click();
		Password.sendKeys(password);
		ConfirmPassword.sendKeys(confirmpassword);
		AgeVerify.click();
		Register.click();
	}
	
	public void signInAccount() {
		SignIn.click();
	}

	public void loginApplication(String email, String password) {
		Email.sendKeys(email);
		Password.sendKeys(password);
		Login.click();
	}

	public String getRegisterMessage() {
		waitForElementToAppear(RegisterMessage);
		String getRegisterMessage = driver.findElement(RegisterMessage).getText();
		waitForElementToDisappear(RegisterMessage);
		return getRegisterMessage;
	}

	public String getLoginMessage() {
		waitForElementToAppear(LoginMessage);
		String getLoginMessage = driver.findElement(LoginMessage).getText();
		waitForElementToDisappear(LoginMessage);
		return getLoginMessage;
	}
	
	public String getLogoutMessage() {
		waitForElementToAppear(LogoutMessage);
		String getLogoutMessage = driver.findElement(LogoutMessage).getText();
		waitForElementToDisappear(LogoutMessage);
		return getLogoutMessage;
	}
}
