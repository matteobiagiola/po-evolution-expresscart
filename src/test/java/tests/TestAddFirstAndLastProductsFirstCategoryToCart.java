package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestAddFirstAndLastProductsFirstCategoryToCart extends BaseTest {

  @Test
  public void testAddFirstAndLastProductsFirstCategoryToCart() throws InterruptedException {
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
    double price1 = Double.parseDouble(productPrice.getText().substring(1));

    WebElement notificationMessage = driver.findElement(By.xpath("//div[@id='notify_message']"));
    assertEquals("Cart successfully updated", notificationMessage.getText());

    WebElement homePageNavbarButton = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
    homePageNavbarButton.click();

    WebElement greyTrousersLink = driver.findElement(By.xpath("//h3[contains(text(),'Grey Trousers')]"));
    greyTrousersLink.click();

    largeSizeInput = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/label[1]/input[1]"));
    largeSizeInput.click();
    addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
    addToCartButton.click();
    productPrice = driver.findElement(By.xpath("//h4[@class='col-md-10 product-price']"));
    double price2 = Double.parseDouble(productPrice.getText().substring(1));

    notificationMessage = driver.findElement(By.xpath("//div[@id='notify_message']"));
    assertEquals("Cart successfully updated", notificationMessage.getText());

    WebElement cartIcon = driver.findElement(By.xpath("//a[@class='menu-btn']"));
    cartIcon.click();

    WebElement firstProductName = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/p[1]/a[1]"));
    WebElement firstProductSize = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/p[2]"));
    WebElement firstProductQuantity = driver.findElement(By.xpath("//input[@id='0']"));
    WebElement secondProductName = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/p[1]/a[1]"));
    WebElement secondProductSize = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/p[2]"));
    WebElement secondProductQuantity = driver.findElement(By.xpath("//input[@id='1']"));

    assertEquals("Blue T-shirt", firstProductName.getText());
    assertEquals("L", firstProductSize.getText().trim());
    assertEquals(3, Integer.parseInt(firstProductQuantity.getAttribute("value")));
    assertEquals("Grey Trousers", secondProductName.getText());
    assertEquals("L", secondProductSize.getText().trim());
    assertEquals(1, Integer.parseInt(secondProductQuantity.getAttribute("value")));

    WebElement shippingPriceElement = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/strong[1]"));
    WebElement totalPriceElement = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/strong[1]"));

    double shippingPrice = Double.parseDouble(shippingPriceElement.getText().substring(1));
    double totalPrice = Double.parseDouble(totalPriceElement.getText().substring(1));

    firstProductQuantity = driver.findElement(By.xpath("//input[@id='0']"));
    secondProductQuantity = driver.findElement(By.xpath("//input[@id='1']"));

    assertEquals(
        price1 * Integer.parseInt(firstProductQuantity.getAttribute("value"))
            + price2 * Integer.parseInt(secondProductQuantity.getAttribute("value"))
            + shippingPrice,
        totalPrice,
        0.001);
  }
}
