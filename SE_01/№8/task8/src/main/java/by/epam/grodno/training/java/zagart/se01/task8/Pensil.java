package by.epam.grodno.training.java.zagart.se01.task8;

public class Pensil extends Stationery {

	private String type = null;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Pensil(int value, int quantity, String type) {
		super(value, quantity);
		this.type = type;
	}
	
	public Pensil(int value, int quantity) {
		super(value, quantity);
	}
	
	public Pensil() {
		
	}

}
