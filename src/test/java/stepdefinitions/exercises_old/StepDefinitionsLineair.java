package stepdefinitions.exercises_old;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StepDefinitionsLineair {

    public WebDriver driver;
    private WebDriverWait myWaitVar;

    @Given( "^I am on the Polteq Webshop$" )
    public void iAmOnThePolteqWebshop() {
        // Create driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        myWaitVar = new WebDriverWait(driver,20);

        // Open the website
        driver.get("https://techblog.polteq.com/testshop/index.php");

        driver.manage().window().maximize();

        Assert.assertTrue("Check if empty element is visible", driver.findElement(By.className("ajax_cart_no_product")).isDisplayed());
    }

    @When( "^I go to the IPODS page$" )
    public void iGoToTheIPODSPage() {
        driver.findElement(By.cssSelector("a[title='More about ipod']")).click();
    }

    @And( "^I go to the iPod Nano detail page$" )
    public void iGoToTheIPodNanoDetailPage() {
        driver.findElement(By.xpath("//a[contains(text(),'iPod Nano')]")).click();
    }

    @And( "^I add the iPod Nano to the cart$" )
    public void iAddTheIPodNanoToTheCart() {
        driver.findElement(By.id("add_to_cart")).click();
    }

    @Then( "^I get a confirmation that the product is added to the shopping cart$" )
    public void iGetAConfirmationThatTheProductIsAddedToTheShoppingCart() {
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.icon-check")));
        Assert.assertTrue("Check if empty element is visible",
                driver.findElement(By.cssSelector("i.icon-check")).isDisplayed());
    }

    @But( "^I should not be taken directly to my shopping cart$" )
    public void iShouldNotBeTakenDirectlyToMyShoppingCart(){
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Proceed to checkout']")));
        Assert.assertTrue("Check if the button to be taken to the checkout is shown",
                driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).isDisplayed());
    }
}
