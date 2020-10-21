package com.dvla.testframework.stepdefinitions;

import com.dvla.testframework.data.VehicleDetails;
import com.dvla.testframework.pageobject.pageobjectimpl.GetVehicleDetailsPageImpl;
import com.dvla.testframework.pageobject.pageobjectimpl.GetVehicleInformationHomePageImpl;
import com.dvla.testframework.pageobject.pageobjectimpl.VehicleEnquiryServicePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static io.cucumber.datatable.matchers.DataTableHasTheSameRowsAs.hasTheSameRowsAs;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.dvla.testframework.util.BddHelper.createTable;

public class GetVehicleInformationSteps {
    private GetVehicleInformationHomePage getVehicleInformationHomePage;
    private VehicleEnquiryServicePage vehicleEnquiryServicePage;
    private GetVehicleDetailsPage getVehicleDetailsPage;

    @Autowired
    public GetVehicleInformationSteps(GetVehicleInformationHomePage getVehicleInformationHomePage,
                                      VehicleEnquiryServicePage vehicleEnquiryServicePage,
                                      GetVehicleDetailsPage getVehicleDetailsPage) {
        this.getVehicleInformationHomePage = getVehicleInformationHomePage;
        this.vehicleEnquiryServicePage = vehicleEnquiryServicePage;
        this.getVehicleDetailsPage = getVehicleDetailsPage;
    }

    @Given("I am on vehicle information from DVLA page")
    public void iAmOnVehicleInformationFromDVLAPage() {
        getVehicleInformationHomePage.load();
    }

    @And("I click Startnow")
    public void iClickStartnow() {
        getVehicleInformationHomePage.startVehicleDetailsSearch();
    }

    @When("I enter the vehicle registration number {string} on vehicle enquiry service")
    public void iEnterTheVehicleRegistrationNumber(String registrationNumber) {
        vehicleEnquiryServicePage.enterVehicleRegistrationNumber(registrationNumber);
    }

    @And("I click Continue")
    public void iClickContinue() {
        vehicleEnquiryServicePage.submitRegistrationNumber();
    }

    @And("I select {string} to confirm vehicle")
    public void iSelectToConfirmVehicle(String confirmation) {
        vehicleEnquiryServicePage.confirmVehicle(confirmation);
    }

    @And("I click Continue to confirm vehicle")
    public void iClickContinueToConfirmVehicle() {
        vehicleEnquiryServicePage.submitVehicleConfirmation();
    }

    @Then("the vehicle details page should contain the following information")
    public void theVehicleDetailsPageShouldContainTheFollowingInformation(DataTable expectedVehicleDetails) {
        List<VehicleDetails> vehicleDetails = getVehicleDetailsPage.getVehicleDetailsList();
        DataTable actualVehicleDetails = createTable(
                vehicleDetails,
                Arrays.asList("vehicleRegistrationNumber","vehicleMake","vehicleColour"),
                VehicleDetails::getRegistrationNumber, VehicleDetails::getMake, VehicleDetails::getColour
        );

        assertThat(actualVehicleDetails, hasTheSameRowsAs(expectedVehicleDetails));
    }
}
