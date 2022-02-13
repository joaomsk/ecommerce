package com.example.ecommercelp2.Service.Services.OrdersServices;

import com.example.ecommercelp2.Domain.Model.OrderModels.ItemModel;
import com.example.ecommercelp2.Domain.Model.OrderModels.OrderModel;
import com.example.ecommercelp2.Domain.Model.OrderModels.ProductModel;
import com.example.ecommercelp2.Infrastructure.Exception.InvalidDomainException;
import com.example.ecommercelp2.Infrastructure.Repositories.*;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.ItemDTO;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.OrderDTO;
import com.example.ecommercelp2.Service.Services.Interface.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    private final IOrderRepository _orderRepository;
    private final ItemRepository _itemRepository;
    private final IProductRepository _productRepository;
    private final ICustomerRepository _customerRepository;
    private final ISupplierRepository _supplierRepository;

    public OrderService(IOrderRepository _orderRepository, ItemRepository _itemRepository, IProductRepository _productRepository, ICustomerRepository _customerRepository, ISupplierRepository _supplierRepository) {
        this._orderRepository = _orderRepository;
        this._itemRepository = _itemRepository;
        this._productRepository = _productRepository;
        this._customerRepository = _customerRepository;
        this._supplierRepository = _supplierRepository;
    }

    public String newOrder(OrderDTO orderDTO) {
        String ret = "";

        try {
            if (orderDTO != null) {
                var customerExist = _customerRepository.existsById(orderDTO.getIdCustomer());
                var supplierExist = _supplierRepository.existsById(orderDTO.getIdSupplier());

                if (customerExist && supplierExist) {
                    var customer = _customerRepository.getById(orderDTO.getIdCustomer());
                    var supplier = _supplierRepository.getById(orderDTO.getIdSupplier());

                    var order = new OrderModel(
                            1,
                            supplier,
                            customer,
                            null,
                            orderDTO.getShipmentPrice()
                    );

                    for (ItemDTO item :
                            orderDTO.getItems()) {
                        ProductModel product = _productRepository.getById(item.getIdProduct());
                        ItemModel itemModel = new ItemModel(product, item.getQuantityProduct());

                        order.AddItem(itemModel);
                        _itemRepository.save(itemModel);
                    }

                    _orderRepository.save(order);
                } else ret = "Customer or Supplier not found in our domain.";

            } else ret = "OrderDTO can't be null";

        } catch (InvalidDomainException e) {
            throw new InvalidDomainException("Error creating new order.");
        }

        return ret;
    }
}
