package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchInput;
	
	@FindBy(xpath = "//button[@id='button_search']")
	private WebElement searchButton;

	@FindBy(xpath = "//div[@id='notification_message']")
	private WebElement notificationMessage;
	
	@FindBy(xpath = "//h3[contains(text(),'Blue t-shirt')]")
	private WebElement blueTShirtLink;
	
	@FindBy(xpath = "//h3[contains(text(),'Grey Trousers')]")
	private WebElement greyTrousersLink;
	
	@FindBy(xpath = "//h3[contains(text(),'Green Jacket')]")
	private WebElement greenJacketLink;
	
	@FindBy(xpath = "//a[@href='/category/t-shirt']")
	private WebElement tShirtNavbarLink;
	
	@FindBy(xpath = "//a[contains(text(),'Jacket')]")
	private WebElement jacketNavbarLink;
	
	@FindBy(xpath = "//a[contains(text(),'Trousers')]")
	private WebElement trousersNavbarLink;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchItem(String query) {
		searchInput.sendKeys(query);
		searchButton.click();
	}
	
	public String getNotificationMessage() {
		return notificationMessage.getText();
	}
	
	public void selectBlueTShirt() {
		blueTShirtLink.click();
	}
	
	public void selectGreyTrousers() {
		greyTrousersLink.click();
	}
	
	public void selectGreenJacket() {
		greenJacketLink.click();
	}
	
	public void goToTShirtCategory() {
		tShirtNavbarLink.click();
	}
	
	public void goToJacketCategory() {
		jacketNavbarLink.click();
	}
	
	public void goToTrousersCategory() {
		trousersNavbarLink.click();
	}
}
