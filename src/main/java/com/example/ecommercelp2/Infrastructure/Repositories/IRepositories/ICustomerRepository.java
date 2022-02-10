package com.example.ecommercelp2.Infrastructure.Repositories.IRepositories;

import com.example.ecommercelp2.Domain.Model.CustomerModel;
import com.example.ecommercelp2.Infrastructure.ValueObject.CustomerVO;
import jdk.jfr.Registered;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@ComponentScan
public interface ICustomerRepository {
    CustomerModel getById(Integer integer);
    boolean existsById(Integer integer);
    <S extends CustomerModel> S save(S entity);
}
