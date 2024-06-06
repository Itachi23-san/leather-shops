package com.example.leather_shop.controllers;

import com.example.leather_shop.models.Cart;
import com.example.leather_shop.models.Category;
import com.example.leather_shop.models.Item;
import com.example.leather_shop.repositories.CategoryRepository;
import com.example.leather_shop.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Controller
@SessionAttributes("Cart")
public class MainController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping({"/index", "/", "/main", "/page-main.html"})
    String index(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "page-main";
    }

    @GetMapping("/page")
    String page() {
        return "page";
    }

    @GetMapping("/catalog")
    String catalog(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "page-catalog";
    }

    @GetMapping("/about")
    String about() {
        return "page-about";
    }

    @GetMapping("/admin")
    String admin(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        Iterable<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        model.addAttribute("categories", categories);
        return "page-admin";
    }

    @GetMapping("/admin-attr")
    String adminAttr(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "page-admin-attr";
    }

    @GetMapping("/cart")
    public String cart(Model model, @ModelAttribute("Cart") Cart cart) throws NoSuchAlgorithmException {
        Iterable<Item> items = cart.getItems();
        float total = 0.0f;
        for (Item item : items) {
            total += item.getPrice();
        }
        model.addAttribute("ShoppingCart", items);
        model.addAttribute("summ", total);
        System.out.println(total);
        return "page-cart";
    }

    @GetMapping("/category/{id}")
    String category(@PathVariable(value = "id") long id, Model model) {
        Category category = categoryRepository.findById(id).orElseThrow();
        Iterable<Item> items = itemRepository.findByCategory(category.getName());
        model.addAttribute("category", category.getName());
        model.addAttribute("items", items);
        return "page-category";
    }


    @GetMapping("/contacts")
    String contacts() {
        return "page-contacts";
    }

    @GetMapping("/novellties")
    String novellties() {
        return "page-novellties";
    }

    @GetMapping("/product/{id}")
    String product(@PathVariable(value = "id") long id, Model model) {
        Item item = itemRepository.findById(id).orElseThrow();
        model.addAttribute("item", item);
        return "page-product";
    }

}
