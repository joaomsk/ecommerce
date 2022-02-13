package com.example.ecommercelp2.Domain.Model.OrderModels;

import com.example.ecommercelp2.Domain.Model.CustomerModel;
import com.example.ecommercelp2.Domain.Model.SupplierModel;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    private LocalDateTime DateOrder;

    @Valid
    @ManyToOne
    @JoinColumn(name = "id_supplier")
    @NotNull(message = "Supplier can't be null.")
    private SupplierModel Supplier;

    @Valid
    @ManyToOne
    @JoinColumn(name = "id_customer")
    @NotNull(message = "Customer can't be null")
    private CustomerModel Customer;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL})
    private List<ItemModel> items = new ArrayList<>();

    private Double ShipmentPrice;

    private Double TotalOrderPrice;

    @Deprecated
    public OrderModel() {
    }

    public OrderModel(Integer idOrder, SupplierModel supplier, CustomerModel customer, ItemModel item, Double shipmentPrice) {
        this.idOrder = idOrder;
        this.DateOrder = LocalDateTime.now();
        this.Supplier = supplier;
        this.Customer = customer;
        this.ShipmentPrice = shipmentPrice;
        AddItem(item);
    }

    private void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    private void setDateOrder(LocalDateTime dateOrder) {
        DateOrder = dateOrder;
    }

    private void setSupplier(SupplierModel supplier) {
        Supplier = supplier;
    }

    private void setCustomer(CustomerModel customer) {
        Customer = customer;
    }

    private void setItems(List<ItemModel> items) {
        this.items = items;
    }

    private void setShipmentPrice(Double shipmentPrice) {
        ShipmentPrice = shipmentPrice;
    }

    private void setTotalOrderPrice(Double totalOrderPrice) {
        TotalOrderPrice = totalOrderPrice;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public LocalDateTime getDateOrder() {
        return DateOrder;
    }

    public SupplierModel getSupplier() {
        return Supplier;
    }

    public CustomerModel getCustomer() {
        return Customer;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public Double getShipmentPrice() {
        return ShipmentPrice;
    }

    public Double getTotalOrderPrice() {
        return getTotalItemsPrice() + getShipmentPrice();
    }

    public double getTotalItemsPrice() {
        double TotalPrice = 0;

        for (ItemModel item : items) {
            TotalPrice += item.getTotalPriceItem();
        }

        return TotalPrice;
    }

    public void AddItem(ItemModel item) {
        if (item == null) {
            return;
        }

        item.setOrder(this);
        this.items.add(item);
    }
}
