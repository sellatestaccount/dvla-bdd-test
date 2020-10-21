package com.dvla.testframework.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Vehicle Enquiry page object
 */
@Component
public class VehicleEnquiryServicePage {

    @FindBy(id = "wizard_vehicle_enquiry_capture_vrn_vrn")
    private WebElement registrationNumberInput;

    @FindBy(id = "submit_vrn_button")
    private WebElement submitRegistrationNumberButton;

    @FindBy(id = "yes-vehicle-confirm")
    private WebElement confirmVehicleOptionYes;

    @FindBy(id = "capture_confirm_button")
    private WebElement submitVehicleConfirmationButton;

    private final WebDriver driver;

    @Autowired
    public VehicleEnquiryServicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterVehicleRegistrationNumber(String registrationNumber) {
        registrationNumberInput.sendKeys(registrationNumber);
    }

    public void submitRegistrationNumber() {
        submitRegistrationNumberButton.click();
    }

    public void confirmVehicle(String confirmation) {
        confirmVehicleOptionYes.click();
    }

    public void submitVehicleConfirmation() {
        submitVehicleConfirmationButton.click();
    }
}
