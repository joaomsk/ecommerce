package com.example.ecommercelp2.Domain.Model.InfoModels;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Embeddable
public class ContactModel {

    @NotNull(message = "Email is mandatory.")
    @Length(max = 20, message = "Email cant have more than 100 digits.")
    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotNull(message = "Cellphone is mandatory.")
    @Length(max = 20, message = "Cellphone cant have more than 20 digits. ")
    private String cellphone;

    @Deprecated
    protected ContactModel() {
    }

    public ContactModel(String email, String cellphone) {
        this.email = email;
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public String getCellphone() {
        return cellphone;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
