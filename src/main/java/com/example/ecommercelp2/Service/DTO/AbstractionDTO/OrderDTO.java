package com.example.ecommercelp2.Service.DTO.AbstractionDTO;

import java.util.List;

public class OrderDTO {
    public Integer IdCustomer;
    public Integer IdSupplier;
    public double ShipmentPrice;
    public List<ItemDTO> items;

    public Integer getIdCustomer() {
        return IdCustomer;
    }

    public Integer getIdSupplier() {
        return IdSupplier;
    }

    public double getShipmentPrice() {
        return ShipmentPrice;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setIdCustomer(Integer idCustomer) {
        IdCustomer = idCustomer;
    }

    public void setIdSupplier(Integer idSupplier) {
        IdSupplier = idSupplier;
    }

    public void setShipmentPrice(double shipmentPrice) {
        ShipmentPrice = shipmentPrice;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}
