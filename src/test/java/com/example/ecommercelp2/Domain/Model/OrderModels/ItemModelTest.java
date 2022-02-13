package com.example.ecommercelp2.Domain.Model.OrderModels;

import com.example.ecommercelp2.Infrastructure.Exception.InvalidDomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ItemModelTest {

    @Test
    void MustCreateAValidItem() {
        var product = new ProductModel(
                1,
                "IPhone 13 Pro Max",
                null,
                3.899
        );

        var Item = new ItemModel(
                product,
                4
        );

        Assertions.assertEquals(product, Item.getProductItem());
        Assertions.assertEquals(4, Item.getQuantityItem());
        Assertions.assertEquals(15.596, Item.getTotalPriceItem());
    }

    @Test
    void MustCreateAnInvalidItem_WithNullInfo() {
        try {
            var Item = new ItemModel(
                    null,
                    null
            );
        } catch (InvalidDomainException e) {
            String MessageError = "[QuantityItem : QuantityItem can't be null, ProductItem : Product can't be null]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }
}