package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Domain.Model.InfoModels.AddressModel;
import com.example.ecommercelp2.Domain.Model.InfoModels.ContactModel;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class CustomerModel extends PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", nullable = false)
    private Integer idCustomer;

    @Column(name = "name")
    @Size(max = 100, message = "Name cant have more than 100 digits.")
    private String CustomerName;

    @Column(name = "CPF")
    @CPF(message = "Provide a valid CPF.")
    private String CustomerCPF;

    @Deprecated
    public CustomerModel() {
    }

    public CustomerModel(AddressModel address, ContactModel contact, Integer idCustomer, String customerName, String customerCPF) {
        super(address, contact);
        this.idCustomer = idCustomer;
        CustomerName = customerName;
        CustomerCPF = customerCPF;
        isValid();
    }

    private void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    private void setCustomerCPF(String customerCPF) {
        CustomerCPF = customerCPF;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerCPF() {
        return CustomerCPF;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }
}
