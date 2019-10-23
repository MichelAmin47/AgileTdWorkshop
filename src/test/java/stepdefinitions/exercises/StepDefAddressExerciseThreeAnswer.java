package stepdefinitions.exercises;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.AddressPage;
import pages.MyAccountPage;

public class StepDefAddressExerciseThreeAnswer {

    private WebDriver driver;
    private MyAccountPage myAccountPage;
    private AddressPage addressPage;

    public StepDefAddressExerciseThreeAnswer(DriverManager driverManager){
        this.driver = driverManager.driver;
        addressPage = new AddressPage(driver);
    }
    @And("The user submits his first address")
    public void theUserSubmitsHisFirstAddress() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickToAddFirstAddres();

        addressPage.fillInAlias("retseT");
        addressPage.fillInFirstName("Mister");
        addressPage.fillInLastName("Test");
        addressPage.fillInCompany("Tester.io");
        addressPage.fillInVAT("4321");
        addressPage.fillInAddress("Testlane 23");
        addressPage.fillInAddressCompl("3A");
        addressPage.fillInPostalCode("1111 AA");
        addressPage.fillInCity("Testdam");
        addressPage.fillInPhoneNumber("0031123456");
        addressPage.clickSaveButton();
    }

    @Then("The new address should be show on the address page")
    public void theNewAddressShouldBeShowOnTheAddressPage() {
        addressPage.checkNewlyAddedAddress();
        addressPage.deleteNewlyAddress();
    }
}