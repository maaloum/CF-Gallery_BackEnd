package com.cfgallery.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfgallery.backend.Services.CustomerService;
import com.cfgallery.backend.models.Customer;
import com.cfgallery.backend.models.CustomerOrder;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    
    private final CustomerService serviceCustomer;

    public CustomerController(CustomerService serviceCustomer){
        this.serviceCustomer = serviceCustomer;
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return this.serviceCustomer.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return this.serviceCustomer.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return this.serviceCustomer.createCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable Long id){
        this.serviceCustomer.deleteCustomerById(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomerById(@PathVariable Long id, @RequestBody Customer customer){
        return this.serviceCustomer.updateCustomerById(id, customer);
    }

    @DeleteMapping
    public void deleteAllCustomers(){
        this.serviceCustomer.deleteAllCustomers();
    }
    @GetMapping("/{id}/orders")
    public List<CustomerOrder> getCustomerOrders(@PathVariable Long id){
        return this.serviceCustomer.getCustomerOrders(id);
    }

    @GetMapping("/{id}/orders/{orderId}")
    public CustomerOrder getCustomerOrderById(@PathVariable Long id, @PathVariable Long orderId){
        return this.serviceCustomer.getCustomerOrderById(id, orderId);
    }

    @PostMapping("/{id}/orders")
    public CustomerOrder createCustomerOrder(@PathVariable Long id, @RequestBody CustomerOrder order){
        return this.serviceCustomer.createCustomerOrder(id, order);
    }

    @DeleteMapping("/{id}/orders/{orderId}")
    public void deleteCustomerOrderById(@PathVariable Long id, @PathVariable Long orderId){
        this.serviceCustomer.deleteCustomerOrderById(id, orderId);
    }

    @PutMapping("/{id}/orders/{orderId}")
    public CustomerOrder updateCustomerOrderById(@PathVariable Long id, @PathVariable Long orderId, @RequestBody CustomerOrder order){
        return this.serviceCustomer.updateCustomerOrderById(id, orderId, order);
    }

    @DeleteMapping("/{id}/orders")
    public void deleteAllCustomerOrders(@PathVariable Long id){
        this.serviceCustomer.deleteAllCustomerOrders(id);
    }
}


