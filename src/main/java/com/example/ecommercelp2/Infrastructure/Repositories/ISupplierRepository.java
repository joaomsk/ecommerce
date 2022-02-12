package com.example.ecommercelp2.Infrastructure.Repositories;

import com.example.ecommercelp2.Domain.Model.CustomerModel;
import com.example.ecommercelp2.Domain.Model.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplierRepository extends JpaRepository<SupplierModel, Integer>, JpaSpecificationExecutor<SupplierModel> {

    @Override
    SupplierModel getById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    <S extends SupplierModel> S save(S entity);

    @Override
    void deleteById(Integer integer);
}