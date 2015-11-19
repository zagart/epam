package by.epam.grodno.training.java.zagart.dbtask.model;

import java.math.BigDecimal;

public class Coupon {
	
	private int id;
	private BigDecimal value;
	private int shopId;
	private int userId;
	private int userCouponQuantity;
	
	public int getUserCouponQuantity() {
		return userCouponQuantity;
	}
	public void setUserCouponQuantity(int userCouponQuantity) {
		this.userCouponQuantity = userCouponQuantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}


}
