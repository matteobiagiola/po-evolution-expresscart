package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestEmptyCart extends BaseTest {

  @Test
  public void testEmptyCart() {

    WebElement greenJacketLink = driver.findElement(By.xpath("//h3[contains(text(),'Green Jacket')]"));
    greenJacketLink.click();
    WebElement increaseQuantityButton = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]"));
    increaseQuantityButton.click();
    WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'add to cart')]"));
    addToCartButton.click();
    WebElement notificationMessage = driver.findElement(By.xpath("//div[@id='notify_msg']"));
    assertEquals("Cart successfully updated", notificationMessage.getText());
    WebElement cartCount = driver.findElement(By.xpath("//span[@id='cart-count']"));
    assertEquals(2, Integer.parseInt(cartCount.getText()));

    WebElement cartIcon = driver.findElement(By.xpath("//a[@class='menu']"));
    cartIcon.click();

    WebElement emptyCartButton = driver.findElement(By.xpath("//button[@id='empty-cart']"));
    emptyCartButton.click();
    WebElement closeWindowButton = driver.findElement(By.xpath("//button[contains(text(),'X')]"));
    closeWindowButton.click();

    cartCount = driver.findElement(By.xpath("//span[@id='cart-count']"));
    assertEquals(0, Integer.parseInt(cartCount.getText()));
  }
}
