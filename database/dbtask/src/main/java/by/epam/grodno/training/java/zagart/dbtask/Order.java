package by.epam.grodno.training.java.zagart.dbtask;

import java.util.Date;

public class Order {

	private int id;
	private int shoppingCartId;
	private Date dateOfOrder;
	private Date dateOfDeliver;
	private String orderStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(int shoppingCartId) {
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
