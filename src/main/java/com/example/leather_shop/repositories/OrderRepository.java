package com.example.leather_shop.repositories;

import com.example.leather_shop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
