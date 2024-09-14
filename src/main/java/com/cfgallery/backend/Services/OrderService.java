package com.cfgallery.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cfgallery.backend.Repositories.OrderRepository;
import com.cfgallery.backend.models.CustomerOrder;
@Service
public class OrderService {
    
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    // Get all orders
    public List<CustomerOrder> getAllOrders(){
        return this.orderRepository.findAll();
    }

    // Get order by ID
    public CustomerOrder getOrderById(Long id){
        return this.orderRepository.findById(id).orElseThrow();
    }

    // Create a new order
    public CustomerOrder createOrder(CustomerOrder order){
        return this.orderRepository.save(order);
    }

    // Delete order by ID
    public void deleteOrderById(Long id){
        this.orderRepository.deleteById(id);
    }

    // Update order by ID
    public CustomerOrder updateOrderById(Long id, CustomerOrder order){
        CustomerOrder existingOrder = getOrderById(id);
        // Update the existing order with the new values
        existingOrder.setCustomer(order.getCustomer());
        // existingOrder.setOrderDate(order.getOrderDate());
        // ... update other fields as needed
        return this.orderRepository.save(existingOrder);
    }

    public void deleteAllOrders(){
        this.orderRepository.deleteAll();
    }
}
