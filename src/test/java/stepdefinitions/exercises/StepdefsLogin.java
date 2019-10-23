package stepdefinitions.exercises;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    public void userIsOnTheHomepage() {
        // Open the website
        driver.get("https://webshop.mobiletestautomation.nl/");
        driver.manage().window().maximize();
        Assert.assertTrue("Check if empty element is visible", driver.findElement(By.className("logo")).isDisplayed());
    }

    @When("User clicks login button")
    public void userClicksLoginButton() {
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
    public void myaccountElementsVisible() {
        myAccountPage = new MyAccountPage(driver);
        Assert.assertEquals("Account text is not visible", "Your account", myAccountPage.getMyAccountHeader());
    }
}
