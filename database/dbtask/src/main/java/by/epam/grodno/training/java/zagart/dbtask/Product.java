package by.epam.grodno.training.java.zagart.dbtask;

public class Product {
	
	private int id;
	private String name;
	private String description;
	private int cost;
	private int shopId;
	private int deliverPrice;
	
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getDeliverPrice() {
		return deliverPrice;
	}
	public void setDeliverPrice(int deliverPrice) {
		this.deliverPrice = deliverPrice;
	}

}
