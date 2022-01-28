package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Domain.Annotations.CPF;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientModel extends PersonModel {

    @CPF
    private String CPF;

    @NotBlank
    @Length(max = 20, message = "Name cant have more than 100 digits.")
    private String Name;

    public ClientModel(Integer id, AddressModel address, ContactModel contact, String CPF, String name) {
        super(id, address, contact);
        this.CPF = CPF;
        Name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public String getName() {
        return Name;
    }
}
