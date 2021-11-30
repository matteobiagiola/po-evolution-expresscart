package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.CartWindow;
import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.PaymentPage;
import pageobjects.ProductPage;
import utils.BaseTest;
import utils.FunctionalUtilities;

public class TestValidUserRegistration extends BaseTest {

  @Test
  public void testValidUserRegistration() throws InterruptedException {
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
    String randomEmail = FunctionalUtilities.getRandomEmail();
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

    /* start added by authors */
    assertEquals(randomEmail, paymentPage.getLoggedCustomerShipEmailAddress());
    assertEquals(firstName, paymentPage.getLoggedCustomerShipFirstName());
    assertEquals(lastName, paymentPage.getLoggedCustomerShipLastName());
    assertEquals(firstAddress, paymentPage.getLoggedCustomerShipFirstAddress());
    assertEquals(firstAddress, paymentPage.getLoggedCustomerShipSecondAddress());
    assertEquals(country, paymentPage.getLoggedCustomerShipCountry());
    assertEquals(state, paymentPage.getLoggedCustomerShipState());
    assertEquals(postCode, paymentPage.getLoggedCustomerShipPostCode());
    assertEquals(phoneNumber, paymentPage.getLoggedCustomerShipPhoneNumber());
    /* end added by authors */



  }
}
