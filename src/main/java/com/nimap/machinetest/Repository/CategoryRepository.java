package com.nimap.machinetest.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.machinetest.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
