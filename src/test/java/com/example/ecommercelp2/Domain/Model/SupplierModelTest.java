package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Domain.Model.InfoModels.AddressModel;
import com.example.ecommercelp2.Domain.Model.InfoModels.ContactModel;
import com.example.ecommercelp2.Infrastructure.Exception.InvalidDomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SupplierModelTest {

    @Test
    void MustCreateAValidSupplier() {
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

        var Supplier = new SupplierModel(Address, Contact, null,"Empresas Tabajara", "42.115.044/0001-07");

        Assertions.assertNull(Supplier.getIdSupplier());
        Assertions.assertEquals("RS", Supplier.getAddress().getState());
        Assertions.assertEquals("Ipuaçu", Supplier.getAddress().getCity());
        Assertions.assertEquals("98445970", Supplier.getAddress().getCEP());
        Assertions.assertEquals("Centro", Supplier.getAddress().getNeighborhood());
        Assertions.assertEquals("Avenida Rio Branco", Supplier.getAddress().getStreet());
        Assertions.assertEquals("238", Supplier.getAddress().getHouseNumber());
        Assertions.assertNull(Supplier.getAddress().getAddressAddOn());
        Assertions.assertEquals("testing@gmail.com", Supplier.getContact().getEmail());
        Assertions.assertEquals("51999999999", Supplier.getContact().getCellphone());
        Assertions.assertEquals("Empresas Tabajara", Supplier.getSupplierName());
        Assertions.assertEquals("42.115.044/0001-07", Supplier.getSupplierCNPJ());
    }

    @Test
    void MustValidateSupplier_WithNullInformation() {
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
            new SupplierModel(Address, Contact, null,null, null);
        } catch (InvalidDomainException e) {
            String MessageError = "[SupplierCNPJ : CNPJ is required., SupplierName : Name is required]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }

    @Test
    void MustValidateSupplier_WithIncorrectInformation() {
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
            new SupplierModel(
                    Address,
                    Contact,
                    null,
                    "",
                    ""
            );
        } catch (InvalidDomainException e) {
            String MessageError = "[SupplierCNPJ : CNPJ is required., SupplierName : Name is required, SupplierCNPJ : Provide a valid CNPJ.]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }

    @Test
    void MustValidateSupplier_WithIncorrectInformation_2() {
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

        SupplierModel Supplier;

        try {
            Supplier = new SupplierModel(Address, Contact, null,
                    "ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910ABCDEFGHIJKLMNOPQRSTUVXYZ12345678910",
                    "1234");
        } catch (InvalidDomainException e) {
            String MessageError = "[SupplierName : Name can't have more than 100 digits., SupplierCNPJ : Provide a valid CNPJ.]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }

    @Test
    void MustValidateSupplier_WithAddressIncorrectData() {
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

        SupplierModel Supplier;

        try {
            Supplier = new SupplierModel(Address, Contact, null, "Tabajara",
                    "42.115.044/0001-07");
        } catch (InvalidDomainException e) {
            String MessageError = "[Address.HouseNumber : HouseNumber is required., Address.CEP : CEP can't have more than 10 digits., Address.State : State can only have 2 digits., Address.Neighborhood : Neighborhood can't have more than 50 digits., Address.Street : Street is required.]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }
}
