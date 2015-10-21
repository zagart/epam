package by.epam.grodno.training.java.zagart.se02.task3.drawing;

import by.epam.grodno.training.java.zagart.se02.task3.Stationery;

abstract public class Drawing extends Stationery {
	
	public Drawing() {
		setDescription("Класс принадлежностей для рисования.");
	}

	public Drawing(String name, int cost) {
		super(name, cost);
	}
	
}
