package com.example.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ProductDto {

	private int id;
	@NotBlank(message = "Product name is required")

	@Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")

	@Pattern(regexp = "^[A-Za-z]+$", message = "Product name must contain only alphabets")

	private String name;

	@NotNull(message = "Unit price is mandatory")

	@Digits(integer = 10, fraction = 2, message = "Invalid unit price format")

	private Double price;

	@Pattern(regexp = "^[A-Za-z]+$", message = "Product name must contain only alphabets")

	private String color;

	@Pattern(regexp = "^[A-Za-z]+$", message = "Product name must contain only alphabets")

	private String brand;

	@NotBlank(message = "Product size is required")

	@Pattern(regexp = "^(XS|S|M|L|XL|XXL|XXXL)$", message = "Size must be one of the following: XS, S, M, L, XL, XXL, XXXL")

	private String size;

	@NotNull(message = "Rating is required")

	@Min(value = 1, message = "Rating must be at least 1")

	@Max(value = 5, message = "Rating must not exceed 5")

	private Integer rating;

	@Pattern(regexp = "^[A-Za-z]+$", message = "Product name must contain only alphabets")

	private String category;

	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}