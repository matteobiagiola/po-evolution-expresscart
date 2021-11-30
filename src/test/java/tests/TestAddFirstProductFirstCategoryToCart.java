package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.CartWindow;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import utils.BaseTest;

public class TestAddFirstProductFirstCategoryToCart extends BaseTest {

  @Test
  public void testAddFirstProductFirstCategoryToCart() throws InterruptedException {
    HomePage homePage = new HomePage(driver);
    homePage.selectBlueTShirt();

    ProductPage productPage = new ProductPage(driver);
    productPage.increaseQuantity();
    productPage.increaseQuantity();
    productPage.selectLargeSize();
    productPage.addToCart();

    assertEquals("Cart successfully updated", productPage.getNotificationMessage());

    double productPrice = productPage.getProductPrice();
    productPage.openCart();

    CartWindow cartWindow = new CartWindow(driver);
    assertEquals("Blue T-shirt", cartWindow.getFirstProductName());
    assertEquals("L", cartWindow.getFirstProductSize());
    assertEquals(3, cartWindow.getFirstProductQuantity());

    double shippingPrice = cartWindow.getShippingPrice();
    double totalPrice = cartWindow.getTotalPrice();

    assertEquals(
        productPrice * cartWindow.getFirstProductQuantity() + shippingPrice, totalPrice, 0.001);
  }
}
