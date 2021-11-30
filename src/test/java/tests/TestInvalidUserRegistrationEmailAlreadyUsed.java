package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import pageobjects.*;
import utils.BaseTest;
import utils.FunctionalUtilities;

public class TestInvalidUserRegistrationEmailAlreadyUsed extends BaseTest {

  @Test
  public void testInvalidUserRegistrationEmailAlreadyUsed() throws InterruptedException {

    /* start added by authors */
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
    String randomEmail = "test@test.it";
    String firstName = "firstName";
    String lastName = "lastName";
    String firstAddress = "addr";
    String country = "country";
    String state = "state";
    String postCode = "1234";
    String phoneNumber = "123456789";
    String password = "password";
    paymentPage.insertNewCustomerEmail(randomEmail);
    paymentPage.insertFirstName(firstName);
    paymentPage.insertLastName(lastName);
    paymentPage.insertAddress1(firstAddress);
    paymentPage.insertCountry(country);
    paymentPage.insertState(state);
    paymentPage.insertPostCode(postCode);
    paymentPage.insertPhoneNumber(phoneNumber);
    paymentPage.insertNewCustomerPassword(password);
    paymentPage.createAccount();

    assertEquals("A customer already exists with that email address", paymentPage.getNotificationMessage());
    /* end added by authors */

  }
}
