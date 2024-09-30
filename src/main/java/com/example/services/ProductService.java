package com.example.services;

import com.example.model.Product;
import com.example.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null); 
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setColor(productDetails.getColor());
            product.setBrand(productDetails.getBrand());
            product.setSize(productDetails.getSize());
            product.setRating(productDetails.getRating());
            product.setCategory(productDetails.getCategory());
            return productRepository.save(product);
        }
        return null; 
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
