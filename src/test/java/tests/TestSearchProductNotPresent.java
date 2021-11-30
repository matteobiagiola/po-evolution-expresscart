package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultsPage;
import utils.BaseTest;

public class TestSearchProductNotPresent extends BaseTest {

  @Test
  public void testSearchProductNotPresent() {
    HomePage homePage = new HomePage(driver);
    homePage.searchItem("test");
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    assertEquals("No products found", searchResultsPage.getErrorMessage());
  }
}
