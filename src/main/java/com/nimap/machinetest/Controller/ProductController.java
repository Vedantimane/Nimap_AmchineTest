package com.nimap.machinetest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.nimap.machinetest.Entity.Product;
import com.nimap.machinetest.Service.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // CREATE - Create a new product
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // READ - Get all products with pagination
    @GetMapping
    public Page<Product> getAllProducts(Pageable pageable) {
        return productService.getAllpProducts(pageable);
    }

    // READ - Get a product by ID
    @GetMapping("/{product_Id}")
    public Optional<Product> getProductById(@PathVariable Long product_Id) {
        return productService.getProductById(product_Id);
    }

    // UPDATE - Update a product by ID
    @PutMapping("/{product_Id}")
    public Product updateProduct(@PathVariable Long product_Id, @RequestBody Product product) {
        return productService.updateProduct(product_Id, product);
    }

    // DELETE - Delete a product by ID
    @DeleteMapping("/{product_Id}")
    public void deleteProduct(@PathVariable Long product_Id) {
        productService.deleteProduct(product_Id);
    }
}
