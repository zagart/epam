package by.epam.grodno.training.java.zagart.se02.task2.drawing;

public class Crayon extends Drawing {
	
	private String color = null;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Crayon() {
		super();
	}

	public Crayon(String name, int cost) {
		super(name, cost);
	}		

}
