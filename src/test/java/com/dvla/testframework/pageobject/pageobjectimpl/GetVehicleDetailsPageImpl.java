package com.dvla.testframework.pageobject.pageobjectimpl;

import com.dvla.testframework.data.VehicleDetails;
import com.dvla.testframework.pageobject.model.GetVehicleDetailsPage;
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
public class GetVehicleDetailsPageImpl implements GetVehicleDetailsPage {

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
    public GetVehicleDetailsPageImpl(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Override
    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber.getText();
    }

    @Override
    public String getVehicleMake() {
        return vehicleMake.getText();
    }

    @Override
    public String getVehicleColour() {
        return vehicleColour.getText();
    }

    @Override
    public void searchAnotherVehicle() {
        searchAgainLink.click();
    }

    @Override
    public VehicleDetails getVehicleDetails() {
        return new VehicleDetails(getVehicleRegistrationNumber(),
                getVehicleMake(),
                getVehicleColour());
    }

    @Override
    public List<VehicleDetails> getVehicleDetailsList() {
        vehicleDetailsList = new ArrayList<>();
        vehicleDetailsList.add(getVehicleDetails());
        return vehicleDetailsList;
    }
}
