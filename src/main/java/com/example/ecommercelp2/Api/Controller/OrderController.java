package com.example.ecommercelp2.Api.Controller;

import com.example.ecommercelp2.Service.DTO.AbstractionDTO.OrderDTO;
import com.example.ecommercelp2.Service.Services.Interface.IOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService _orderService;

    public OrderController(IOrderService _orderService) {
        this._orderService = _orderService;
    }

    @PostMapping("/new")
    public String newOrder(@RequestBody OrderDTO orderDTO) {
        return _orderService.newOrder(orderDTO);
    }
}
