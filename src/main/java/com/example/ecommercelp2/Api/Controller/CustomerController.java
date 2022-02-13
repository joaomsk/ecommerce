package com.example.ecommercelp2.Api.Controller;

import com.example.ecommercelp2.Domain.Model.CustomerModel;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.CustomerDTO;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.CustomerDataChangeDTO;
import com.example.ecommercelp2.Service.Services.Interface.ICustomerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerService _customerService;

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

    @PatchMapping("/edit/{id}")
    public String putCustomer(@RequestBody @Valid CustomerDataChangeDTO model, @PathVariable("id") Integer id) {
        return _customerService.pathCustomer(model, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id) {
        return _customerService.deleteCustomer(id);
    }
}
