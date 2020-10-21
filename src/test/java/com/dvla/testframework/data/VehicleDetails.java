package com.dvla.testframework.data;

import org.springframework.stereotype.Component;

public class VehicleDetails {

    private String registrationNumber;
    private String make;
    private String colour;

    public VehicleDetails(String registrationNumber, String make, String colour) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.colour = colour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getColour() {
        return colour;
    }
}
