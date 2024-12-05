package com.cfgallery.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cfgallery.backend.Repositories.ItemRepository;
import com.cfgallery.backend.Repositories.OrderRepository;
import com.cfgallery.backend.models.CustomerOrder;
import com.cfgallery.backend.models.Item;
@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository){
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
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


public CustomerOrder addItemsToOrder(Long orderId, List<Item> items) {
    // Fetch the CustomerOrder by orderId
    Optional<CustomerOrder> optionalOrder = orderRepository.findById(orderId);
    // if (optionalOrder.isEmpty()) {

    //     throw new ResourceNotFoundException("Order not found with id: " + orderId);
    // }
    CustomerOrder order = optionalOrder.get();

    // Fetch the items by the provided itemIds
    // List<Item> items = itemRepository.findAllById(itemIds);
    System.out.println("items: " + items);

    // if (items.isEmpty()) {
    //     throw new ResourceNotFoundException("No items found with the given IDs");
    // }

    for (Item item : items) {
        item.setCustomerOrder(order);  // This binds the item to the order
    }

    // Save the updated items
    itemRepository.saveAll(items);

    // Return the updated order
    return orderRepository.save(order);
}

}
