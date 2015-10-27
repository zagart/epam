package by.epam.grodno.training.java.zagart.se02.task4.drawing;

public class Brush extends Drawing {

	private int size = 0;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Brush() {
		super();
	}

	public Brush(String name, int cost) {
		super(name, cost);
	}	
	
}
