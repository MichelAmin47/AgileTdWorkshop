package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage {

    private WebDriver driver;

    By logInButton = By.cssSelector("a[title*='Log']");

    //---old-----
    @FindBy(css = "li#header_link_contact > a")
    private WebElement contactButton;

    @FindBy(css = "[title='Home']")
    private WebElement homeButton;

    @FindBy(css = "[name='search_query']")
    private WebElement searchField;

    @FindBy(css = "[name='submit_search']")
    private WebElement submitSearch;

    @FindBy(css = "#tags_block_left > div")
    private WebElement tagContainer;

    By accountDetailsButton = By.cssSelector("[class='account']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        // This call sets the WebElement fields.
        PageFactory.initElements(driver, this);
    }

    public void clickContactUS(){
        contactButton.click();
    }

    public void clickLogIn(){
        driver.findElement(logInButton).click();
    }

    public void goToHomePage(){
        homeButton.click();
    }

    public String getAccountName(){
       List<WebElement> el =  driver.findElements(accountDetailsButton);
       if (el.size() != 0) {
           for (WebElement element : el) {
               return element.getText();
           }
       }
            return "account details button is not present on the page";
    }
}
