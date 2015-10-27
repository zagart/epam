package by.epam.grodno.training.java.zagart.se02.task4.drawing;

import by.epam.grodno.training.java.zagart.se02.task4.Stationery;

abstract public class Drawing extends Stationery {
	
	public Drawing() {
		setDescription("Класс принадлежностей для рисования.");
	}

	public Drawing(String name, int cost) {
		super(name, cost);
	}
	
}
