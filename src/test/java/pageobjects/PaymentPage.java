package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	private WebDriver driver;

//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]")
	@FindBy(xpath = "//input[@id='customerLoginEmail']")
	private WebElement existingCustomerEmailAddressInput;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/fieldset[1]/input[1]")
	@FindBy(xpath = "//input[@id=\"shipEmail\"]")
	private WebElement newCustomerEmailAddressInput;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/fieldset[1]/input[1]")
	@FindBy(xpath = "//input[@id=\"shipFirstname\"]")
	private WebElement newCustomerFirstNameInput;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[1]/fieldset[1]/input[1]")
	@FindBy(xpath = "//input[@id=\"shipLastname\"]")
	private WebElement newCustomerLastNameInput;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[4]/div[1]/fieldset[1]/input[1]")
	@FindBy(xpath = "//input[@id=\"shipAddr1\"]")
	private WebElement newCustomerAddress1Input;

	@FindBy(xpath = "//input[@id=\"shipAddr2\"]")
	private WebElement newCustomerAddress2Input;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[6]/div[1]/fieldset[1]/input[1]")
	@FindBy(xpath = "//input[@id=\"shipCountry\"]")
	private WebElement newCustomerCountryInput;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[7]/div[1]/fieldset[1]/input[1]")
	@FindBy(xpath = "//input[@id=\"shipState\"]")
	private WebElement newCustomerStateInput;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[8]/div[1]/fieldset[1]/input[1]")
	@FindBy(xpath = "//input[@id=\"shipPostcode\"]")
	private WebElement newCustomerPostCodeInput;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[9]/div[1]/fieldset[1]/input[1]")
	@FindBy(xpath = "//input[@id=\"shipPhoneNumber\"]")
	private WebElement newCustomerPhoneNumberInput;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[11]/div[1]/fieldset[1]/input[1]")
	@FindBy(xpath = "//input[@id='newCustomerPassword']")
	private WebElement newCustomerPasswordInput;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[11]/a[1]")
	@FindBy(xpath = "//a[@id='createCustomerAccount']")
	private WebElement createAccountButton;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/input[1]")
	@FindBy(xpath = "//input[@id='customerLoginPassword']")
	private WebElement passwordInput;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/button[1]")
	@FindBy(xpath = "//button[@id='customerLogin']")
	private WebElement loginButton;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[3]")
	@FindBy(xpath = "//div[@id='notify_message']")
	private WebElement notificationMessage;
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void insertExistingCustomerEmail(String email) {
		existingCustomerEmailAddressInput.sendKeys(email);
	}
	
	public String getCustomerDetailsEmailAddress() {
		return newCustomerEmailAddressInput.getAttribute("value");
	}
	
	public void insertPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void login() {
		loginButton.click();
	}
	
	public String getNotificationMessage() {
		return notificationMessage.getText();
	}
	
	public void insertNewCustomerEmail(String email) {
		newCustomerEmailAddressInput.sendKeys(email);
	}
	
	public void insertFirstName(String firstName) {
		newCustomerFirstNameInput.sendKeys(firstName);
	}
	
	public void insertLastName(String lastName) {
		newCustomerLastNameInput.sendKeys(lastName);
	}
	
	public void insertAddress1(String address) {
		newCustomerAddress1Input.sendKeys(address);
	}
	
	public void insertCountry(String country) {
		newCustomerCountryInput.sendKeys(country);
	}
	
	public void insertState(String state) {
		newCustomerStateInput.sendKeys(state);
	}
	
	public void insertPostCode(String postCode) {
		newCustomerPostCodeInput.sendKeys(postCode);
	}
	
	public void insertPhoneNumber(String phoneNumber) {
		newCustomerPhoneNumberInput.sendKeys(phoneNumber);
	}
	
	public void insertNewCustomerPassword(String password) {
		newCustomerPasswordInput.sendKeys(password);
	}
	
	public void createAccount() {
		createAccountButton.click();
	}

	/* start added by authors */
	public String getLoggedCustomerShipEmailAddress() {
		return newCustomerEmailAddressInput.getAttribute("value");
	}

	public String getLoggedCustomerShipFirstName() {
		return newCustomerFirstNameInput.getAttribute("value");
	}

	public String getLoggedCustomerShipLastName() {
		return newCustomerLastNameInput.getAttribute("value");
	}

	public String getLoggedCustomerShipFirstAddress() {
		return newCustomerAddress1Input.getAttribute("value");
	}

	public String getLoggedCustomerShipSecondAddress() {
		return newCustomerAddress2Input.getAttribute("value");
	}

	public String getLoggedCustomerShipCountry() {
		return newCustomerCountryInput.getAttribute("value");
	}

	public String getLoggedCustomerShipState() {
		return newCustomerStateInput.getAttribute("value");
	}

	public String getLoggedCustomerShipPostCode() {
		return newCustomerPostCodeInput.getAttribute("value");
	}

	public String getLoggedCustomerShipPhoneNumber() {
		return newCustomerPhoneNumberInput.getAttribute("value");
	}
	/* end added by authors */
}
