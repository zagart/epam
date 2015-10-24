package by.epam.grodno.training.java.zagart.se02.task4;

import static by.epam.grodno.training.java.zagart.se02.task4.Util.*;

public class Main {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Group group = createGroupFloatMarks("New Group", Subject.ENG);
		Group group1 = createGroupIntegerMarks("Группа №1", Subject.PHYS);
		Group group2 = createGroupFloatMarks("Группа №2", Subject.MATH);

		Student student = new Student("Артем", "Загребанцев");
		group.addRandomStudents(9);
		countAverageMarks(group);
		group.printStudents();

		group1.addRandomStudents(9);
		group1.addStudent(student);
		group1.addStudentMark(student, 10);
		group1.addStudentMark(student, 10);
		group1.addStudentMark(student, 10);
		group1.addStudentMark(student, 10);
		group1.addStudentMark(student, 10);

		countAverageMarks(group1);
		group1.printStudents();

		group2.addRandomStudents(9);
		countAverageMarks(group2);
		group2.printStudents();

		getGroupsByStudent("Саша", "Иванов");
		group.findStudentResult("Саша", "Иванов");
		group1.findStudentResult("Саша", "Иванов");
		group2.findStudentResult("Саша", "Иванов");
		System.out.println();
		
		getGroupsByStudent(student);
		group.findStudentResult(student);
		group1.findStudentResult(student);
		group2.findStudentResult(student);

	}

}
