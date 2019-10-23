package pages;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import java.util.List;

public class AuthenticationPage{
    private WebDriver driver;

    @FindBy(css = "form#login-form input[type='email'] ")
    private WebElement emailTextfield;

    @FindBy(css = "form#login-form input[type='password'] ")
    private WebElement passwordTextfield;

    @FindBy(css = "form#login-form button[type='submit'] ")
    private WebElement loginButton;

    //-----old------
    @FindBy(css = ".form-group.form-error #email")
    private WebElement invalidEmail;

    @FindBy(css = "[for='email_create'] + [type='email']")
    private WebElement newUserMail;

    @FindBy(css = "button#SubmitLogin")
    private WebElement createNewUserButton;


    public AuthenticationPage(WebDriver driver) {
      this.driver = driver;

      // This call sets the WebElement fields.
      PageFactory.initElements(driver, this);
    }

    public void fillInEmail(String email){
        emailTextfield.sendKeys(email);
    }

    public void fillInPassword(String password){
        passwordTextfield.sendKeys(password);
    }

    public void clickSubmitButton(){
        loginButton.click();
    }

    public void setNewUserMail(String mail){
        newUserMail.sendKeys(mail);
        newUserMail.sendKeys(Keys.TAB);
    }

    public void clickCreateNewUser(){
        createNewUserButton.click();
    }

    public boolean isNewUserMailValid(){
        List<WebElement> okElements = driver.findElements(By.cssSelector("[id='create-account_form'] [class='form-group form-ok']"));
        List<WebElement> errorElements = driver.findElements(By.cssSelector("[id='create-account_form'] [class='form-group form-error']"));
        System.out.println(okElements.size());
        System.out.println(errorElements.size());
        if(okElements.size() > 0){
            return true;
        }
        if (errorElements.size() >0){
            return false;
        }
        else{
            Assert.assertTrue("The new user mail field cannot be found" , false);
            return false;
        }
    }

    public void login(String email, String password) {
      emailTextfield.sendKeys(email);
      passwordTextfield.sendKeys(password);
      loginButton.click();
    }
}

