package stepdefinitions.exercises;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

public class StepdefsLogin {

    private WebDriver driver;
    private HomePage homePage;
    private AuthenticationPage authenticationPage;
    private MyAccountPage myAccountPage;

    public StepdefsLogin(DriverManager driverManager){
        this.driver = driverManager.driver;
        authenticationPage = new AuthenticationPage(driver);
    }


    @Given("User is on the homepage")
    @And("The user is on the homepage")
    public void userIsOnTheHomepage() {
        // Open the website
        driver.get("https://webshop.mobiletestautomation.nl/");
        driver.manage().window().maximize();
        Assert.assertTrue("Check if empty element is visible",
                driver.findElement(By.className("logo")).isDisplayed());
    }

    @When("User clicks sign in button")
    public void userClicksSignInButton() {
        homePage = new HomePage(driver);
        homePage.clickLogIn();
    }

    @And("User fills in email")
    public void userFillsInEmail() {
        authenticationPage.fillInEmail("test@tester.com");
    }

    @And("User fills in password")
    public void userFillsInPassword() {
        authenticationPage.fillInPassword("1qazxsw2");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        authenticationPage.clickSubmitButton();
    }

    @Then("MyAccount elements visible")
    @And("The user should be taken to his Account page")
    public void myaccountElementsVisible() {
        // Exercise 2 code here please
    }

    @When("The user logs into his MyAccount")
    public void theUserLogsIntoHisMyAccount() {
        // Exercise 2 code here please
    }

    @When("The user logs into his MyAccount with \"([^\"]*)\" and \"([^\"]*)\" as credentials")
    public void theUserLogsIntoHisMyAccountWithAndAsCredentials(String email, String password) {
        // Exercise 2 code here please
    }
}
