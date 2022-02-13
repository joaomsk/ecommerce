package com.example.ecommercelp2.Domain.Model.OrderModels;

import com.example.ecommercelp2.Domain.Model.CustomerModel;
import com.example.ecommercelp2.Domain.Model.InfoModels.AddressModel;
import com.example.ecommercelp2.Domain.Model.InfoModels.ContactModel;
import com.example.ecommercelp2.Domain.Model.SupplierModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderModelTest {

    @Test
    void MustCreateAValidOrder() {
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

        var product = new ProductModel(
                1,
                "IPhone 13 Pro Max",
                null,
                3899.0
        );

        var Supplier = new SupplierModel(Address, Contact, null,"Empresas Tabajara", "42.115.044/0001-07");
        var Customer = new CustomerModel(Address, Contact, null, "João Gabriel Meleski Dier", "308.269.110-21");

        var item = new ItemModel(
                product,
                4
        );

        var order = new OrderModel(
                1,
                Supplier,
                Customer,
                item,
                5.60
        );

        Assertions.assertEquals(1, order.getIdOrder());
        Assertions.assertEquals(Supplier, order.getSupplier());
        Assertions.assertEquals(Customer, order.getCustomer());
        Assertions.assertEquals(5.60, order.getShipmentPrice());
        Assertions.assertEquals(15601.6, order.getTotalOrderPrice());
    }
}