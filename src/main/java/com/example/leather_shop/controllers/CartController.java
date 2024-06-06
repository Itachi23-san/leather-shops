package com.example.leather_shop.controllers;

import com.example.leather_shop.models.Cart;
import com.example.leather_shop.models.Item;
import com.example.leather_shop.repositories.ItemRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("Cart")
public class CartController {

    @Autowired
    private ItemRepository itemRepository;

    @ModelAttribute("Cart")
    public Cart createShoppingCart() {
        return new Cart();
    }
    @GetMapping("/ShoppingCart/deleteall") //если посмотреть по ссылкам в html файлах
    public String deleteCart(@ModelAttribute("Cart") Cart cart) {
        cart.clearAll(); //очищаем корзину
        return "redirect:/cart"; //перемещаемся в корзину
    }

    @GetMapping("/deletecart/item/{id}")
    String deleteItem(@PathVariable(value = "id") long id, @ModelAttribute("Cart") Cart cart) {
        Item item = itemRepository.findById(id).orElseThrow();
        int cartId = cart.getItemIndex(item);
        cart.deleteItem(cartId);
        return "redirect:/cart";
    }

    @PostMapping("/add-cart/item/{id}")
    String addCart(@PathVariable(value = "id") long id, @ModelAttribute("Cart") Cart cart,
                   @RequestParam String username) {
        Item item = itemRepository.findById(id).orElseThrow();
        cart.addItem(item);
        cart.setUsername(username);
        return "redirect:/cart";
    }
}
