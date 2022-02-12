package com.example.ecommercelp2.Service.DTO.AbstractionDTO;

import org.springframework.lang.Nullable;

public class CustomerDataChangeDTO {
    @Nullable
    public String CustomerName;
    @Nullable
    public String CustomerCPF;

    @Nullable
    public String getCustomerName() {
        return CustomerName;
    }

    @Nullable
    public String getCustomerCPF() {
        return CustomerCPF;
    }
}
