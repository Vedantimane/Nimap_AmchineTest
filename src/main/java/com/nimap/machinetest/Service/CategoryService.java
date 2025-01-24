package com.nimap.machinetest.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.machinetest.Entity.Category;
import com.nimap.machinetest.Repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Get all categories
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    // Get a category by ID
    public Optional<Category> getCategoryById(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isEmpty()) {
            throw new RuntimeException("Category not found with id: " + categoryId);
        }
        return category;
    }

    // Save a new category
    public Category saveCategory(Category category) {
        System.out.println("Added new category");
        return categoryRepository.save(category);
    }

    // Update a category by ID
    public Category updateCategory(Long categoryId, Category newCategory) {
        Category oldCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        oldCategory.setName(newCategory.getName());
        return categoryRepository.save(oldCategory);
    }

    // Delete a category by ID
    public void deleteCategory(Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new RuntimeException("Category not found with id: " + categoryId);
        }
        categoryRepository.deleteById(categoryId);
    }
}
