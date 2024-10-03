package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	// Custom query methods can be added here
 
	 Optional<Product> findProductsById(Long Id);

	List<Product> findByName(String name);
 
	List<Product> findByBrand(String brand);
 
	List<Product> findByColor(String color);
 
	List<Product> findByPriceBetween(double minPrice, double maxPrice);
 
	List<Product> findByCategory(String category);
 
}
 