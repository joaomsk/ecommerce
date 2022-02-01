package com.example.ecommercelp2.Domain.Model;

import org.springframework.lang.Nullable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class AddressModel {

    @NotBlank(message = "State is required.")
    @NotNull(message = "State is required.")
    @Size(max = 2, message = "State can only have 2 digits.")
    private String State;

    @NotBlank(message = "City is required.")
    @NotNull(message = "City is required.")
    @Size(max = 50, message = "City can't have more than 50 digits.")
    private String City;

    @NotBlank(message = "CEP is required.")
    @NotNull(message = "CEP is required.")
    @Size(max = 10, message = "CEP can't have more than 10 digits.")
    private String CEP;

    @NotBlank(message = "Neighborhood is required.")
    @NotNull(message = "Neighborhood is required.")
    @Size(max = 50, message = "Neighborhood can't have more than 50 digits.")
    private String Neighborhood;

    @NotBlank(message = "Street is required.")
    @NotNull(message = "Street is required.")
    @Size(max = 100, message = "Street can't have more than two digits.")
    private String Street;

    @NotBlank(message = "HouseNumber is required.")
    @NotNull(message = "HouseNumber is required.")
    @Size(max = 6, message = "HouseNumber can't have more than two digits.")
    private String HouseNumber;

    @Nullable
    @Size(max = 120, message = "AddressAddOn cant have more than 120 digits.")
    private String AddressAddOn;

    @Deprecated
    public AddressModel() {
    }

    public AddressModel(String state, String city, String CEP, String neighborhood, String street, String houseNumber, String addressAddOn) {
        this.State = state;
        this.City = city;
        this.CEP = CEP;
        this.Neighborhood = neighborhood;
        this.Street = street;
        this.HouseNumber = houseNumber;
        this.AddressAddOn = addressAddOn;
    }

    private void setState(String state) {
        State = state;
    }

    private void setCity(String city) {
        City = city;
    }

    private void setCEP(String CEP) {
        this.CEP = CEP;
    }

    private void setNeighborhood(String neighborhood) {
        Neighborhood = neighborhood;
    }

    private void setStreet(String street) {
        Street = street;
    }

    private void setHouseNumber(String houseNumber) {
        HouseNumber = houseNumber;
    }

    private void setAddressAddOn(@Nullable String addressAddOn) {
        AddressAddOn = addressAddOn;
    }

    public String getState() {
        return State;
    }

    public String getCity() {
        return City;
    }

    public String getCEP() {
        return CEP;
    }

    public String getNeighborhood() {
        return Neighborhood;
    }

    public String getStreet() {
        return Street;
    }

    public String getHouseNumber() {
        return HouseNumber;
    }

    public String getAddressAddOn() {
        return AddressAddOn;
    }
}
