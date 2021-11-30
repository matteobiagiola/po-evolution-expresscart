package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.CartWindow;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import utils.BaseTest;

public class TestEmptyCart extends BaseTest {

  @Test
  public void testEmptyCart() {
    HomePage homePage = new HomePage(driver);
    homePage.selectGreenJacket();

    ProductPage productPage = new ProductPage(driver);
    productPage.increaseQuantity();
    productPage.addToCart();

    assertEquals("Cart successfully updated", productPage.getNotificationMessage());
    assertEquals(2, productPage.getCartCount());

    productPage.openCart();
    CartWindow cartWindow = new CartWindow(driver);
    cartWindow.emptyCart();
    cartWindow.close();

    assertEquals(0, productPage.getCartCount());
  }
}
