package by.epam.grodno.training.java.zagart.se02.task2;

public class Worker {
	
	private String name;
	Pen pen = new Pen();
	Pensil pensil = new Pensil();
	Ruler ruler = new Ruler();
	Eraser eraser = new Eraser();
	
	public void getStationery() {
		
		int totalValue = 0;
		
		if (pen != null) totalValue += pen.getValue() * pen.getQuantity();
		if (pensil != null) totalValue += pensil.getValue() * pensil.getQuantity();
		if (eraser != null) totalValue += eraser.getValue() * eraser.getQuantity();
		if (ruler != null) totalValue += ruler.getValue() * ruler.getQuantity();
		
		System.out.println("Общая стоимость канцтоваров у сотрудника " + name + ": " + totalValue + ".");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Worker(String name, Pen pen, Pensil pensil, Ruler ruler, Eraser eraser) {
		super();
		this.name = name;
		this.pen = pen;
		this.pensil = pensil;
		this.ruler = ruler;
		this.eraser = eraser;
	}

	public Worker(String name) {
		super();
		this.name = name;
	}

	public Worker() {

	}

}
