package com.dvla.testframework.pageobject.model;

import com.dvla.testframework.data.VehicleDetails;

import java.util.List;

public interface GetVehicleDetailsPage {

    public String getVehicleRegistrationNumber();

    public String getVehicleMake();

    public String getVehicleColour();

    public void searchAnotherVehicle();

    public VehicleDetails getVehicleDetails();

    public List<VehicleDetails> getVehicleDetailsList();

}
