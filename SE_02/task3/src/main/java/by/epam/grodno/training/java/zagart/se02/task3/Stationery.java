package by.epam.grodno.training.java.zagart.se02.task3;

abstract public class Stationery {
	
	private String name = null;
	private int cost = 0;
	private String description = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description; 
	}

	public Stationery(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
	
	public Stationery() {
		
	}
	
	@Override
	public String toString() {
		return this.getName() + ". Стоимость: " + this.getCost() + " руб. " + getDescription();
	}
	
}
