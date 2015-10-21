package by.epam.grodno.training.java.zagart.se02.task2.writing;

public class Ink extends Writing {
	
	private int volume = 0;
	private String color = null;

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
		
	public Ink() {
		super();
	}

	public Ink(String name, int cost) {
		super(name, cost);
	}

}
