package com.example.ecommercelp2.Service.Services.Interface;

import com.example.ecommercelp2.Service.DTO.AbstractionDTO.OrderDTO;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public interface IOrderService {
    String newOrder(OrderDTO orderDTO);
}
