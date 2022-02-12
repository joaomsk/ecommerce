package com.example.ecommercelp2.Infrastructure.Repositories;

import com.example.ecommercelp2.Domain.Model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerModel, Integer>, JpaSpecificationExecutor<CustomerModel> {

    @Override
    void deleteById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    CustomerModel getById(Integer integer);

    @Override
    <S extends CustomerModel> S save(S entity);


}