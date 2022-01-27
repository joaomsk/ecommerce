package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Domain.Entity.Entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class ContactModel extends Entity {

    @NotNull(message = "Email cant be null.")
    @Max(value = 100, message = "Email cant have more than 100 digits.")
    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotNull(message = "Cellphone cant be null")
    @Max(value = 20, message = "Cellphone cant have more than 20 digits. ")
    private String cellphone;

    @Deprecated
    public ContactModel() {
    }

    public ContactModel(String email, String telefone) {
        this.email = email;
        this.cellphone = telefone;
        isValid();
    }

    public String getEmail() {
        return email;
    }

    public String getCellphone() {
        return cellphone;
    }
}
