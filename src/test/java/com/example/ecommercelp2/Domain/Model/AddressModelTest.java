package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Infrastructure.Exception.InvalidDomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressModelTest {

    @Test
    void MustCreateAValidAddress() {
        var Address = new AddressModel(
                "RS",
                "Ipuaçu",
                "98445970",
                "Centro",
                "Avenida Rio Branco",
                "238",
                null
        );

        Assertions.assertEquals("RS", Address.getState());
        Assertions.assertEquals("Ipuaçu", Address.getCity());
        Assertions.assertEquals("98445970", Address.getCEP());
        Assertions.assertEquals("Centro", Address.getNeighborhood());
        Assertions.assertEquals("Avenida Rio Branco", Address.getStreet());
        Assertions.assertEquals("238", Address.getHouseNumber());
        Assertions.assertNull(Address.getAddressAddOn());
    }
}