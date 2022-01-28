package com.example.ecommercelp2.Domain.Annotations;

import javax.validation.Payload;

public @interface CPF {

    String message() default "CPF must be valid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
