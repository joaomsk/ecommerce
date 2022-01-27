package com.example.ecommercelp2.ModelTest;

import com.example.ecommercelp2.Domain.Model.ContactModel;
import com.example.ecommercelp2.Infrastructure.Exception.DomainInvalidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactModelTest {

    @Test
    void testValidationOfEmail() {
        try {
            new ContactModel(
                    "testing",
                    "51123567890");
        } catch (DomainInvalidException e) {
            String MessageError = "[email : Please, provide a valid email address.]";
            Assertions.assertEquals(MessageError, e.getMessage());
        }
    }
}
