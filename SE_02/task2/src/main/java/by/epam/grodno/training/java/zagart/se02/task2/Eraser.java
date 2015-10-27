package by.epam.grodno.training.java.zagart.se02.task2;

public class Eraser extends Stationery {

	private String color = null;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Eraser(int value, int quantity, String color) {
		super(value, quantity);
		this.color = color;
	}
	
	public Eraser(int value, int quantity) {
		super(value, quantity);
	}
	
	public Eraser() {
		
	}

}
