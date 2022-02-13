package com.example.ecommercelp2.Domain.Model.OrderModels;

import com.example.ecommercelp2.Domain.Entity.Entity;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


@javax.persistence.Entity
public class ProductModel extends Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Integer idProduct;

    @NotEmpty(message = "ProductName can't be empty.")
    private String ProductName;

    @Nullable
    @Size(max = 500, message = "ProductDescription can't have more than 500 digits.")
    private String ProductDescription;

    @Min(value = 0, message = "Price must be positive and bigger than 0.")
    private Double ProductPricePerUnit;

    @Deprecated
    public ProductModel() {
    }

    public ProductModel(Integer idProduct, String productName, @Nullable String productDescription, Double productPricePerUnit) {
        this.idProduct = idProduct;
        ProductName = productName;
        ProductDescription = productDescription;
        ProductPricePerUnit = productPricePerUnit;
        isValid();
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    private void setProductName(String productName) {
        ProductName = productName;
    }

    private void setProductDescription(@Nullable String productDescription) {
        ProductDescription = productDescription;
    }

    private void setProductPricePerUnit(Double productPricePerUnit) {
        ProductPricePerUnit = productPricePerUnit;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public String getProductName() {
        return ProductName;
    }

    @Nullable
    public String getProductDescription() {
        return ProductDescription;
    }

    public Double getProductPricePerUnit() {
        return ProductPricePerUnit;
    }
}

