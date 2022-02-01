package com.example.ecommercelp2.Domain.Model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CustomerModel extends PersonModel {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cant have more than 100 digits.")
    private String CostumerName;

    @NotNull(message = "CPF is required.")
    @NotBlank(message = "CPF is required.")
    @CPF(message = "Provide a valid CPF.")
    private String CostumerCPF;

    @Deprecated
    protected CustomerModel() {
    }

    public CustomerModel(Integer id, AddressModel address, ContactModel contact, String CostumerName, String CostumerCPF) {
        super(id, address, contact);
        this.CostumerName = CostumerName;
        this.CostumerCPF = CostumerCPF;
        isValid();
    }

    public String getCostumerCPF() {
        return CostumerCPF;
    }

    public String getCostumerName() {
        return CostumerName;
    }

}
