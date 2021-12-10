package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestGoToTrousersCategory extends BaseTest {

  @Test
  public void testSwitchToThirdCategory() {

    WebElement trousersNavbarLink = driver.findElement(By.xpath("//a[contains(text(),'Trousers')]"));
    trousersNavbarLink.click();

    WebElement firstResult = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/h3[1]"));
    WebElement secondResult = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]/h3[1]"));
    WebElement thirdResult = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/a[1]/h3[1]"));
    assertEquals("Men's Jeans", firstResult.getText());
    assertEquals("Women's Jeans", secondResult.getText());
    assertEquals("Grey Trousers", thirdResult.getText());
  }
}
