package com.cfgallery.backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfgallery.backend.Services.ItemService;
import com.cfgallery.backend.models.Item;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
    // Create a new Item
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item newItem = itemService.createItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }
    
    // Get all Items
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    
    // Get a single Item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    
    // Update an existing Item
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item updatedItem = itemService.updateItemById(id, item);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }
    
    // Delete an Item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllItems() {
        itemService.deleteAllItems();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}