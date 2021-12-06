package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	private WebDriver driver;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h3[1]")
	private WebElement firstResult;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/a[1]/h3[1]")
	private WebElement secondResult;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/a[1]/h3[1]")
	private WebElement thirdResult;
	
	@FindBy(xpath = "//p[@class='txt-danger']")
	private WebElement errorMessage;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getFirstResult() {
		return firstResult.getText();
	}
	
	public String getSecondResult() {
		return secondResult.getText();
	}
	
	public String getThirdResult() {
		return thirdResult.getText();
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
