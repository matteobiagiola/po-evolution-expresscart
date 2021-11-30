package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import utils.BaseTest;

public class TestAddFirstProductFirstCategoryToCartNegativeQuantity extends BaseTest {

  @Test
  public void testAddFirstProductFirstCategoryToCartNegativeQuantity() throws InterruptedException {
    HomePage homePage = new HomePage(driver);
    homePage.selectBlueTShirt();

    ProductPage productPage = new ProductPage(driver);
    productPage.decreaseQuantity();
    productPage.decreaseQuantity();
    productPage.decreaseQuantity();
    productPage.selectLargeSize();
    productPage.addToCart();

    assertEquals("Cart successfully updated", productPage.getNotificationMessage());
    assertEquals(0, productPage.getCartCount());
  }
}
