package com.example.ecommercelp2.Domain.Entity;

import com.example.ecommercelp2.Infrastructure.Exception.InvalidDomainException;

import javax.validation.*;
import java.util.HashSet;
import java.util.Set;

public class Entity {

    public void isValid() {
        Configuration<?> configurations = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = configurations.buildValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Entity>> constraintViolations = validator.validate(this);

        Set<String> messages = new HashSet<>();

        for (ConstraintViolation<Entity> constraintViolation : constraintViolations) {
            String field = constraintViolation.getPropertyPath().toString();
            String msg = constraintViolation.getMessage();
            messages.add(field.concat(" : ").concat(msg));
        }

        if (!messages.isEmpty()) {
            throw new InvalidDomainException(messages);
        }
    }
}
