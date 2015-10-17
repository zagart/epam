package by.epam.grodno.training.java.zagart.se01.task8;

public class Ruler extends Stationery {
	
	private int length = 0;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Ruler(int value, int quantity, int length) {
		super(value, quantity);
		this.length = length;
	}
	
	public Ruler(int value, int quantity) {
		super(value, quantity);
	}
	
	public Ruler() {
		
	}

}
