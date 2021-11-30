package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.CartWindow;
import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.PaymentPage;
import pageobjects.ProductPage;
import utils.BaseTest;

public class TestInvalidLoginWrongEmail extends BaseTest {

  @Test
  public void testInvalidLoginWrongLogin() {
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
    paymentPage.insertExistingCustomerEmail("wrong@test.it");
    paymentPage.insertPassword("test");
    paymentPage.login();

    assertEquals(
        "A customer with that email does not exist.", paymentPage.getNotificationMessage());
  }
}
