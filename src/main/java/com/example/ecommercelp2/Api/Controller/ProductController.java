package com.example.ecommercelp2.Api.Controller;

import com.example.ecommercelp2.Domain.Model.OrderModels.ProductModel;
import com.example.ecommercelp2.Service.Services.Interface.IProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService _productService;

    public ProductController(IProductService _productService) {
        this._productService = _productService;
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody @Valid ProductModel model) {
        return _productService.addProduct(model);
    }
}
