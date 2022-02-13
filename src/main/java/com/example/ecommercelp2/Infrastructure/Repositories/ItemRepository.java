package com.example.ecommercelp2.Infrastructure.Repositories;

import com.example.ecommercelp2.Domain.Model.OrderModels.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemModel, Integer> {
}