package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestAddFirstProductFirstCategoryToCartNegativeQuantity extends BaseTest {

  @Test
  public void testAddFirstProductFirstCategoryToCartNegativeQuantity() throws InterruptedException {

    WebElement blueTShirtLink = driver.findElement(By.xpath("//h3[contains(text(),'Blue t-shirt')]"));
    blueTShirtLink.click();

    WebElement decreaseQuantityButton = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]"));
    decreaseQuantityButton.click();
    decreaseQuantityButton.click();
    decreaseQuantityButton.click();
    WebElement largeSizeInput = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/input[1]"));
    largeSizeInput.click();
    WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'add to cart')]"));
    addToCartButton.click();

    WebElement notificationMessage = driver.findElement(By.xpath("//div[@id='notify_msg']"));
    assertEquals("Cart successfully updated", notificationMessage.getText());

    WebElement cartCount = driver.findElement(By.xpath("//span[@id='cart-count']"));
    assertEquals(0, Integer.parseInt(cartCount.getText()));
  }
}
