package com.example.leather_shop.controllers;

import com.example.leather_shop.models.Cart;
import com.example.leather_shop.models.Item;
import com.example.leather_shop.models.Order;
import com.example.leather_shop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("Cart")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/new-order")
    String newOrder(@ModelAttribute("Cart") Cart cart,
                    @RequestParam String comment, @RequestParam String phone, @RequestParam String name) {

        for (Item oreder : cart.getItems()) {
            Order order = new Order(name, phone, comment, oreder);
            orderRepository.save(order);
        }
        cart.clearAll();
        return "redirect:/cart";
    }
}
