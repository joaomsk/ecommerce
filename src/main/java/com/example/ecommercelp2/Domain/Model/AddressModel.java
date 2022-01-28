package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Domain.Entity.Entity;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressModel extends Entity {

    @NotBlank(message = "State is required.")
    @NotNull(message = "State is required.")
    @Length(max = 20, message = "State can only have 2 digits.")
    private String State;

    @NotBlank(message = "City is required.")
    @NotNull(message = "City is required.")
    @Length(max = 20, message = "City can't have more than 50 digits.")
    private String City;

    @NotBlank(message = "CEP is required.")
    @NotNull(message = "CEP is required.")
    @Length(max = 20, message = "CEP can't have more than 10 digits.")
    private String CEP;

    @NotBlank(message = "Neighborhood is required.")
    @NotNull(message = "Neighborhood is required.")
    @Length(max = 20, message = "Neighborhood can't have more than 50 digits.")
    private String Neighborhood;

    @NotBlank(message = "Street is required.")
    @NotNull(message = "Street is required.")
    @Length(max = 20, message = "Street can't have more than two digits.")
    private String Street;

    @NotBlank(message = "HouseNumber is required.")
    @NotNull(message = "HouseNumber is required.")
    @Length(max = 20, message = "HouseNumber can't have more than two digits.")
    private String HouseNumber;

    @Nullable
    @Length(max = 20, message = "AddressAddOn cant have more than 120 digits.")
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
        isValid();
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
