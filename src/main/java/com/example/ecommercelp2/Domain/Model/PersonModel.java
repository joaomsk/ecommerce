package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Domain.Entity.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class PersonModel extends Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Address cant be null")
    private AddressModel Address;

    @NotNull(message = "Contact cant be null")
    private ContactModel Contact;

    public PersonModel(Integer id, AddressModel address, ContactModel contact) {
        this.id = id;
        Address = address;
        Contact = contact;
        isValid();
    }

    public Integer getId() {
        return id;
    }

    public AddressModel getAddress() {
        return Address;
    }

    public ContactModel getContact() {
        return Contact;
    }
}
