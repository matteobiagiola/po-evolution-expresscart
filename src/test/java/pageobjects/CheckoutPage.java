package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//a[@class='btn-default']")
	private WebElement payNowButton;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToPaymentPage() {
		payNowButton.click();
	}
}
