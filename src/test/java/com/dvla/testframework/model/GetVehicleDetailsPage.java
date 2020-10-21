package com.dvla.testframework.model;

import com.dvla.testframework.data.VehicleDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Get Vehicle Details page object
 */
@Component
public class GetVehicleDetailsPage {

    private final WebDriver driver;

    private VehicleDetails vehicleDetails;
    private List<VehicleDetails> vehicleDetailsList;

    @FindBy(className = "reg-mark")
    private WebElement vehicleRegistrationNumber;

    @FindBy(xpath = "//*[@id='make']/dd")
    private WebElement vehicleMake;

    @FindBy(xpath = "//*[@id='colour']/dd")
    private WebElement vehicleColour;

    @FindBy(id = "search-for-another-vehicle")
    private WebElement searchAgainLink;

    @Autowired
    public GetVehicleDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber.getText();
    }

    public String getVehicleMake() {
        return vehicleMake.getText();
    }

     public String getVehicleColour() {
        return vehicleColour.getText();
    }

    public void searchAnotherVehicle() {
        searchAgainLink.click();
    }

    public VehicleDetails getVehicleDetails() {
        return new VehicleDetails(getVehicleRegistrationNumber(),
                getVehicleMake(),
                getVehicleColour());
    }

    public List<VehicleDetails> getVehicleDetailsList() {
        vehicleDetailsList = new ArrayList<>();
        vehicleDetailsList.add(getVehicleDetails());
        return vehicleDetailsList;
    }
}
