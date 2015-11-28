package by.grodno.zagart.dataaccess.model;

import java.math.BigDecimal;

public class Product {
	
	private Integer id;
	private String name;
	private String description;
	private BigDecimal cost;
	private Integer shopId;
	private BigDecimal deliverCost;
	private Integer productsQuantityLeft;
	private Short rating;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public BigDecimal getDeliverCost() {
		return deliverCost;
	}
	public void setDeliverCost(BigDecimal deliverPrice) {
		this.deliverCost = deliverPrice;
	}
	public Integer getProductsQuantityLeft() {
		return productsQuantityLeft;
	}
	public void setProductsQuantityLeft(Integer productsQuantityLeft) {
		this.productsQuantityLeft = productsQuantityLeft;
	}
	public Short getRating() {
		return rating;
	}
	public void setRating(Short rating) {
		this.rating = rating;
	}

}
