package by.grodno.zagart.dataaccess.model;

import java.math.BigDecimal;

public class ShoppingCart {
	
	private long id;
	private long userId;
	private long orderListId;
	private BigDecimal totalTost;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductListId() {
		return orderListId;
	}
	public void setProductListId(Long productListId) {
		this.orderListId = productListId;
	}
	public BigDecimal getTotalTost() {
		return totalTost;
	}
	public void setTotalTost(BigDecimal totalTost) {
		this.totalTost = totalTost;
	}

}
