package by.epam.grodno.training.java.zagart.se01.task8;

public class Pen extends Stationery {

	private String incColor;

	public String getIncColor() {
		return incColor;
	}

	public void setIncColor(String incColor) {
		this.incColor = incColor;
	}

	public Pen(int value, int quantity, String incColor) {
		super(value, quantity);
		this.incColor = incColor;
	}
	
	public Pen(int value, int quantity) {
		super(value, quantity);
	}
	
	public Pen() {
		
	}

}
