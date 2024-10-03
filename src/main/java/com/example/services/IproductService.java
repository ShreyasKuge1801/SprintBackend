package com.example.services;

import java.util.List;

import com.example.dto.ProductDto;
import com.example.exceptions.list.BadRequestException;
import com.example.exceptions.list.ResourceNotFoundException;

public interface IproductService {
	List<ProductDto> getAllProducts();

	String createProduct(ProductDto productDTO) throws BadRequestException;

	String updateProduct(Long productId, ProductDto productDto) throws ResourceNotFoundException;

	String deleteProduct(Long id) throws ResourceNotFoundException;

	List<ProductDto> findProductsByName(String name) throws ResourceNotFoundException;

	List<ProductDto> findProductsByBrand(String brand) throws ResourceNotFoundException;

	List<ProductDto> findProductsByColor(String color) throws ResourceNotFoundException;

	List<ProductDto> findProductsByPriceRange(double min, double max) throws BadRequestException;

	List<ProductDto> sortProductsByField(String field) throws BadRequestException;

	List<ProductDto> findProductsByCategory(String category) throws ResourceNotFoundException;

	ProductDto findProductsById(Long id) throws BadRequestException;

}