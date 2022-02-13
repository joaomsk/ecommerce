package com.example.ecommercelp2.Domain.Model.OrderModels;

import com.example.ecommercelp2.Domain.Entity.Entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
public class ItemModel extends Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item", nullable = false)
    private Integer idItem;

    @Valid
    @ManyToOne
    @JoinColumn(name = "id_product")
    @NotNull(message = "Product can't be null")
    private ProductModel ProductItem;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private OrderModel order;

    @NotNull(message = "QuantityItem can't be null")
    private Integer QuantityItem;

    @Deprecated
    public ItemModel() {
    }

    public ItemModel(ProductModel productItem, Integer quantityItem) {
        ProductItem = productItem;
        QuantityItem = quantityItem;
        isValid();
    }

    private void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    private void setProductItem(ProductModel productItem) {
        ProductItem = productItem;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    private void setQuantityItem(Integer quantityItem) {
        QuantityItem = quantityItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public ProductModel getProductItem() {
        return ProductItem;
    }

    public OrderModel getOrder() {
        return order;
    }

    public Integer getQuantityItem() {
        return QuantityItem;
    }

    public Double getTotalPriceItem() {
        return ProductItem.getProductPricePerUnit() * getQuantityItem();
    }
}
