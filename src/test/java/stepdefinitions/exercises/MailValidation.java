package stepdefinitions.exercises;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AuthenticationPage;
import pages.HomePage;

public class MailValidation {
    private WebDriver driver;
    private HomePage homePage;
    private AuthenticationPage authPage;

    public MailValidation(DriverManager driverManager){
        this.driver = driverManager.driver;
    }

    @When("^I create a new user with this mail address: \"([^\"]*)\"$")
    public void i_create_a_new_user_with_this_mail_address(String mailAddress) {
        homePage = new HomePage(driver);
        homePage.clickLogIn();
        authPage = new AuthenticationPage(driver);
        authPage.setNewUserMail(mailAddress);
    }

    @Then("^the mail address is marked \"([^\"]*)\"$")
    public void the_mail_address_is_marked(String expectedValidity) {

        switch (expectedValidity) {
            case "valid":
                Assert.assertTrue(authPage.isNewUserMailValid());
                break;
            case "invalid":
                Assert.assertFalse(authPage.isNewUserMailValid());
                break;
        }
    }
}
