package com.example.ecommercelp2.Infrastructure.Repositories;

import com.example.ecommercelp2.Infrastructure.Repositories.Interface.IAddressRepository;

public class AddressRepository implements IAddressRepository {

    private IAddressRepository _addressRepository;

    public AddressRepository(IAddressRepository _addressRepository) {
        this._addressRepository = _addressRepository;
    }
}
