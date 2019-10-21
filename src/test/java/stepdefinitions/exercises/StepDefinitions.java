package stepdefinitions.exercises;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepDefinitions {

    private HomePage homePage;
    private WebDriver driver;

    public StepDefinitions(DriverManager driverManager){
        this.driver = driverManager.driver;
    }

    @Then( "^the product tags are visible$" )
    public void theTagsAreVisible(DataTable table) {
        homePage =  new HomePage(driver);

        List<String> expectedTags = table.asList(String.class);
        List<String> allAvailableTags = new ArrayList<String>();

        List<WebElement> allTags = homePage.getTagsBlock().findElements(By.tagName("a"));

        for (WebElement allTag : allTags) {
            allAvailableTags.add(allTag.getText());
        }

        int i =0;
        while (i < expectedTags.size()) {
            Assert.assertTrue(allAvailableTags.contains(expectedTags.get(i)));
            i++;
        }
    }

    @Then( "^the product tags are visible header example$" )
    public void theTagsAreVisibleHeaderExample(DataTable table) {
        homePage =  new HomePage(driver);

        List<Map<String, String>> expectedTags = table.asMaps(String.class, String.class);
        List<String> allAvailableTags = new ArrayList<String>();

        List<WebElement> allTags = homePage.getTagsBlock().findElements(By.tagName("a"));

        for (WebElement allTag : allTags) {
            allAvailableTags.add(allTag.getText());
        }

        int i =0;
        while (i < expectedTags.size()) {
            Assert.assertTrue(allAvailableTags.contains(expectedTags.get(i).get("Tags")));
            i++;
        }
    }

    @Given("^I search for \"([^\"]*)\"$")
    public void i_search_for(String searchInput) {
        // Write code here that turns the phrase above into concrete actions
        homePage =  new HomePage(driver);
        homePage.searchProduct(searchInput);
    }

    @Then("^I can see the stock availability of the products$")
    public void i_can_see_the_stock_availability_of_the_products(DataTable table) {
        homePage =  new HomePage(driver);

        List<Map<String, String>> expectedProducts = table.asMaps(String.class, String.class);

        List<WebElement> allProducts = homePage.getProducts();
        List<String> allProductNames = new ArrayList<String>();

        //get products from product container and store title
        for (WebElement product : allProducts) {
            allProductNames.add(product.getAttribute("title"));
        }

        //get stock texts from products and store in list
        List<WebElement> allStocks = homePage.getStocks();
        List<String> allStockTexts = new ArrayList<String>();

        for (WebElement stock : allStocks) {
            allStockTexts.add(stock.getText());
        }

        int i =0;
        while (i < expectedProducts.size()) {
            Assert.assertTrue(allProductNames.contains(expectedProducts.get(i).get("Product"))  && allStockTexts.contains(expectedProducts.get(i).get("Stock")) );
            i++;
        }
    }
}
