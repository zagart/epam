package by.grodno.zagart.dataaccess.model;

import java.util.Date;

import org.springframework.stereotype.Component;

public class Order {

	private Integer id;
	private Integer shoppingCartId;
	private Date dateOfOrder;
	private Date dateOfDeliver;
	private String orderStatus;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(Integer shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public Date getDateOfDeliver() {
		return dateOfDeliver;
	}
	public void setDateOfDeliver(Date dateOfDeliver) {
		this.dateOfDeliver = dateOfDeliver;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
