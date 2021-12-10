package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class TestGoToJacketCategory extends BaseTest {

  @Test
  public void testSwitchToSecondCategory() {

    WebElement jacketNavbarLink = driver.findElement(By.xpath("//a[contains(text(),'Jacket')]"));
    jacketNavbarLink.click();

    WebElement firstResult = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h3[1]"));
    WebElement secondResult = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/a[1]/h3[1]"));
    assertEquals("Green Jacket", firstResult.getText());
    assertEquals("Orange Jacket", secondResult.getText());
  }
}
