package com.example.ecommercelp2.Domain.Annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFBeanValidation implements ConstraintValidator<CPF, String> {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    @Override
    public void initialize(CPF value) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return CPFValidate(value);
    }

    private boolean CPFValidate(String cpf) {
        if ((cpf.length() != 11) || validarSequenciaCaracter(cpf)) {
            return false;
        }
        Integer digit1 = DigitCalculator(cpf.substring(0, 9), pesoCPF);
        Integer digit2 = DigitCalculator(cpf.substring(0, 9) + digit1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digit1 + digit2);
    }

    private static int DigitCalculator(String str, int[] peso) {
        int sum = 0;
        int digit;
        for (int i = str.length() - 1; i >= 0; i--) {
            digit = Integer.parseInt(str.substring(i, i + 1));
            sum += digit * peso[peso.length - str.length() + i];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

    private boolean validarSequenciaCaracter(String document) {
        String documentsTemp;
        for (int i = 0; i <= 9; i++) {
            documentsTemp = "";
            for (int j = 0; j < 11; j++) {
                documentsTemp += Integer.toString(i);
            }
            if (document.equals(documentsTemp)) {
                return true;
            }
        }
        return false;
    }

}
