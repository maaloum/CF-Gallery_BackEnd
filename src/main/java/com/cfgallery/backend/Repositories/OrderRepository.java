package com.cfgallery.backend.Repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfgallery.backend.models.CustomerOrder;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long>{
        List<CustomerOrder> findByCustomerId(Long id);
        Optional<CustomerOrder> findByIdAndCustomerId(Long id, Long customerId);
        void deleteByIdAndCustomerId(Long id, Long customerId);


}
