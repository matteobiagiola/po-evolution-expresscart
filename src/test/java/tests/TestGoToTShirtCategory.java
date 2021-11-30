package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultsPage;
import utils.BaseTest;

public class TestGoToTShirtCategory extends BaseTest {

  @Test
  public void testGoToTShirtCategory() {
    HomePage homePage = new HomePage(driver);
    homePage.goToTShirtCategory();
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    assertEquals("Blue T-shirt", searchResultsPage.getFirstResult());
    assertEquals("Black T-shirt", searchResultsPage.getSecondResult());
  }
}
