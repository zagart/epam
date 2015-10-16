package by.epam.grodno.training.java.zagart.se01.task8;

public class Worker {
	public Stationery stationery = new Stationery();
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void checkStationery () {
		System.out.println("У работника " + getName() + 
				" есть: ");
		if (stationery.pen.getValue() != 0) System.out.println("- ручка;");
		if (stationery.pensil.getValue() != 0) System.out.println("- карандаш;");
		if (stationery.eraser.getValue() != 0) System.out.println("- ластик;");
		if (stationery.ruler.getValue() != 0) System.out.println("- линейка;");
	}
	
	public Worker (String name, int pen, int pensil, int eraser, int ruler) {
		this.name = name;
		stationery.pen.setValue(pen);
		stationery.pensil.setValue(pensil);
		stationery.eraser.setValue(eraser);
		stationery.ruler.setValue(ruler);
	}
	
	public Worker () {
	}

	@Override
	public String toString() {
		return "Имя работника - " + name + 
				". Общая стоимость канцтоваров на рабочем месте - " + 
				(int)(stationery.pen.getValue() + stationery.pensil.getValue() +
						stationery.eraser.getValue() + stationery.ruler.getValue()) + "." ;
	}
	
	
}

