package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	private WebDriver driver;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
	private WebElement increaseQuantityButton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")
	private WebElement decreaseQuantityButton;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/input[1]")
	private WebElement largeSizeInput;
	
	@FindBy(xpath = "//div[@id='notify_msg']")
	private WebElement notificationMessage;
	
	@FindBy(xpath = "//button[contains(text(),'add to cart')]")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//a[@class='menu']")
	private WebElement cartIcon;
	
	@FindBy(xpath = "//h4[@class='col-md-5 product-price']")
	private WebElement productPrice;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement homePageNavbarButton;
	
	@FindBy(xpath = "//span[@id='cart-count']")
	private WebElement cartCount;
	
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void increaseQuantity() {
		increaseQuantityButton.click();
	}
	
	public void decreaseQuantity() {
		decreaseQuantityButton.click();
	}
	
	public void selectLargeSize() {
		largeSizeInput.click();
	}
	
	public String getNotificationMessage() {
		return notificationMessage.getText();
	}
	
	public void addToCart() {
		addToCartButton.click();
	}
	
	public void openCart() {
		cartIcon.click();
	}
	
	public double getProductPrice() {
		return Double.parseDouble(productPrice.getText().substring(1));
	}
	
	public void goToHomePage() {
		homePageNavbarButton.click();
	}
	
	public int getCartCount() {
		return Integer.parseInt(cartCount.getText());
	}
}
