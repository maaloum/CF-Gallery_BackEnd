package com.cfgallery.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfgallery.backend.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
