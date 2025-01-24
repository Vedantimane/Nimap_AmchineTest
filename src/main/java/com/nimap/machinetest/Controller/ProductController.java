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

import com.nimap.machinetest.Entity.Product;
import com.nimap.machinetest.Service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    // GET all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllpProducts();
    }

    @GetMapping("/{product_Id}")
    public Optional<Product> getProductById(@PathVariable Long product_Id) {
        return productService.getProductById(product_Id);
    }

    // POST - Create a new product
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // DELETE - Delete a product by ID
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/{productId}")
public Product updateProduct(@PathVariable Long productId, @RequestBody Product product) {
    return productService.updateProduct(productId, product);
}


    
  
}