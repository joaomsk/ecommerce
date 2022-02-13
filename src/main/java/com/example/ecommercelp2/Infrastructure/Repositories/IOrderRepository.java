package com.example.ecommercelp2.Infrastructure.Repositories;

import com.example.ecommercelp2.Domain.Model.OrderModels.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderModel, Integer> {
}