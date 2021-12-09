package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestInvalidLoginWrongEmail extends BaseTest {

  @Test
  public void testInvalidLoginWrongLogin() {

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

    WebElement existingCustomerEmailAddressInput = driver.findElement(By.xpath("//input[@id='customerLoginEmail']"));
    existingCustomerEmailAddressInput.sendKeys("wrong@test.it");
    WebElement passwordInput = driver.findElement(By.xpath("//input[@id='customerLoginPassword']"));
    passwordInput.sendKeys("test");
    WebElement loginButton = driver.findElement(By.xpath("//button[@id='customerLogin']"));
    loginButton.click();

    notificationMessage = driver.findElement(By.xpath("//div[@id='notify_message']"));

    assertEquals(
            "A customer with that email does not exist.", notificationMessage.getText());
  }
}
