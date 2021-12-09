package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestSearchProductNotPresent extends BaseTest {

  @Test
  public void testSearchProductNotPresent() {
    WebElement searchInput = driver.findElement(By.xpath("//input[@id='search']"));
    WebElement searchButton = driver.findElement(By.xpath("//button[@id='button_search']"));

    searchInput.sendKeys("test");
    searchButton.click();

    WebElement errorMessage = driver.findElement(By.xpath("//p[@class='txt-danger']"));
    assertEquals("No products found", errorMessage.getText());
  }
}
