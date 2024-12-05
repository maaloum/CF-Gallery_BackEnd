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

import com.cfgallery.backend.Services.OrderService;
import com.cfgallery.backend.models.CustomerOrder;
import com.cfgallery.backend.models.Item;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderCustomerService;
    
    // Create a new OrderCustomer
    @PostMapping
    public ResponseEntity<CustomerOrder> createCustomerOrder(@RequestBody CustomerOrder CustomerOrder) {
        CustomerOrder newCustomerOrder = orderCustomerService.createOrder(CustomerOrder);
        return new ResponseEntity<>(newCustomerOrder, HttpStatus.CREATED);
    }
    
    // Get all CustomerOrders
    @GetMapping
    public ResponseEntity<List<CustomerOrder>> getAllCustomerOrders() {
        List<CustomerOrder> CustomerOrders = orderCustomerService.getAllOrders();
        return new ResponseEntity<>(CustomerOrders, HttpStatus.OK);
    }
    
    // Get a single CustomerOrder by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> getCustomerOrderById(@PathVariable Long id) {
        CustomerOrder CustomerOrder = orderCustomerService.getOrderById(id);
        return new ResponseEntity<>(CustomerOrder, HttpStatus.OK);
    }
    
    // Update an existing CustomerOrder
    @PutMapping("/{id}")
    public ResponseEntity<CustomerOrder> updateCustomerOrder(@PathVariable Long id, @RequestBody CustomerOrder CustomerOrder) {
        CustomerOrder updatedOrderCustomer = orderCustomerService.updateOrderById(id, CustomerOrder);
        return new ResponseEntity<>(updatedOrderCustomer, HttpStatus.OK);
    }
    
    // Delete an OrderCustomer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderCustomer(@PathVariable Long id) {
        orderCustomerService.deleteOrderById(id);;
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllOrders() {
        orderCustomerService.deleteAllOrders();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    @PostMapping("/{orderId}/items")
    public CustomerOrder addItemsToOrder(@PathVariable Long orderId, @RequestBody List<Item> items) {
        System.out.println("itemIds" + items);
        return orderCustomerService.addItemsToOrder(orderId, items);       
    }


}
