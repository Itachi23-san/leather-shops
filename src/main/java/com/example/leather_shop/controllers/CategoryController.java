package com.example.leather_shop.controllers;

import com.example.leather_shop.models.Category;
import com.example.leather_shop.models.Item;
import com.example.leather_shop.repositories.CategoryRepository;
import com.example.leather_shop.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("Cart")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/add-category")
    String addCategory(@RequestParam String title) {
        Category category = new Category();
        category.setName(title);
        category.setImage("https://i.pinimg.com/originals/b8/12/21/b812219c9e38232ad8cedb16c38e460a.jpg");
        categoryRepository.save(category);
        return "redirect:/admin-attr";
    }

    @PostMapping("/edit-category/{id}")
    String editCategory(@RequestParam String title, @PathVariable(value = "id") long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(title);
        category.setImage("https://i.pinimg.com/originals/b8/12/21/b812219c9e38232ad8cedb16c38e460a.jpg");
        categoryRepository.save(category);
        return "redirect:/admin-attr";
    }

    @GetMapping("/delete-category/{id}")
    String delete(@PathVariable(value = "id") long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        Iterable<Item> items = itemRepository.findByCategory(category.getName());
        if (items != null) {
            for (Item item : items) {
                itemRepository.delete(item);
            }
        }
        categoryRepository.delete(category);

        return "redirect:/admin-attr";
    }
}
