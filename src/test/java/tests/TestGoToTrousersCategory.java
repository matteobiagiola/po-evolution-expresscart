package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultsPage;
import utils.BaseTest;

public class TestGoToTrousersCategory extends BaseTest {

  @Test
  public void testSwitchToThirdCategory() {
    HomePage homePage = new HomePage(driver);
    homePage.goToTrousersCategory();
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    assertEquals("Men's Jeans", searchResultsPage.getFirstResult());
    assertEquals("Women's Jeans", searchResultsPage.getSecondResult());
    assertEquals("Grey Trousers", searchResultsPage.getThirdResult());
  }
}
