package com.example.ecommercelp2.Api.Controller;

import com.example.ecommercelp2.Infrastructure.Repositories.Interface.IAddressRepository;
import com.example.ecommercelp2.Service.InternalService.Interface.IAddressService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@Api(value = "Address")
public class AddressController {

    private IAddressService _AddressService;
    private IAddressRepository _AddressRepository;

    public AddressController() {
        this._AddressService = _AddressService;
        this._AddressRepository = _AddressRepository;
    }
}
