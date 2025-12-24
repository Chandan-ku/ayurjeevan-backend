package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Product;
import com.repo.ProductRepository;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // ✅ Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // ✅ Get product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // ✅ Add new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // ✅ Update existing product (including description, highlights, policy)
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProductOpt = repo.findById(id);

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setImageUrl(updatedProduct.getImageUrl());

            // new fields
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setHighlights(updatedProduct.getHighlights()); // JSON string or text
            existingProduct.setPolicies(updatedProduct.getPolicies());

            return repo.save(existingProduct);
        } else {
            return null;
        }
    }
    @PostMapping("/{id}/highlights")
    public Product updateHighlights(@PathVariable Long id, @RequestBody String highlightsJson) {
        Product product = repo.findById(id).orElseThrow();
        product.setHighlights(highlightsJson);
        return repo.save(product);
    }
    // ✅ Delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
