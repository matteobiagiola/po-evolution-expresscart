package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;
import utils.FunctionalUtilities;

public class TestValidUserRegistration extends BaseTest {

  @Test
  public void testValidUserRegistration() throws InterruptedException {

    WebElement blueTShirtLink = driver.findElement(By.xpath("//h3[contains(text(),'Blue t-shirt')]"));
    blueTShirtLink.click();

    WebElement increaseQuantityButton = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]"));
    increaseQuantityButton.click();
    increaseQuantityButton.click();
    WebElement largeSizeInput = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/input[1]"));
    largeSizeInput.click();
    WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'add to cart')]"));
    addToCartButton.click();

    WebElement notificationMessage = driver.findElement(By.xpath("//div[@id='notify_msg']"));
    assertEquals("Cart successfully updated", notificationMessage.getText());

    WebElement cartIcon = driver.findElement(By.xpath("//a[@class='menu']"));
    cartIcon.click();

    WebElement checkoutButton = driver.findElement(By.xpath("//a[@class='btn']"));
    checkoutButton.click();

    WebElement payNowButton = driver.findElement(By.xpath("//a[@class='btn-default']"));
    payNowButton.click();

    String randomEmail = FunctionalUtilities.getRandomEmail();
    String firstName = "firstName";
    String lastName = "lastName";
    String firstAddress = "addr";
    String country = "country";
    String state = "state";
    String postCode = "1234";
    String phoneNumber = "123456789";
    String password = "password";

    WebElement newCustomerEmailAddressInput = driver.findElement(By.xpath("//input[@id=\"shipemail\"]"));
    WebElement newCustomerFirstNameInput = driver.findElement(By.xpath("//input[@id=\"shipFirstname\"]"));
    WebElement newCustomerLastNameInput = driver.findElement(By.xpath("//input[@id=\"shipLastname\"]"));
    WebElement newCustomerAddress1Input = driver.findElement(By.xpath("//input[@id=\"shipAddr1\"]"));
    WebElement newCustomerCountryInput = driver.findElement(By.xpath("//input[@id=\"shipCountry\"]"));
    WebElement newCustomerStateInput = driver.findElement(By.xpath("//input[@id=\"shipState\"]"));
    WebElement newCustomerPostCodeInput = driver.findElement(By.xpath("//input[@id=\"shipPostcode\"]"));
    WebElement newCustomerPasswordInput = driver.findElement(By.xpath("//input[@id='newCustomerPassword']"));
    WebElement createAccountButton = driver.findElement(By.xpath("//a[@id='createCustomerAccount']"));

    newCustomerEmailAddressInput.sendKeys(randomEmail);
    newCustomerFirstNameInput.sendKeys(firstName);
    newCustomerLastNameInput.sendKeys(lastName);
    newCustomerAddress1Input.sendKeys(firstAddress);
    newCustomerCountryInput.sendKeys(country);
    newCustomerStateInput.sendKeys(state);
    newCustomerPostCodeInput.sendKeys(postCode);
    newCustomerPasswordInput.sendKeys(password);
    createAccountButton.click();

    newCustomerEmailAddressInput = driver.findElement(By.xpath("//input[@id=\"shipemail\"]"));
    newCustomerFirstNameInput = driver.findElement(By.xpath("//input[@id=\"shipFirstname\"]"));
    newCustomerLastNameInput = driver.findElement(By.xpath("//input[@id=\"shipLastname\"]"));
    newCustomerAddress1Input = driver.findElement(By.xpath("//input[@id=\"shipAddr1\"]"));
    newCustomerCountryInput = driver.findElement(By.xpath("//input[@id=\"shipCountry\"]"));
    newCustomerStateInput = driver.findElement(By.xpath("//input[@id=\"shipState\"]"));
    newCustomerPostCodeInput = driver.findElement(By.xpath("//input[@id=\"shipPostcode\"]"));
    WebElement newCustomerPhoneNumberInput = driver.findElement(By.xpath("//input[@id=\"shipPhoneNumber\"]"));

    assertEquals(randomEmail, newCustomerEmailAddressInput.getAttribute("value"));
    assertEquals(firstName, newCustomerFirstNameInput.getAttribute("value"));
    assertEquals(lastName, newCustomerLastNameInput.getAttribute("value"));
    assertEquals(firstAddress, newCustomerAddress1Input.getAttribute("value"));
    assertEquals(firstAddress, newCustomerAddress1Input.getAttribute("value"));
    assertEquals(country, newCustomerCountryInput.getAttribute("value"));
    assertEquals(state, newCustomerStateInput.getAttribute("value"));
    assertEquals(postCode, newCustomerPostCodeInput.getAttribute("value"));
    assertEquals(phoneNumber, newCustomerPhoneNumberInput.getAttribute("value"));
  }
}
