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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((deliverCost == null) ? 0 : deliverCost.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((productsQuantityLeft == null) ? 0 : productsQuantityLeft.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((shopId == null) ? 0 : shopId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (deliverCost == null) {
			if (other.deliverCost != null)
				return false;
		} else if (!deliverCost.equals(other.deliverCost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productsQuantityLeft == null) {
			if (other.productsQuantityLeft != null)
				return false;
		} else if (!productsQuantityLeft.equals(other.productsQuantityLeft))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (shopId == null) {
			if (other.shopId != null)
				return false;
		} else if (!shopId.equals(other.shopId))
			return false;
		return true;
	}

}
