package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Domain.Entity.Entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class PersonModel extends Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    public PersonModel(Integer id, AddressModel address, ContactModel contact) {
        this.id = id;
        Address = address;
        Contact = contact;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    private void setAddress(AddressModel address) {
        Address = address;
    }

    private void setContact(ContactModel contact) {
        Contact = contact;
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
