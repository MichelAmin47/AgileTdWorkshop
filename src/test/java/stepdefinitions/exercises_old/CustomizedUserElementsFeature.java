package stepdefinitions.exercises_old;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AuthenticationPage;
import pages.HomePage;
import stepdefinitions.exercises.DriverManager;


public class CustomizedUserElementsFeature {

    private WebDriver driver;
    private HomePage homePage;

    public CustomizedUserElementsFeature(DriverManager driverManager){
        this.driver = driverManager.driver;
    }

    @Given( "^I am on the Polteq Web Shop$" )
    public void iAmOnThePolteqWebShop() {
        // Open the website
        driver.get("https://techblog.polteq.com/testshop/index.php");

        driver.manage().window().maximize();

        Assert.assertTrue("Check if empty element is visible", driver.findElement(By.className("ajax_cart_no_product")).isDisplayed());
    }

    @When("^I log in$")
    public void i_log_in() throws InterruptedException {
        homePage =  new HomePage(driver);
        homePage.clickLogIn();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.login("tester@test.com", "1qazxsw2");
    }

    @Then("^I see my user name appear on top of the page$")
    public void i_see_my_user_name_appear_on_top_of_the_page() {
        homePage.goToHomePage();
        Assert.assertEquals("Account name is not as expected", "tester test", homePage.getAccountName());
    }

    @When("^I log in as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void i_log_in_as_with_password(String mail, String password){
        homePage =  new HomePage(driver);
        homePage.clickLogIn();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.login(mail, password);
    }

    @Then("^I see my user name \"([^\"]*)\" appear on top of the page$")
    public void i_see_my_user_name_appear_on_top_of_the_page(String expectedUser){
//        homePage.goToHomePage();
        Assert.assertEquals("Account name is not as expected", expectedUser, homePage.getAccountName());
    }

    @Given("^I am on the Polteq Web Shop logged in as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void iAmOnThePolteqWebShopLoggedInAsWithPassword(String arg0, String arg1) throws Throwable {
        iAmOnThePolteqWebShop();
        i_log_in_as_with_password(arg0, arg1);
    }
}
