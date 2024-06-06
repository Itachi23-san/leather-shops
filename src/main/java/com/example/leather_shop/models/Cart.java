package com.example.leather_shop.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Cart {

    private List<Item> items;
    private String username;

    public Cart() {
        items = new ArrayList<>();
    }

    public void clearAll() {
        items.clear();
    }

    public void deleteItem(int id) {
        items.remove(id+1);
    }

    public int getItemIndex(Item item) {
        return items.indexOf(item);
    }

    public void addItem(Item item) {
        items.add(item);
    }

}
