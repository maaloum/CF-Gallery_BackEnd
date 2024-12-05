package com.cfgallery.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfgallery.backend.models.SalesMan;

public interface SalesManRepository extends JpaRepository<SalesMan, Long>{
    
}
