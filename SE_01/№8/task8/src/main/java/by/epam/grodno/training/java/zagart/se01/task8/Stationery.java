package by.epam.grodno.training.java.zagart.se01.task8;

public abstract class Stationery {
	private int value = 0;
	private int quantity = 0;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Stationery(int value, int quantity) {
		super();
		this.value = value;
		this.quantity = quantity;
	}

	public Stationery() {

	}

}
