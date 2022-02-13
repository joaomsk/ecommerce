package com.example.ecommercelp2.Domain.Model.OrderModels;

import com.example.ecommercelp2.Infrastructure.Exception.InvalidDomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductModelTest {

    @Test
    void MustCreateAValidProduct() {
        var product = new ProductModel(
                1,
                "IPhone 13 Pro Max",
                null,
                3.899
        );

        Assertions.assertEquals(1, product.getIdProduct());
        Assertions.assertEquals("IPhone 13 Pro Max", product.getProductName());
        Assertions.assertNull(product.getProductDescription());
        Assertions.assertEquals(3.899, product.getProductPricePerUnit());
    }

    @Test
    void MustCreateAnInvalidProduct_WithNullData() {
        try {
            var product = new ProductModel(
                    null,
                    null,
                    null,
                    null
            );
        } catch (InvalidDomainException e) {
            String MessageError = "[ProductName : ProductName can't be blank., ProductPricePerUnit : ProductPricePerUnit is required., ProductName : ProductName can't be empty.]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }
}