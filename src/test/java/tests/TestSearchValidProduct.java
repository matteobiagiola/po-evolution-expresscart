package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultsPage;
import utils.BaseTest;

public class TestSearchValidProduct extends BaseTest {

  @Test
  public void testSearchValidProduct() {
    HomePage homePage = new HomePage(driver);
    homePage.searchItem("jacket");
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    assertEquals("Green Jacket", searchResultsPage.getFirstResult());
    assertEquals("Orange Jacket", searchResultsPage.getSecondResult());
  }
}
