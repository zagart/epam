package by.epam.grodno.training.java.zagart.se02.task4;

import static by.epam.grodno.training.java.zagart.se02.task4.Util.*;

public class Main {

	public static void main(String[] args) {
	
		Group group = createGroup("Integer", "New Group", Subject.ENG);
		Group group1 = createGroup("Integer","Группа №1", Subject.PHYS);
		Group group2 = createGroup("Double", "Группа №2", Subject.MATH);
		
		group1.addRandomStudents(3);
		group1.printStudents();
		System.out.println();
		
		group2.addRandomStudents(2);
		group2.printStudents();
		System.out.println();
	
		group.addRandomStudents(1);
		group.printStudents();
		
	}
	
}
