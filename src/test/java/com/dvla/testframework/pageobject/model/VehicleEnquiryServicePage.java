package com.dvla.testframework.pageobject.model;

public interface VehicleEnquiryServicePage {

    public void enterVehicleRegistrationNumber(String registrationNumber);

    public void submitRegistrationNumber();

    public void confirmVehicle(String confirmation);

    public void submitVehicleConfirmation();

}
