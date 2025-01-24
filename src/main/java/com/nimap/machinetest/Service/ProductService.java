package com.nimap.machinetest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.machinetest.Entity.Product;
import com.nimap.machinetest.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllpProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long product_id) {
         productRepository.deleteById(product_id);
    }

    public Optional<Product> getProductById(Long product_id) {
        return productRepository.findById(product_id);
    }

    public Product updateProduct(Long product_id, Product newProduct) {
        Product oldProduct = productRepository.findById(product_id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + product_id));
        
                oldProduct.setName(newProduct.getName());
                oldProduct.setPrice(newProduct.getPrice());
                oldProduct.setCategory(newProduct.getCategory());
    
        return productRepository.save(oldProduct);
    }
    
    
}
