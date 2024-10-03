package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductDto;
import com.example.exceptions.list.BadRequestException;
import com.example.exceptions.list.InternalServerErrorException;
import com.example.exceptions.list.ResourceNotFoundException;
import com.example.services.IproductService;

@RestController

@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/api/v1/products")

public class ProductController {
 
	@Autowired

	private IproductService productService;

	@GetMapping

	public ResponseEntity<List<ProductDto>> getAllProducts() {

		List<ProductDto> products = productService.getAllProducts();

		if (products.isEmpty()) {

			throw new InternalServerErrorException("An internal server error occurred while fetching all products.");

		}

		return ResponseEntity.ok(products);

	}
 
	 @PostMapping(consumes = "application/json")

	    public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto) throws BadRequestException {

	        if (productDto.getName() == null || productDto.getName().isEmpty()) {

	            throw new BadRequestException("Invalid request. Please provide valid product data for creation.");

	        }
 
	     

	        if (productDto.getImage() != null && !productDto.getImage().isEmpty()) {

	        }
 
	        String message = productService.createProduct(productDto);

	        return ResponseEntity.status(HttpStatus.CREATED).body(message);

	    }
 
	    @PutMapping("/{id}")

	    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) throws ResourceNotFoundException {

	        if (productDto.getImage() != null && !productDto.getImage().isEmpty()) {

	        }
 
	        String message = productService.updateProduct(id, productDto);

	        return ResponseEntity.ok(message);

	    }

 
	// Get By category

	@GetMapping("/category/{category}")

	public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable("category") String category)

			throws ResourceNotFoundException {

		List<ProductDto> products = productService.findProductsByCategory(category);

		if (products.isEmpty()) {

			throw new ResourceNotFoundException("Products with the specified category not found.");

		}

		return ResponseEntity.ok(products);

	}

	@DeleteMapping("/{id}")

	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) throws ResourceNotFoundException {

		String message = productService.deleteProduct(id);

		return ResponseEntity.ok(message);

	}

	@GetMapping("/name/{name}")

	public ResponseEntity<List<ProductDto>> searchProductsByName(@PathVariable("name") String name)

			throws ResourceNotFoundException {

		List<ProductDto> products = productService.findProductsByName(name);

		if (products.isEmpty()) {

			throw new ResourceNotFoundException("Product(s) with the specified name not found.");

		}

		return ResponseEntity.ok(products);

	}

	@GetMapping("/brand/{brand}")

	public ResponseEntity<List<ProductDto>> getProductsByBrand(@PathVariable("brand") String brand)

			throws ResourceNotFoundException {

		List<ProductDto> products = productService.findProductsByBrand(brand);

		if (products.isEmpty()) {

			throw new ResourceNotFoundException("Products with the specified brand not found.");

		}

		return ResponseEntity.ok(products);

	}

	@GetMapping("/color/{color}")

	public ResponseEntity<List<ProductDto>> getProductsByColor(@PathVariable("color") String color)

			throws ResourceNotFoundException {

		List<ProductDto> products = productService.findProductsByColor(color);

		if (products.isEmpty()) {

			throw new ResourceNotFoundException("Products with the specified color not found.");

		}

		return ResponseEntity.ok(products);

	}

	@GetMapping("/price")

	public ResponseEntity<List<ProductDto>> getProductsByPriceRange(@RequestParam("min") double min, @RequestParam("max") double max)

			throws BadRequestException {

		List<ProductDto> products = productService.findProductsByPriceRange(min, max);

		if (products.isEmpty()) {

			throw new BadRequestException("Invalid request. Please provide valid minimum and maximum unit prices.");

		}

		return ResponseEntity.ok(products);

	}

    @GetMapping("/{id}")

    public ResponseEntity<ProductDto> getProductsById(@PathVariable Long id) throws BadRequestException  {

        ProductDto products = productService.findProductsById(id);

        return ResponseEntity.ok(products);

    }

	// Sort

	@GetMapping("/sort")

	public ResponseEntity<List<ProductDto>> sortProducts(@RequestParam("field") String field) throws BadRequestException {
 
		List<ProductDto> products = productService.sortProductsByField(field);

		if (products.isEmpty()) {

			throw new BadRequestException("Invalid request. Please provide a valid field for sorting.");

		}

		return ResponseEntity.ok(products);

	}
 
}

 