package com.nimap.machinetest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.machinetest.Entity.Category;
import com.nimap.machinetest.Service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
   
    @Autowired
    private CategoryService categoryService;

    // GET all categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{category_Id}")
    public Optional<Category> getCategoryById(@PathVariable Long category_Id) {
        return categoryService.getCategoryById(category_Id);
    }

    // POST - Create a new category
    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    // DELETE - Delete a category by ID
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }

    @PutMapping("/{categoryId}")
    public Category updateCategory(@PathVariable Long categoryId, @RequestBody Category category ) {
        return categoryService.updateCategory(categoryId, category);
    }
}