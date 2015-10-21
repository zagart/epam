package by.epam.grodno.training.java.zagart.se02.task3.writing;

import by.epam.grodno.training.java.zagart.se02.task3.Stationery;

abstract public class Writing extends Stationery {
	
	public Writing() {
		setDescription("Класс письменных принадлежностей.");
	}
	
	public Writing(String name, int cost) {
		super(name, cost);
	}
		
}
