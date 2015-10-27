package by.epam.grodno.training.java.zagart.se02.task4.office;

public class Stapler extends OfficeInstruments {

	private int staplingSheets = 0;
	private int depthCapture = 0;

	public int getStaplingSheets() {
		return staplingSheets;
	}

	public void setStaplingSheets(int staplingSheets) {
		this.staplingSheets = staplingSheets;
	}

	public int getDepthCapture() {
		return depthCapture;
	}

	public void setDepthCapture(int depthCapture) {
		this.depthCapture = depthCapture;
	}
	
	public Stapler() {
		super();
	}
	
	public Stapler(String name, int cost) {
		super(name, cost);
	}
	
}
