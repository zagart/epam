package by.epam.grodno.training.java.zagart.se02.task2;

abstract public class OfficeInstruments extends Stationery {
	
	public OfficeInstruments() {
		setDescription("Класс офисных принадлежностей.");
	}
	
	public OfficeInstruments(String name, int cost) {
		super(name, cost);
	}
	
}
