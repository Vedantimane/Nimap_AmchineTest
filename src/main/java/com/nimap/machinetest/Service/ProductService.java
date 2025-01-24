package com.nimap.machinetest.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.machinetest.Entity.Product;
import com.nimap.machinetest.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products with pagination
    public Page<Product> getAllpProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    // Get a product by ID
    public Optional<Product> getProductById(Long product_id) {
        return productRepository.findById(product_id);
    }

    // Save a new product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product by ID
    public Product updateProduct(Long product_id, Product newProduct) {
        Product oldProduct = productRepository.findById(product_id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + product_id));

        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setCategory(newProduct.getCategory());

        return productRepository.save(oldProduct);
    }

    // Delete a product by ID
    public void deleteProduct(Long product_id) {
        productRepository.deleteById(product_id);
    }
}
