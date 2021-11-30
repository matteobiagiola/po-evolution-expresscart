package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.CartWindow;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import utils.BaseTest;

public class TestAddFirstAndLastProductsFirstCategoryToCart extends BaseTest {

  @Test
  public void testAddFirstAndLastProductsFirstCategoryToCart() throws InterruptedException {
    HomePage homePage = new HomePage(driver);
    homePage.selectBlueTShirt();
    // selectBlueTShirt

    ProductPage productPage = new ProductPage(driver);
    productPage.increaseQuantity();
    productPage.increaseQuantity();
    productPage.selectLargeSize();
    productPage.addToCart();
    double price1 = productPage.getProductPrice();

    assertEquals("Cart successfully updated", productPage.getNotificationMessage());

    productPage.goToHomePage();

    homePage.selectGreyTrousers();

    productPage.selectLargeSize();
    productPage.addToCart();
    double price2 = productPage.getProductPrice();

    assertEquals("Cart successfully updated", productPage.getNotificationMessage());

    productPage.openCart();

    CartWindow cartWindow = new CartWindow(driver);
    assertEquals("Blue T-shirt", cartWindow.getFirstProductName());
    assertEquals("L", cartWindow.getFirstProductSize());
    assertEquals(3, cartWindow.getFirstProductQuantity());
    assertEquals("Grey Trousers", cartWindow.getSecondProductName());
    assertEquals("L", cartWindow.getSecondProductSize());
    assertEquals(1, cartWindow.getSecondProductQuantity());

    double shippingPrice = cartWindow.getShippingPrice();
    double totalPrice = cartWindow.getTotalPrice();

    assertEquals(
        price1 * cartWindow.getFirstProductQuantity()
            + price2 * cartWindow.getSecondProductQuantity()
            + shippingPrice,
        totalPrice,
        0.001);
  }
}
