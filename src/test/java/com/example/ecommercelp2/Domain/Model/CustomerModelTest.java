package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Domain.Model.InfoModels.AddressModel;
import com.example.ecommercelp2.Domain.Model.InfoModels.ContactModel;
import com.example.ecommercelp2.Infrastructure.Exception.InvalidDomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerModelTest {

    @Test
    void MustCreateAValidCustomer() {
        var Address = new AddressModel(
                "RS",
                "Ipuaçu",
                "98445970",
                "Centro",
                "Avenida Rio Branco",
                "238",
                null
        );

        var Contact = new ContactModel(
                "testing@gmail.com",
                "51999999999"
        );

        var Customer = new CustomerModel(Address, Contact, null,"João Gabriel Meleski Dier", "308.269.110-21");

        Assertions.assertNull(Customer.getIdCustomer());
        Assertions.assertEquals("RS", Customer.getAddress().getState());
        Assertions.assertEquals("Ipuaçu", Customer.getAddress().getCity());
        Assertions.assertEquals("98445970", Customer.getAddress().getCEP());
        Assertions.assertEquals("Centro", Customer.getAddress().getNeighborhood());
        Assertions.assertEquals("Avenida Rio Branco", Customer.getAddress().getStreet());
        Assertions.assertEquals("238", Customer.getAddress().getHouseNumber());
        Assertions.assertNull(Customer.getAddress().getAddressAddOn());
        Assertions.assertEquals("testing@gmail.com", Customer.getContact().getEmail());
        Assertions.assertEquals("51999999999", Customer.getContact().getCellphone());
        Assertions.assertEquals("João Gabriel Meleski Dier", Customer.getCustomerName());
        Assertions.assertEquals("308.269.110-21", Customer.getCustomerCPF());
    }

    @Test
    void MustValidateCustomer_WithNullInformation() {
        var Address = new AddressModel(
                "RS",
                "Ipuaçu",
                "98445970",
                "Centro",
                "Avenida Rio Branco",
                "238",
                null
        );

        var Contact = new ContactModel(
                "testing@gmail.com",
                "51999999999"
        );

        try {
            new CustomerModel(Address, Contact, null,null, null);
        } catch (InvalidDomainException e) {
            String MessageError = "[CostumerName : Name is required, CostumerCPF : CPF is required.]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }

    @Test
    void MustValidateCustomer_WithIncorrectInformation() {
        var Address = new AddressModel(
                "RS",
                "Ipuaçu",
                "98445970",
                "Centro",
                "Avenida Rio Branco",
                "238",
                null
        );

        var Contact = new ContactModel(
                "testing@gmail.com",
                "51999999999"
        );

        try {
            new CustomerModel(
                    Address,
                    Contact,
                    null,
                    "",
                    ""
            );
        } catch (InvalidDomainException e) {
            String MessageError = "[CostumerCPF : Provide a valid CPF., CostumerCPF : CPF is required., CostumerName : Name is required]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }

    @Test
    void MustValidateCostumer_WithIncorrectInformation_2() {
        var Address = new AddressModel(
                "RS",
                "Ipuaçu",
                "98445970",
                "Centro",
                "Avenida Rio Branco",
                "238",
                null
        );

        var Contact = new ContactModel(
                "testing@gmail.com",
                "51999999999"
        );

        CustomerModel Customer;

        try {
            Customer = new CustomerModel(Address, Contact, null,
                    "ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910",
                    "1234");
        } catch (InvalidDomainException e) {
            String MessageError = "[CostumerCPF : Provide a valid CPF., CostumerName : Name cant have more than 100 digits.]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }

    @Test
    void MustValidateCustomer_WithAddressNullData() {
        var Address = new AddressModel(
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        var Contact = new ContactModel(
                "testing@gmail.com",
                "51999999999"
        );

        CustomerModel Costumer;

        try {
            Costumer = new CustomerModel(Address, Contact,null, "João Dier",
                    "308.269.110-21");
        } catch (InvalidDomainException e) {
            String MessageError = "[Address.State : State is required., Address.HouseNumber : HouseNumber is required., Address.Neighborhood : Neighborhood is required., Address.CEP : CEP is required., Address.Street : Street is required., Address.City : City is required.]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }

    @Test
    void MustValidateCostumer_WithAddressIncorrectData() {
        var Address = new AddressModel(
                "RSS",
                "Portoooooooo Alegreeeeee",
                "9132321327371286387",
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaaaaaaaaAAAAAAAAAAAAAAAAAAA",
                null,
                null,
                null
        );

        var Contact = new ContactModel(
                "testing@gmail.com",
                "51999999999"
        );

        CustomerModel Customer;

        try {
            Customer = new CustomerModel( Address, Contact, null, "João Dier",
                    "308.269.110-21");
        } catch (InvalidDomainException e) {
            String MessageError = "[Address.HouseNumber : HouseNumber is required., Address.CEP : CEP can't have more than 10 digits., Address.State : State can only have 2 digits., Address.Street : Street is required., Address.Neighborhood : Neighborhood can't have more than 50 digits.]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }
}