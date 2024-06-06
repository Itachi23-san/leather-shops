package com.example.leather_shop.repositories;

import com.example.leather_shop.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Iterable<Item> findByCategory(String category);
}
