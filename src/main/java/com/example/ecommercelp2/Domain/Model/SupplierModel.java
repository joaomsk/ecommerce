package com.example.ecommercelp2.Domain.Model;

import com.example.ecommercelp2.Domain.Model.InfoModels.AddressModel;
import com.example.ecommercelp2.Domain.Model.InfoModels.ContactModel;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class SupplierModel extends PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier", nullable = false)
    private Integer idSupplier;

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

    public SupplierModel(AddressModel address, ContactModel contact, Integer idSupplier, String supplierName, String supplierCNPJ) {
        super(address, contact);
        this.idSupplier = idSupplier;
        SupplierName = supplierName;
        SupplierCNPJ = supplierCNPJ;
        isValid();
    }

    private void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    private void setSupplierCNPJ(String supplierCNPJ) {
        SupplierCNPJ = supplierCNPJ;
    }

    private void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }

    public Integer getIdSupplier() {
        return idSupplier;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public String getSupplierCNPJ() {
        return SupplierCNPJ;
    }
}
