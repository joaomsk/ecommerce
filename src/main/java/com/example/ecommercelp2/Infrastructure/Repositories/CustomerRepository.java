package com.example.ecommercelp2.Infrastructure.Repositories;

import com.example.ecommercelp2.Domain.Model.CustomerModel;
import com.example.ecommercelp2.Infrastructure.Repositories.IRepositories.ICustomerRepository;
import com.example.ecommercelp2.Infrastructure.ValueObject.CustomerVO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer>, JpaSpecificationExecutor<CustomerModel>, ICustomerRepository {

    @Override
    Optional<CustomerModel> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    CustomerModel getById(Integer integer);

    @Override
    <S extends CustomerModel> S save(S entity);

}