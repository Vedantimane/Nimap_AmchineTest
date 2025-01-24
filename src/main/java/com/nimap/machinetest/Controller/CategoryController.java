package com.nimap.machinetest.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    // CREATE - Add a new category
    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    // READ - Get all categories
    @GetMapping
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryService.getAllCategories(pageable);
    }

    // READ - Get a category by ID
    @GetMapping("/{category_Id}")
    public Optional<Category> getCategoryById(@PathVariable Long category_Id) {
        return categoryService.getCategoryById(category_Id);
    }

    // UPDATE - Update a category by ID
    @PutMapping("/{category_Id}")
    public Category updateCategory(@PathVariable Long category_Id, @RequestBody Category category) {
        return categoryService.updateCategory(category_Id, category);
    }

    // DELETE - Delete a category by ID
    @DeleteMapping("/{category_Id}")
    public void deleteCategory(@PathVariable Long category_Id) {
        categoryService.deleteCategory(category_Id);
    }
}
