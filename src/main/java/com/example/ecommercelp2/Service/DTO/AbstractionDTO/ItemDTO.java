package com.example.ecommercelp2.Service.DTO.AbstractionDTO;

public class ItemDTO {
    private Integer IdProduct;
    private int QuantityProduct;

    public Integer getIdProduct() {
        return IdProduct;
    }

    public int getQuantityProduct() {
        return QuantityProduct;
    }

    public void setIdProduct(Integer idProduct) {
        IdProduct = idProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        QuantityProduct = quantityProduct;
    }
}
