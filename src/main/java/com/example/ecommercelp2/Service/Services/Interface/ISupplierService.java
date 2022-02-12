package com.example.ecommercelp2.Service.Services.Interface;

import com.example.ecommercelp2.Domain.Model.SupplierModel;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.SupplierDTO;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public interface ISupplierService {
    String addSupplier(SupplierModel model);
    SupplierDTO getSupplier(Integer id);
    String deleteSupplier(Integer id);
}
