package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[5]/div[1]/input[1]")
	@FindBy(xpath = "//input[@id='frm_search']")
	private WebElement searchInput;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[5]/div[1]/span[1]/button[1]")
	@FindBy(xpath = "//button[@id='btn_search']")
	private WebElement searchButton;

//	@FindBy(xpath = "/html[1]/body[1]/div[4]")
	@FindBy(xpath = "//div[@id='notify_message']")
	private WebElement notificationMessage;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/h3[1]")
	@FindBy(xpath = "//h3[contains(text(),'Blue T-shirt')]")
	private WebElement blueTShirtLink;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/a[1]/h3[1]")
	@FindBy(xpath = "//h3[contains(text(),'Grey Trousers')]")
	private WebElement greyTrousersLink;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/h3[1]")
	@FindBy(xpath = "//h3[contains(text(),'Green Jacket')]")
	private WebElement greenJacketLink;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
	@FindBy(xpath = "//a[@href='/category/T-shirt']")
	private WebElement tShirtNavbarLink;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
	@FindBy(xpath = "//a[contains(text(),'Jacket')]")
	private WebElement jacketNavbarLink;
	
//	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")
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
