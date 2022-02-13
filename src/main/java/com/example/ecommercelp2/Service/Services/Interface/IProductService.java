package com.example.ecommercelp2.Service.Services.Interface;

import com.example.ecommercelp2.Domain.Model.OrderModels.ProductModel;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public interface IProductService {
    String addProduct(ProductModel model);

    ProductModel searchProductById(Integer id);
}
