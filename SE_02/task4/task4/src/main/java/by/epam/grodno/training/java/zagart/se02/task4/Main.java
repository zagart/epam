package by.epam.grodno.training.java.zagart.se02.task4;

import static by.epam.grodno.training.java.zagart.se02.task4.Util.*;

import java.util.ArrayList;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		
		Group group = createGroupIntegerMarks("New Group", Subject.ENG);
		Group group1 = createGroupIntegerMarks("Группа №1", Subject.PHYS);
		Group group2 = createGroupFloatMarks("Группа №2", Subject.MATH);

		
		Student student = new Student("Артем", "Загребанцев");
		group.addStudent(student);
		group.addStudentMark(student, 10);
		group.addStudentMark(student, 10);
		group.addStudentMark(student, 10);
		group.addStudentMark(student, 10);
		group.addStudentMark(student, 10);

		
		group1.addRandomStudents(9);
		group1.printStudents();

		
		group2.addRandomStudents(9);
		countAverageMarks(group2);
		group2.printStudents();

		
		group.addRandomStudents(9);
		countAverageMarks(group);
		group.printStudents();

		
		getGroupsByStudent(student);
		getGroupsByStudent("Саша", "Иванов");
		
		System.out.println();
		
		group.findStudentResult("Саша", "Иванов");
		group.findStudentResult("Артем", "Загребанцев");
		

	}

}
