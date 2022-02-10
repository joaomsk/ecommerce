package com.example.ecommercelp2.Domain.Model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class CustomerModel extends PersonModel {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cant have more than 100 digits.")
    private String CustomerName;

    @NotNull(message = "CPF is required.")
    @NotBlank(message = "CPF is required.")
    @CPF(message = "Provide a valid CPF.")
    private String CustomerCPF;

    @Deprecated
    protected CustomerModel() {
    }

    public CustomerModel(Integer id, AddressModel address, ContactModel contact, String CustomerName, String CustomerCPF) {
        super(id, address, contact);
        this.CustomerName = CustomerName;
        this.CustomerCPF = CustomerCPF;
        isValid();
    }

    public String getCustomerCPF() {
        return CustomerCPF;
    }

    public String getCustomerName() {
        return CustomerName;
    }

}
