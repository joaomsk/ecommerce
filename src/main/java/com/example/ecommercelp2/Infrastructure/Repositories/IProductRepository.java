package com.example.ecommercelp2.Infrastructure.Repositories;

import com.example.ecommercelp2.Domain.Model.OrderModels.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<ProductModel, Integer> {
    @Override
    <S extends ProductModel> S save(S entity);

    @Override
    long count();

    @Override
    void delete(ProductModel entity);

    @Override
    void deleteAll();

    @Override
    void deleteAll(Iterable<? extends ProductModel> entities);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Optional<ProductModel> findById(Integer integer);
}