package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestGoToTShirtCategory extends BaseTest {

  @Test
  public void testGoToTShirtCategory() {

    WebElement tShirtNavbarLink = driver.findElement(By.xpath("//a[@href='/category/T-shirt']"));
    tShirtNavbarLink.click();

    WebElement firstResult = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/h3[1]"));
    WebElement secondResult = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]/h3[1]"));
    assertEquals("Blue T-shirt", firstResult.getText());
    assertEquals("Black T-shirt", secondResult.getText());
  }
}
