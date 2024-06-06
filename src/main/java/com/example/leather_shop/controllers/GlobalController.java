package com.example.leather_shop.controllers;

import com.example.leather_shop.models.Cart;
import com.example.leather_shop.models.Item;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@ControllerAdvice
@SessionAttributes("Cart")
public class GlobalController {

    @ModelAttribute
    public void globalAttributes(Model model, @ModelAttribute("Cart") Cart cart) {
        Iterable<Item> items = cart.getItems();
        int cartCount = 0;
        for (Item item : items) {
            cartCount += 1;
        }
        model.addAttribute("cartCount", cartCount);
    }
}
