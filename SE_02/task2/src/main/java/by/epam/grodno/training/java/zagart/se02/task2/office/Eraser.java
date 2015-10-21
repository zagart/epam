package by.epam.grodno.training.java.zagart.se02.task2.office;

public class Eraser extends OfficeInstruments {

	private String color = null;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Eraser() {
		super();
	}

	public Eraser(String name, int cost) {
		super(name, cost);
	}
	
}
