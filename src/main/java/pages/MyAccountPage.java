package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private WebDriver driver;

    By myAccountElement = By.cssSelector("section#main h1");

    By AddFirstAddressButton = By.cssSelector("a#address-link span.link-item");


    public MyAccountPage(WebDriver driver){
      this.driver = driver;
    }

    public String getMyAccountHeader(){
        return driver.findElement(myAccountElement).getText();
    }

    public void clickToAddFirstAddres(){
        driver.findElement(AddFirstAddressButton).click();
    }

}
