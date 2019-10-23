package stepdefinitions.exercises;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.AddressPage;
import pages.MyAccountPage;

public class StepDefAddress {

    private WebDriver driver;
    private MyAccountPage myAccountPage;
    private AddressPage addressPage;

    public StepDefAddress(DriverManager driverManager){
        this.driver = driverManager.driver;
        addressPage = new AddressPage(driver);
    }

    @And("clicks add first address")
    public void clicksAddFirstAdress() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickToAddFirstAddres();
    }

    @And("checks for the new address page")
    public void checksForTheNewAddressPage() {
        addressPage.validateAddressPage();
    }

    @And("fills in Alias \"([^\"]*)\"")
    public void fillsInAlias(String alias) {
        addressPage.fillInAlias(alias);
    }

    @And("fills in First Name \"([^\"]*)\"")
    public void fillsInFirstName(String firstName) {
        addressPage.fillInFirstName(firstName);
    }

    @And("fills in Last Name \"([^\"]*)\"")
    public void fillsInLastName(String lastName) {
        addressPage.fillInLastName(lastName);
    }

    @And("fills in Company \"([^\"]*)\"")
    public void fillsInCompany(String company) {
        addressPage.fillInCompany(company);
    }

    @And("fills in VAT \"([^\"]*)\"")
    public void fillsInVAT(String vat) {
        addressPage.fillInVAT(vat);
    }

    @And("fills in Address \"([^\"]*)\"")
    public void fillsInAddress(String address) {
        addressPage.fillInAddress(address);
    }

    @And("fills in Address Complement \"([^\"]*)\"")
    public void fillsInAddressComplement(String addressComp) {
        addressPage.fillInAddressCompl(addressComp);
    }

    @And("fills in Postal Code \"([^\"]*)\"")
    public void fillsInPostalCode(String postalCode) {
        addressPage.fillInPostalCode(postalCode);
    }

    @And("fills in City \"([^\"]*)\"")
    public void fillsInCity(String city) {
        addressPage.fillInCity(city);
    }

    @And("fills in Country \"([^\"]*)\"")
    public void fillsInCountry(String country) {
    }

    @And("fills in Phone \"([^\"]*)\"")
    public void fillsInPhone(String phoneNumber) {
        addressPage.fillInPhoneNumber(phoneNumber);
    }

    @And("clicks SAVE")
    public void clicksSAVE() {
        addressPage.clickSaveButton();
    }

    @And("checks for the new address save message")
    public void checksForTheNewAddressSaveMessage() {
        addressPage.validateNewAddressSaveMessage();
    }

    @Then("The address is on the address page")
    public void theAdressIsOnTheAdressPage() {
        addressPage.validateNewlyAddedAddress();
    }

    @And("delete the address")
    public void deleteTheAdress() {
        addressPage.deleteNewlyAddress();
    }

    @And("checks for deleted address message")
    public void checksForDeletedAddressMessage() {
        addressPage.validateDeletedAddressMessage();
    }

    @And("checks for no address on MyAccount page")
    public void checksForNoAddressOnMyAccountPage() {
        addressPage.validateNoAddressAccountPage();
    }
}
