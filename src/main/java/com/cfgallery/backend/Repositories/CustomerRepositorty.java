package com.cfgallery.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfgallery.backend.models.Customer;

public interface CustomerRepositorty extends  JpaRepository<Customer, Long>{
    
}
