package by.epam.grodno.training.java.zagart.se02.task3.writing;

public class Pen extends Writing {
	
	private String inkColor = "синий";

	public String getInkColor() {
		return inkColor;
	}

	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}
	
	public Pen() {
		super();
	}

	public Pen(String name, int cost) {
		super(name, cost);
	}
	
}
