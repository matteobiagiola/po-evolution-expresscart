package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestInvalidLoginWrongEmail extends BaseTest {

  @Test
  public void testInvalidLoginWrongLogin() {

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

    WebElement existingCustomerEmailAddressInput = driver.findElement(By.xpath("//input[@id='customerloginEmail']"));
    existingCustomerEmailAddressInput.sendKeys("wrong@test.it");
    WebElement passwordInput = driver.findElement(By.xpath("//input[@id='customerloginPassword']"));
    passwordInput.sendKeys("test");
    WebElement loginButton = driver.findElement(By.xpath("//button[@id='customerLogin']"));
    loginButton.click();

    notificationMessage = driver.findElement(By.xpath("//div[@id='notify_message']"));

    assertEquals(
            "A customer with that email does not exist.", notificationMessage.getText());
  }
}
