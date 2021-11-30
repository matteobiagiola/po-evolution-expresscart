package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.CartWindow;
import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.PaymentPage;
import pageobjects.ProductPage;
import utils.BaseTest;

public class TestValidLogin extends BaseTest {

  @Test
  public void testValidLogin() {
    HomePage homePage = new HomePage(driver);
    homePage.selectBlueTShirt();

    ProductPage productPage = new ProductPage(driver);
    productPage.increaseQuantity();
    productPage.increaseQuantity();
    productPage.selectLargeSize();
    productPage.addToCart();

    assertEquals("Cart successfully updated", productPage.getNotificationMessage());

    productPage.openCart();
    CartWindow cartWindow = new CartWindow(driver);

    cartWindow.goToCheckout();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    checkoutPage.goToPaymentPage();

    PaymentPage paymentPage = new PaymentPage(driver);
    paymentPage.insertExistingCustomerEmail("test@test.it");
    paymentPage.insertPassword("test");
    paymentPage.login();

    assertEquals("test@test.it", paymentPage.getCustomerDetailsEmailAddress());
  }
}
