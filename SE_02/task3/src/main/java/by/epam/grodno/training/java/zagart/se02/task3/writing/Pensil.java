package by.epam.grodno.training.java.zagart.se02.task3.writing;

public class Pensil extends Writing {

	private String type = "твердый";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Pensil() {
		super();
	}
	
	public Pensil(String name, int cost) {
		super(name, cost);
	}
		
}
