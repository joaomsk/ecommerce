package com.example.ecommercelp2.Service.Services.OrdersServices;

import com.example.ecommercelp2.Domain.Model.OrderModels.ProductModel;
import com.example.ecommercelp2.Infrastructure.Exception.AlreadyExistsException;
import com.example.ecommercelp2.Infrastructure.Repositories.IProductRepository;
import com.example.ecommercelp2.Service.Services.Interface.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final IProductRepository _productRepository;

    public ProductService(IProductRepository _productRepository) {
        this._productRepository = _productRepository;
    }

    public String addProduct(ProductModel model) {
        String ret = "";

        try {
            if (model != null) {
                var productExists = _productRepository.existsById(model.getIdProduct());

                if (!productExists) {
                    _productRepository.save(model);
                } else ret = "Product already registered in our domain";
            }
        } catch (AlreadyExistsException e) {
            throw new AlreadyExistsException("Product already exists in our doamin.");
        }

        return ret;
    }

    public ProductModel searchProductById(Integer id) {
        return _productRepository.findById(id).get();
    }
}
