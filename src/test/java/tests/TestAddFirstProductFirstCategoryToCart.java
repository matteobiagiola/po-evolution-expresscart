package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestAddFirstProductFirstCategoryToCart extends BaseTest {

  @Test
  public void testAddFirstProductFirstCategoryToCart() throws InterruptedException {

    WebElement blueTShirtLink = driver.findElement(By.xpath("//h3[contains(text(),'Blue T-shirt')]"));
    blueTShirtLink.click();

    WebElement increaseQuantityButton = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]/button[1]"));
    increaseQuantityButton.click();
    increaseQuantityButton.click();
    WebElement largeSizeInput = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/label[1]/input[1]"));
    largeSizeInput.click();
    WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
    addToCartButton.click();

    WebElement productPrice = driver.findElement(By.xpath("//h4[@class='col-md-10 product-price']"));
    double price = Double.parseDouble(productPrice.getText().substring(1));

    WebElement notificationMessage = driver.findElement(By.xpath("//div[@id='notify_message']"));
    assertEquals("Cart successfully updated", notificationMessage.getText());

    WebElement cartIcon = driver.findElement(By.xpath("//a[@class='menu-btn']"));
    cartIcon.click();

    WebElement firstProductName = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/p[1]/a[1]"));
    WebElement firstProductSize = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/p[2]"));
    WebElement firstProductQuantity = driver.findElement(By.xpath("//input[@id='0']"));

    assertEquals("Blue T-shirt", firstProductName.getText());
    assertEquals("L", firstProductSize.getText().trim());
    assertEquals(3, Integer.parseInt(firstProductQuantity.getAttribute("value")));

    WebElement shippingPriceElement = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/strong[1]"));
    WebElement totalPriceElement = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/strong[1]"));

    double shippingPrice = Double.parseDouble(shippingPriceElement.getText().substring(1));
    double totalPrice = Double.parseDouble(totalPriceElement.getText().substring(1));

    assertEquals(price * Integer.parseInt(firstProductQuantity.getAttribute("value")) + shippingPrice,
            totalPrice, 0.001);
  }
}
