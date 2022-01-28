package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Domain.Entity.Entity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class ContactModel extends Entity {

    @NotNull(message = "Email is mandatory.")
    @Length(max = 20, message = "Email cant have more than 100 digits.")
    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotNull(message = "Cellphone is mandatory.")
    @Length(max = 20, message = "Cellphone cant have more than 20 digits. ")
    private String cellphone;

    @Deprecated
    public ContactModel() {
    }

    public ContactModel(String email, String cellphone) {
        this.email = email;
        this.cellphone = cellphone;
        isValid();
    }

    public String getEmail() {
        return email;
    }

    public String getCellphone() {
        return cellphone;
    }
}
