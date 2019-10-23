package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(css = "section#main h1")
    private WebElement myAccountElement;


    public MyAccountPage(WebDriver driver){
      // This call sets the WebElement fields.
      PageFactory.initElements(driver, this);
    }


    public String getMyAccountHeader(){
        return myAccountElement.getText();
    }

}
