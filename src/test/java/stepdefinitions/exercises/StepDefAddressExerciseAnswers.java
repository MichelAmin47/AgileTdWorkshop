package stepdefinitions.exercises;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AddressPage;
import pages.MyAccountPage;

public class StepDefAddressExerciseAnswers {

    private WebDriver driver;
    private MyAccountPage myAccountPage;
    private AddressPage addressPage;

    public StepDefAddressExerciseAnswers(DriverManager driverManager){
        this.driver = driverManager.driver;
        addressPage = new AddressPage(driver);
    }
//  ANSWER FOR EXERCISE THREE - ASSERTIONS ARE DEEP
    @And("The user submits his first address")
    public void theUserSubmitsHisFirstAddress() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickToAddFirstAddres();
        addressPage.validateAddressPage();

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
        addressPage.validateNewAddressSaveMessage();
    }

    @Then("The new address should be shown on the address page")
    public void theNewAddressShouldBeShowOnTheAddressPage() {
        addressPage.validateNewlyAddedAddress();
    }

    @Then("The newly added address is deleted")
    public void theNewlyAddedAddressIsDeleted() {
        addressPage.deleteNewlyAddress();
        addressPage.validateDeletedAddressMessage();
        //addressPage.validateNoAddressAccountPage();
    }

/*    // --- ANSWER FOR FOURTH EXERCISE --- ASSERTION IN THIS LAYER
    @And("The user submits his first address")
    public void theUserSubmitsHisFirstAddress() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickToAddFirstAddres();

        Assert.assertEquals("Add new address page is not shown", "New address",
                addressPage.getAddAddressElement().getText());

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

        Assert.assertEquals("Address was not saved succesfully", "Address successfully added!",
                addressPage.getNewAddressSavedMessageElement().getText());
    }

    @Then("The new address should be shown on the address page")
    public void theNewAddressShouldBeShownOnTheAddressPage() {
        Assert.assertTrue("Check if address block is visible", addressPage.getNewlyAddedAddressElement().isDisplayed());

        Assert.assertEquals("Address alias not present", "retseT",
                addressPage.getNewAddressAliasElement().getText());
    }

    @Then("The newly added address is deleted")
    public void theNewlyAddedAddressIsDeleted() {
        addressPage.deleteNewlyAddress();

        Assert.assertEquals("Address was not deleted succesfully", "Address successfully deleted!",
                addressPage.getAddressDeletedMessageElement().getText());

        //TODO one check to many?
        //addressPage.validateNoAddressAccountPage();
    }*/
}
