package com.cfgallery.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cfgallery.backend.Repositories.*;
import com.cfgallery.backend.models.Customer;
import com.cfgallery.backend.models.CustomerOrder;

@Service
public class CustomerService {
    
    private final CustomerRepositorty customerRepository;
    private final OrderRepository orderRepository;

    public CustomerService(CustomerRepositorty customerRepository, OrderRepository orderRepository){
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    // Get all customers
    public List<Customer> getAllCustomers(){
        return this.customerRepository.findAll();
    }

    // Get customer by ID
    public Customer getCustomerById(Long id){
        return this.customerRepository.findById(id).orElseThrow();
    }

    // Create a new customer
    public Customer createCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    // Delete customer by ID
    public void deleteCustomerById(Long id){
        this.customerRepository.deleteById(id);
    }

    // Update customer by ID
    public Customer updateCustomerById(Long id, Customer customer){
        Customer existingCustomer = getCustomerById(id);
        // Update the existing customer with the new values
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setSecondNumber(customer.getSecondNumber());
        existingCustomer.setSignature(customer.getSignature());
        return this.customerRepository.save(existingCustomer);
    }

    public void deleteAllCustomers(){
        this.customerRepository.deleteAll();
    }

    public List<CustomerOrder> getCustomerOrders(Long id){
        return this.orderRepository.findByCustomerId(id);
    }
    
    public CustomerOrder getCustomerOrderById(Long id, Long orderId){
        return this.orderRepository.findByIdAndCustomerId(orderId, id).orElseThrow();
    }
    
    public CustomerOrder createCustomerOrder(Long id, CustomerOrder order){
        Customer customer = getCustomerById(id);
        order.setCustomer(customer);
        return this.orderRepository.save(order);
    }
    
    public void deleteCustomerOrderById(Long id, Long orderId){
        this.orderRepository.deleteByIdAndCustomerId(orderId, id);
    }
    
    public CustomerOrder updateCustomerOrderById(Long id, Long orderId, CustomerOrder order){
        CustomerOrder existingOrder = getCustomerOrderById(id, orderId);
        // existingOrder.setOrderDate(order.getOrderDate());
        // existingOrder.setTotal(order.getTotal());
        return this.orderRepository.save(existingOrder);
    }
    
    public void deleteAllCustomerOrders(Long id){
        this.orderRepository.deleteById(id);
    }
}