package com.example.ecommercelp2.Api;

import com.example.ecommercelp2.Domain.Model.CustomerModel;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.CustomerDTO;
import com.example.ecommercelp2.Service.Services.Interface.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    public final ICustomerService _customerService;

    public CustomerController(ICustomerService _customerService) {
        this._customerService = _customerService;
    }

    @PostMapping("/add")
    public String addCustomer(@RequestBody @Valid CustomerModel model) {
        return _customerService.addCustomer(model);
    }

    @GetMapping("/search/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") Integer id) {
        return _customerService.getCustomer(id);
    }

}
