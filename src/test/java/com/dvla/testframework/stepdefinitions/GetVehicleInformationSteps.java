package com.dvla.testframework.stepdefinitions;

import com.dvla.testframework.data.VehicleDetails;
import com.dvla.testframework.model.GetVehicleDetailsPage;
import com.dvla.testframework.model.GetVehicleInformationHomePage;
import com.dvla.testframework.model.VehicleEnquiryServicePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.cucumber.datatable.DataTable.create;
import static io.cucumber.datatable.matchers.DataTableHasTheSameRowsAs.hasTheSameRowsAs;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.dvla.testframework.util.BddHelper.createTable;

public class GetVehicleInformationSteps {
    @Autowired
    private GetVehicleInformationHomePage getVehicleInformationHomePage;
    @Autowired
    private VehicleEnquiryServicePage vehicleEnquiryServicePage;
    @Autowired
    private GetVehicleDetailsPage getVehicleDetailsPage;

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
