package by.grodno.zagart.dataaccess.model;

import java.math.BigDecimal;

public class ShoppingCart {
	
	private Integer id;
	private Integer userId;
	private Integer orderListId;
	private BigDecimal totalTost;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getOrderListId() {
		return orderListId;
	}
	public void setOrderListId(Integer orderListId) {
		this.orderListId = orderListId;
	}
	public BigDecimal getTotalTost() {
		return totalTost;
	}
	public void setTotalTost(BigDecimal totalTost) {
		this.totalTost = totalTost;
	}
	
}
