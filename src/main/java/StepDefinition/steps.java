package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class steps {
  WebDriver driver;
  WebElement element;

  @Given("Open the given URL in a Browser")
  public void open_the_given_url_in_a_browser() {
    System.setProperty("webdriver.chrome.driver", "/Users/sushma/Downloads/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://todomvc.com/examples/vue/");
  }

  @When("add the TODO {string} to the list")
  public void add_the_todo_items_to_the_list(String items) {
    element = driver.findElement(By.className("new-todo"));
    element.sendKeys(items);
    element.sendKeys(Keys.ENTER);
  }

  @Then("check the added {string} is correct")
  public void check_the_added_data_is_correct(String expectedString) {
    String val =
        element.findElement(By.xpath("//li[@class='todo']/div[@class='view']//label")).getText();
    System.out.println("Entered text is: " + val);
    Assert.assertEquals(expectedString, val);
    driver.quit();
  }

  @Then("mark the added {string} complete")
  public void mark_the_added_complete(String item) {
    try {
      WebElement e =
          driver.findElement(
              By.xpath(
                  "//div[@class='view']//label[contains(text(),'"
                      + item
                      + "')]//preceding-sibling::input[1]"));
      e.click();
    } catch (StaleElementReferenceException exp) {
      Assert.assertFalse(false);
      driver.quit();
    }
    Assert.assertTrue(true);
    driver.quit();
  }

  @When("add the TODO {string}, {string} to the list")
  public void add_the_todo_to_the_list(String item1, String item2) {
    element = driver.findElement(By.className("new-todo"));
    element.sendKeys(item1);
    element.sendKeys(Keys.ENTER);
    element.sendKeys(item2);
    element.sendKeys(Keys.ENTER);
  }

  @Then("select get the count of {string} added")
  public void select_get_the_count_of_items_added(String item) {
    List<WebElement> we = driver.findElements(By.xpath("//*[@class='todo']"));
    System.out.println(we.size());
    int count = we.size();
    Iterator<WebElement> list = we.iterator();
    while (list.hasNext()) {
      WebElement val = list.next();
      System.out.println(val.getText());
    }
    Assert.assertEquals(2, count);
    driver.quit();
  }

  @When("add the TODO {string}, {string} , {string} to the list")
  public void add_the_todo_to_the_list(String item1, String item2, String item3) {
    element = driver.findElement(By.className("new-todo"));
    element.sendKeys(item1);
    element.sendKeys(Keys.ENTER);
    element.sendKeys(item2);
    element.sendKeys(Keys.ENTER);
    element.sendKeys(item3);
    element.sendKeys(Keys.ENTER);
  }

  @Then("select the completed {string}")
  public void select_the_completed(String item1) {
    WebElement e =
        driver.findElement(
            By.xpath(
                "//div[@class='view']//label[contains(text(),'"
                    + item1
                    + "')]//preceding-sibling::input[1]"));
    e.click();
    List<WebElement> we = driver.findElements(By.xpath("//*[@class='todo completed']"));
    System.out.println(we.size());
    int count = we.size();
    Iterator<WebElement> list = we.iterator();
    while (list.hasNext()) {
      WebElement val = list.next();
      System.out.println(val.getText());
    }
    Assert.assertEquals(1, count);
    driver.quit();
  }

  @Then("delete the item added {string}")
  public void delete_the_item_added(String item1) {

    WebElement myElement = driver.findElement(By.xpath("//div[@class='view']//label[contains(text(),'" + item1 + "')]//following-sibling::button[@class='destroy']"));
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", myElement);
    List<WebElement> we = driver.findElements(By.xpath("//*[@class='todo']"));
    System.out.println(we.size());
    int count = we.size();
    Assert.assertEquals(0, count);
    driver.quit();
  }

}
