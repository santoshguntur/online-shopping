package net.gsk.shoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Product {

	 public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitprice=" + unitprice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + "]";
	}
	 
	//Default constructer 
	public Product(){
		this.code="PRD"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	 
	 
	 private int id;
	 private String code;
	 @NotNull(message="Please enter the Product Name")
	 private String name;
	 @NotNull(message="Please enter the Brand name")
	 private String brand;
	 @JsonIgnore
	 private String description;
	 @Column(name="unit_price")
	 private double unitprice; 
	 private int quantity;
	 @JsonIgnore
	 @Column(name="is_active")
	 private boolean active;
	 @JsonIgnore
	 @Column(name="category_id")
	 @JoinColumn(name="id")
	 private int categoryId;
	 @JsonIgnore
	 @Column(name="supplier_id")
	 private int supplierId;
	 private int purchases;	 
	 private int views;
}
