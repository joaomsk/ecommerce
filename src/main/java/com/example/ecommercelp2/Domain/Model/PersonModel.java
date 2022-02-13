package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Domain.Entity.Entity;
import com.example.ecommercelp2.Domain.Model.InfoModels.AddressModel;
import com.example.ecommercelp2.Domain.Model.InfoModels.ContactModel;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class PersonModel extends Entity {

    @Valid
    @NotNull(message = "Address cant be null")
    @Embedded
    private AddressModel Address;

    @Valid
    @NotNull(message = "Contact cant be null")
    @Embedded
    private ContactModel Contact;

    @Deprecated
    public PersonModel() {
    }

    public PersonModel(AddressModel address, ContactModel contact) {
        Address = address;
        Contact = contact;
    }

    private void setAddress(AddressModel address) {
        Address = address;
    }

    private void setContact(ContactModel contact) {
        Contact = contact;
    }

    public AddressModel getAddress() {
        return Address;
    }

    public ContactModel getContact() {
        return Contact;
    }

}
