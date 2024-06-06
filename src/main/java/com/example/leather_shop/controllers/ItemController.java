package com.example.leather_shop.controllers;

import com.example.leather_shop.models.Item;
import com.example.leather_shop.repositories.CategoryRepository;
import com.example.leather_shop.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;


@Controller
//@SessionAttributes("Cart")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/product/add")
    String appProduct(@RequestParam String title,
                      @RequestParam double price,
                      @RequestPart String photos,
                      @RequestParam String cat,
                      @RequestParam String clr,
                      @RequestParam String sz,
                      @RequestParam String descr,
                      @RequestParam String params) throws IOException {
        Item item = new Item();
        item.setTitle(title);
        item.setCategory(cat);
        item.setColor(clr);
        item.setPrice(price);
        item.setImage(photos);
        item.setSize(sz);
        item.setDescription(descr);
        item.setCharacteristics(params);

        itemRepository.save(item);

        return "redirect:/admin";
    }

    @PostMapping("/product/edit/{id}")
    String editProduct(@RequestParam String title,
                      @RequestParam double price,
                      @RequestPart String photos,
                      @RequestParam String cat,
                      @RequestParam String clr,
                      @RequestParam String sz,
                      @RequestParam String descr,
                      @RequestParam String params,
                       @PathVariable(value = "id") long id) throws IOException {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setTitle(title);
        item.setCategory(cat);
        item.setColor(clr);
        item.setPrice(price);
        item.setImage(photos);
        item.setSize(sz);
        item.setDescription(descr);
        item.setCharacteristics(params);

        itemRepository.save(item);

        return "redirect:/admin";
    }

    @GetMapping("/delete-item/{id}")
    String deleteItem(@PathVariable(value = "id") long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        itemRepository.delete(item);
        return "redirect:/admin";
    }

}
