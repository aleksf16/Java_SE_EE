package com.example.api1.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("items")
    public void addItem(@RequestBody final List<Item> Items)
    {
        itemRepository.saveAll(Items);
    }

    @GetMapping("items")
    public List<Item> findItems()
    {
        return itemRepository.findAll();
    }

    @GetMapping("items/{itemId}")
    public Item findItem(@PathVariable final String itemId)
    {
        return itemRepository.findById(itemId).orElseGet(Item::new);
    }

    @DeleteMapping("items/{itemId}")
    public void deleteById(@PathVariable final String itemId)
    {
        itemRepository.deleteById(itemId);
    }

}
