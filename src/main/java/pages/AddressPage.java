package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage {

    private WebDriver driver;

    By newAddressHeader = By.cssSelector("header.page-header h1");
    By aliasField = By.cssSelector("input[name='alias']");
    By firstNameField = By.cssSelector("input[name='firstname']");
    By lastNameField = By.cssSelector("input[name='lastname']");
    By companyField = By.cssSelector("input[name='company']");
    By vATField = By.cssSelector("input[name='vat_number']");
    By addressField = By.cssSelector("input[name='address1']");
    By addressComplementField = By.cssSelector("input[name='address2']");
    By postalCodeField = By.cssSelector("input[name='postcode']");
    By cityField = By.cssSelector("input[name='city']");
    By countryField = By.cssSelector("select[name='id_country']");
    By phoneField = By.cssSelector("input[name='phone']");
    By saveButton = By.cssSelector("footer button[type='submit']");

    By successMessage = By.cssSelector("article.alert ul li");
    By addressBlock = By.cssSelector("div.address-body");
    By addressAlias = By.cssSelector("div.address-body h4");
    By deleteAddressButton = By.cssSelector("a[data-link-action='delete-address']");
    By backToAccount = By.cssSelector(".account-link");

    String addressAliasForValidation;

    public AddressPage(WebDriver driver){
        this.driver = driver;
    }

    public void validateAddressPage() {
        Assert.assertEquals("Add new address page is not shown", "New address",
                driver.findElement(newAddressHeader).getText());
    }

    public void fillInAlias(String alias){
        driver.findElement(aliasField).sendKeys(alias);
        addressAliasForValidation = alias;
    }

    public void fillInFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void fillInLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void fillInCompany(String company){
        driver.findElement(companyField).sendKeys(company);
    }

    public void fillInVAT(String vAT){
        driver.findElement(vATField).sendKeys(vAT);
    }

    public void fillInAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }

    public void fillInAddressCompl(String addressComp){
        driver.findElement(addressComplementField).sendKeys(addressComp);
    }

    public void fillInPostalCode(String postalCode){
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void fillInCity(String city){
        driver.findElement(cityField).sendKeys(city);
    }

    public void fillInPhoneNumber(String phoneNumber){
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void validateNewAddressSaveMessage(){
        Assert.assertEquals("Address was not saved succesfully", "Address successfully added!",
                driver.findElement(successMessage).getText());
    }

    public void validateNewlyAddedAddress() {
        Assert.assertTrue("Check if address block is visible", driver.findElement(addressBlock).isDisplayed());
        Assert.assertEquals("Address alias not present", addressAliasForValidation,
                driver.findElement(addressAlias).getText());
    }

    public void deleteNewlyAddress(){
        Assert.assertTrue("Check if delete address is visible", driver.findElement(deleteAddressButton).isDisplayed());
        driver.findElement(deleteAddressButton).click();
    }

    public void validateDeletedAddressMessage() {
        Assert.assertEquals("Address was not deleted succesfully", "Address successfully deleted!",
                driver.findElement(successMessage).getText());
    }

    //TODO not implemented navigation in as well
    public void validateNoAddressAccountPage() {
        driver.findElement(backToAccount).click();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue("Check if delete address is visible", driver.findElement(myAccountPage.myAccountElement).isDisplayed());
    }

    public WebElement getAddAddressElement() {
        return driver.findElement(newAddressHeader);
    }

    public WebElement getNewAddressSavedMessageElement() {
        return driver.findElement(successMessage);
    }

    public WebElement getNewlyAddedAddressElement() {
        return driver.findElement(addressBlock);
    }

    public WebElement getNewAddressAliasElement() {
        return driver.findElement(addressAlias);
    }

    public WebElement getAddressDeletedMessageElement() {
        return driver.findElement(successMessage);
    }
}
