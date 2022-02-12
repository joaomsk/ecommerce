package com.example.ecommercelp2.Domain.Model;

import org.hibernate.cfg.AccessType;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class CustomerModel extends PersonModel {

    @Column(name = "name")
    @Size(max = 100, message = "Name cant have more than 100 digits.")
    private String CustomerName;

    @Column(name = "CPF")
    @CPF(message = "Provide a valid CPF.")
    private String CustomerCPF;

    @Deprecated
    public CustomerModel() {
    }

    public CustomerModel(Integer id, AddressModel address, ContactModel contact, String customerName, String customerCPF) {
        super(id, address, contact);
        CustomerName = customerName;
        CustomerCPF = customerCPF;
    }

    /*public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setCustomerCPF(String customerCPF) {
        CustomerCPF = customerCPF;
    }*/

    public String getCustomerCPF() {
        return CustomerCPF;
    }

    public String getCustomerName() {
        return CustomerName;
    }
}
