package by.epam.grodno.training.java.zagart.dbtask.model;

import java.math.BigDecimal;

public class Product {
	
	private int id;
	private String name;
	private String description;
	private BigDecimal cost;
	private int shopId;
	private BigDecimal deliverPrice;
	private int productsQuantityLeft;
	
	public int getProductsQuantityLeft() {
		return productsQuantityLeft;
	}
	public void setProductsQuantityLeft(int productsQuantityLeft) {
		this.productsQuantityLeft = productsQuantityLeft;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public BigDecimal getDeliverPrice() {
		return deliverPrice;
	}
	public void setDeliverPrice(BigDecimal deliverPrice) {
		this.deliverPrice = deliverPrice;
	}

}
