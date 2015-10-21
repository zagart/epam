package by.epam.grodno.training.java.zagart.se02.task3.office;

public class Ruler extends OfficeInstruments {

	private int length = 0;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Ruler() {
		super();
	}

	public Ruler(String name, int cost) {
		super(name, cost);
	}
	
}
