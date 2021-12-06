package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartWindow {
	private WebDriver driver;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/p[1]/a[1]")
	private WebElement firstProductName;
	
	@FindBy(xpath = "//input[@id='first']")
	private WebElement firstProductQuantity;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/p[5]")
	private WebElement firstProductSize;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/p[1]/a[1]")
	private WebElement secondProductName;
	
	@FindBy(xpath = "//input[@id='second']")
	private WebElement secondProductQuantity;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/p[2]")
	private WebElement secondProductSize;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/strong[1]")
	private WebElement shippingPrice;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/strong[1]")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//button[@id='empty-cart']")
	private WebElement emptyCartButton;
	
	@FindBy(xpath = "//button[contains(text(),'X')]")
	private WebElement closeWindowButton;
	
	@FindBy(xpath = "//a[@class='btn']")
	private WebElement checkoutButton;
	
	
	
	public CartWindow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getFirstProductName() {
		return firstProductName.getText();
	}
	
	public int getFirstProductQuantity() {
		return Integer.parseInt(firstProductQuantity.getAttribute("value"));
	}
	
	public String getFirstProductSize() {
		return firstProductSize.getText().trim();
	}
	
	public String getSecondProductName() {
		return secondProductName.getText();
	}
	
	public int getSecondProductQuantity() {
		return Integer.parseInt(secondProductQuantity.getAttribute("value"));
	}
	
	public String getSecondProductSize() {
		return secondProductSize.getText().trim();
	}
	
	
	public double getShippingPrice() {
		return Double.parseDouble(shippingPrice.getText().substring(1));
	}
	
	public double getTotalPrice() {
		return Double.parseDouble(totalPrice.getText().substring(1));
	}
	
	public void emptyCart() {
		emptyCartButton.click();
	}
	
	public void close() {
		closeWindowButton.click();
	}
	
	public void goToCheckout() {
		checkoutButton.click();
	}
}
