package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.HomePage;
import utils.BaseTest;

public class TestSearchEmptyProduct extends BaseTest {

  @Test
  public void testSearchEmptyProduct() {
    HomePage homePage = new HomePage(driver);
    homePage.searchItem("");
    assertEquals("Please enter a search value", homePage.getNotificationMessage());
  }
}
