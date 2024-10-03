package com.example.dto;

import java.math.BigDecimal;

import com.example.model.Product;
import com.example.model.Store;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class ProductOrderDetailsDTO {
	@NotNull(message = "Product cannot be null.")
	private Product product;

	@NotNull(message = "Store cannot be null.")
	private Store store;

	@NotNull(message = "Shipment status cannot be null.")
	private String shipmentStatus;

	@Positive(message = "Total amount must be positive.")
	private BigDecimal totalAmount;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
