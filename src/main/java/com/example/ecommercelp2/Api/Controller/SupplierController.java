package com.example.ecommercelp2.Api.Controller;

import com.example.ecommercelp2.Domain.Model.SupplierModel;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.SupplierDTO;
import com.example.ecommercelp2.Service.Services.Interface.ISupplierService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private final ISupplierService _supplierService;

    public SupplierController(ISupplierService _supplierService) {
        this._supplierService = _supplierService;
    }

    @PostMapping("/add")
    public String addSupplier(@RequestBody @Valid SupplierModel model) {
        return _supplierService.addSupplier(model);
    }

    @GetMapping("/search/{id}")
    public SupplierDTO getSupplier(@PathVariable("id") Integer id) {
        return _supplierService.getSupplier(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable("id") Integer id) {
        return _supplierService.deleteSupplier(id);
    }

}
