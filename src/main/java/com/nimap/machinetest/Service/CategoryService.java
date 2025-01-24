package com.nimap.machinetest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.machinetest.Entity.Category;
import com.nimap.machinetest.Repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Save a new category
    public Category saveCategory(Category category) {
        System.out.println("Added new category");
        return categoryRepository.save(category);
    }

    // Delete a category by ID
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public Optional<Category> getCategoryById(Long category_id) {
        return categoryRepository.findById(category_id);
    }

    public Category updateCategory(Long category_id, Category newCategory) {
        Category oldCategory = categoryRepository.findById(category_id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + category_id));
        
        oldCategory.setName(newCategory.getName());

        return categoryRepository.save(oldCategory);
    }
}
