package com.example.ecommercelp2.Service.Services.Interface;

import com.example.ecommercelp2.Domain.Model.CustomerModel;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.CustomerDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan
public interface ICustomerService {
    String addCustomer(CustomerModel model);
    CustomerDTO getCustomer(Integer id);
}
