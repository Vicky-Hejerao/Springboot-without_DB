package com.jbk.model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Product {
    	
	private Long productId;
	private String productName;
	private Long supplierId;
	private Long categoryId;
	private int productQTY;
	private double productPrice;

	public Product() {

	}

	public Product(Long productId, String productName, Long supplierId, Long categoryId, int productQTY,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.productQTY = productQTY;
		this.productPrice = productPrice;
	}





	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {

		this.productId = productId;

	}

	public String getProductName() {

		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public int getProductQTY() {
		return productQTY;
	}

	public void setProductQTY(int productQTY) {
		this.productQTY = productQTY;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		
			this.productPrice = productPrice;
		
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierId=" + supplierId
				+ ", categoryId=" + categoryId + ", productQTY=" + productQTY + ", productPrice=" + productPrice + "]";
	}

}
