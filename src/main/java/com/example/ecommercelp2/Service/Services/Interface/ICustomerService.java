package com.example.ecommercelp2.Service.Services.Interface;

import com.example.ecommercelp2.Domain.Model.CustomerModel;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.CustomerDTO;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.CustomerDataChangeDTO;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public interface ICustomerService {
    String addCustomer(CustomerModel model);
    CustomerDTO getCustomer(Integer id);
    String deleteCustomer(Integer id);
    String pathCustomer(CustomerDataChangeDTO model, Integer id);

}
