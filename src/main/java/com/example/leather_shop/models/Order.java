package com.example.leather_shop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customer_order") //имя таблицы
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String comment;

    @JoinColumn(name = "item_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Item item;

    public Order(String name, String phone, String comment, Item items) {
        this.name = name;
        this.phone = phone;
        this.comment = comment;
        this.item = items;
    }
}
