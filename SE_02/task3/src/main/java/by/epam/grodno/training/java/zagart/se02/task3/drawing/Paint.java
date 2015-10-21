package by.epam.grodno.training.java.zagart.se02.task3.drawing;

public class Paint extends Drawing {

	private String type = null;
	private int colorsQuantity = 0;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getColorsQuantity() {
		return colorsQuantity;
	}

	public void setColorsQuantity(int colorsQuantity) {
		this.colorsQuantity = colorsQuantity;
	}

	public Paint() {
		super();
	}

	public Paint(String name, int cost) {
		super(name, cost);
	}

}
