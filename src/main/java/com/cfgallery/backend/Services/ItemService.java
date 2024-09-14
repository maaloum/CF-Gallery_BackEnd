package com.cfgallery.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cfgallery.backend.Repositories.ItemRepository;
import com.cfgallery.backend.models.Item;

@Service
public class ItemService {
    
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems(){
        return this.itemRepository.findAll();
    }

    // Get item by ID
    public Item getItemById(Long id){
        return this.itemRepository.findById(id).orElseThrow();
    }

    // Create a new item
    public Item createItem(Item item){
        return this.itemRepository.save(item);
    }

    // Delete item by ID
    public void deleteItemById(Long id){
        this.itemRepository.deleteById(id);
    }

    // Update item by ID
    public Item updateItemById(Long id, Item item){
        Item existingItem = getItemById(id);
        existingItem.setName(item.getName());
        existingItem.setDescription(item.getDescription());
        // ... update other fields as needed
        return this.itemRepository.save(existingItem);
    }

    // Delete all items
    public void deleteAllItems(){
        this.itemRepository.deleteAll();
    }
}