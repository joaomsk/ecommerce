package com.example.ecommercelp2.Domain.Model;

import org.hibernate.validator.constraints.br.CNPJ;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class SupplierModel extends PersonModel {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name can't have more than 100 digits.")
    private String SupplierName;

    @NotNull(message = "CNPJ is required.")
    @NotBlank(message = "CNPJ is required.")
    @CNPJ(message = "Provide a valid CNPJ.")
    private String SupplierCNPJ;

    @Deprecated
    protected SupplierModel() {
    }

    public SupplierModel(Integer id, AddressModel address, ContactModel contact, String supplierName, String supplierCNPJ) {
        super(id, address, contact);
        this.SupplierName = supplierName;
        this.SupplierCNPJ = supplierCNPJ;
        isValid();
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public String getSupplierCNPJ() {
        return SupplierCNPJ;
    }
}
