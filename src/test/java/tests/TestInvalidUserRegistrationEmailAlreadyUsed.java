package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestInvalidUserRegistrationEmailAlreadyUsed extends BaseTest {

  @Test
  public void testInvalidUserRegistrationEmailAlreadyUsed() throws InterruptedException {

    WebElement blueTShirtLink = driver.findElement(By.xpath("//h3[contains(text(),'Blue T-shirt')]"));
    blueTShirtLink.click();

    WebElement increaseQuantityButton = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]/button[1]"));
    increaseQuantityButton.click();
    increaseQuantityButton.click();
    WebElement largeSizeInput = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/label[1]/input[1]"));
    largeSizeInput.click();
    WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
    addToCartButton.click();

    WebElement notificationMessage = driver.findElement(By.xpath("//div[@id='notify_message']"));
    assertEquals("Cart successfully updated", notificationMessage.getText());

    WebElement cartIcon = driver.findElement(By.xpath("//a[@class='menu-btn']"));
    cartIcon.click();

    WebElement checkoutButton = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
    checkoutButton.click();

    WebElement payNowButton = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
    payNowButton.click();

    String randomEmail = "test@test.it";
    String firstName = "firstName";
    String lastName = "lastName";
    String firstAddress = "addr";
    String country = "country";
    String state = "state";
    String postCode = "1234";
    String phoneNumber = "123456789";
    String password = "password";

    WebElement newCustomerEmailAddressInput = driver.findElement(By.xpath("//input[@id=\"shipEmail\"]"));
    WebElement newCustomerFirstNameInput = driver.findElement(By.xpath("//input[@id=\"shipFirstname\"]"));
    WebElement newCustomerLastNameInput = driver.findElement(By.xpath("//input[@id=\"shipLastname\"]"));
    WebElement newCustomerAddress1Input = driver.findElement(By.xpath("//input[@id=\"shipAddr1\"]"));
    WebElement newCustomerCountryInput = driver.findElement(By.xpath("//input[@id=\"shipCountry\"]"));
    WebElement newCustomerStateInput = driver.findElement(By.xpath("//input[@id=\"shipState\"]"));
    WebElement newCustomerPostCodeInput = driver.findElement(By.xpath("//input[@id=\"shipPostcode\"]"));
    WebElement newCustomerPasswordInput = driver.findElement(By.xpath("//input[@id='newCustomerPassword']"));
    WebElement newCustomerPhoneNumberInput = driver.findElement(By.xpath("//input[@id=\"shipPhoneNumber\"]"));
    WebElement createAccountButton = driver.findElement(By.xpath("//a[@id='createCustomerAccount']"));

    newCustomerEmailAddressInput.sendKeys(randomEmail);
    newCustomerFirstNameInput.sendKeys(firstName);
    newCustomerLastNameInput.sendKeys(lastName);
    newCustomerAddress1Input.sendKeys(firstAddress);
    newCustomerCountryInput.sendKeys(country);
    newCustomerStateInput.sendKeys(state);
    newCustomerPostCodeInput.sendKeys(postCode);
    newCustomerPhoneNumberInput.sendKeys(phoneNumber);
    newCustomerPasswordInput.sendKeys(password);
    createAccountButton.click();

    notificationMessage = driver.findElement(By.xpath("//div[@id='notify_message']"));
    assertEquals("A customer already exists with that email address", notificationMessage.getText());

  }
}
