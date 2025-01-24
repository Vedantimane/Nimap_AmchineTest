package com.nimap.machinetest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.machinetest.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
