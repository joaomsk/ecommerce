package com.example.ecommercelp2.Service.Services;

import com.example.ecommercelp2.Domain.Model.SupplierModel;
import com.example.ecommercelp2.Infrastructure.Exception.UserAlreadyExistsException;
import com.example.ecommercelp2.Infrastructure.Repositories.ISupplierRepository;
import com.example.ecommercelp2.Service.DTO.AbstractionDTO.SupplierDTO;
import com.example.ecommercelp2.Service.Services.Interface.ISupplierService;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class SupplierService implements ISupplierService {

    private final ISupplierRepository _supplierRepository;

    public SupplierService(ISupplierRepository _supplierRepository) {
        this._supplierRepository = _supplierRepository;
    }

    public String addSupplier(SupplierModel model) {
        var ret = "";

        try {
            if (model != null) {
                var customerExists = _supplierRepository.existsById(model.getId());

                if (!customerExists) {
                    _supplierRepository.save(model);
                } else ret = "Supplier already exists in our domain";
            }
        } catch (UserAlreadyExistsException e) {
            throw new UserAlreadyExistsException("Supplier already exists in our domain");
        }

        return ret;
    }

    public SupplierDTO getSupplier(Integer id) {
        SupplierDTO ret = new SupplierDTO();

        try {
            var SupplierExists = _supplierRepository.existsById(id);

            if (SupplierExists) {
                var supplier = _supplierRepository.getById(id);

                if (supplier != null) {
                    ret.SupplierName = supplier.getSupplierName();
                    ret.SupplierCNPJ = supplier.getSupplierCNPJ();
                    ret.SupplierAddress = supplier.getAddress();
                    ret.SupplierContact = supplier.getContact();
                }
            }
        } catch (NotFoundException e) {
            throw new NotFoundException("Supplier not found");
        }

        return ret;
    }

    public String deleteSupplier(Integer id) {
        String ret = "";

        try {
            var customerExists = _supplierRepository.existsById(id);

            if (customerExists) {
                _supplierRepository.deleteById(id);
            } else ret = "Supplier not found";
        } catch (NotFoundException e) {
            throw new NotFoundException("Supplier not found in our domain");
        }

        return ret;
    }
}
