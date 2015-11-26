package by.grodno.zagart.dataaccess.model;

import java.math.BigDecimal;

public class Coupon {
	
	private long id;
	private BigDecimal value;
	private long shopId;
	private long userId;
	private int userCouponQuantity;
	
	public int getUserCouponQuantity() {
		return userCouponQuantity;
	}
	public void setUserCouponQuantity(int userCouponQuantity) {
		this.userCouponQuantity = userCouponQuantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}


}
