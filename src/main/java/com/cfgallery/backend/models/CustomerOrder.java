package com.cfgallery.backend.models;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL)
    private Set<Item> items;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // public Object getOrderDate() {
    //     throw new UnsupportedOperationException("Unimplemented method 'getOrderDate'");
    // }4


}
