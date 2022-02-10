package com.example.ecommercelp2.Service.Services;

import com.example.ecommercelp2.Domain.Model.CustomerModel;
import com.example.ecommercelp2.Infrastructure.Exception.UserAlreadyExistsException;
import com.example.ecommercelp2.Infrastructure.Repositories.IRepositories.ICustomerRepository;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.CustomerDTO;
import com.example.ecommercelp2.Service.Services.Interface.ICustomerService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository _customerRepository;

    public CustomerService(ICustomerRepository _customerRepository) {
        this._customerRepository = _customerRepository;
    }

    public String addCustomer(CustomerModel model) {
        String ret = "";

        try {
            if (model != null) {
                var customerExists = _customerRepository.existsById(model.getId());

                if (!customerExists) {
                    _customerRepository.save(model);
                } else ret = "Customer already exists in our domain";
            }
        } catch (UserAlreadyExistsException e) {
            throw new UserAlreadyExistsException("Customer already exists in our domain");
        }

        return ret;
    }

    public CustomerDTO getCustomer(Integer id) {
        CustomerDTO ret = new CustomerDTO();

        try {
            var customerExists = _customerRepository.existsById(id);

            if (customerExists) {
                var customer = _customerRepository.getById(id);

                if (customer != null) {
                    ret.CustomerName = customer.getCustomerName();
                    ret.CustomerCPF = customer.getCustomerCPF();
                    ret.CustomerAddress = customer.getAddress();
                    ret.CustomerContact = customer.getContact();
                }

            }
        } catch (NotFoundException e) {
            throw new NotFoundException("Customer not found");
        }

        return ret;
    }
}
