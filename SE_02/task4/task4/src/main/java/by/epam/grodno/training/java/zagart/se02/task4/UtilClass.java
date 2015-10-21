package by.epam.grodno.training.java.zagart.se02.task4;

import java.util.ArrayList;

public class UtilClass {

public static ArrayList<Group> createGroups (ArrayList<Group> list) {
		
		Group group1 = new Group("Группа №1", Subject.MATH);
		group1.setStudentsList(addStudents(new ArrayList<Student>()));
		
		Group group2 = new Group("Группа №2", Subject.ENG);
		group2.setStudentsList(addStudents(new ArrayList<Student>()));
		group2.addStudent(new Student("Владислав", "Званкович"));
		
		list.add(group1);
		list.add(group2);
		
		return list;
	}
	
	public static ArrayList<Student> addStudents (ArrayList<Student> list) {
		list.add(new Student("Артем", "Загребанцев"));
		list.add(new Student("Иван", "Бутько"));
		list.add(new Student("Владислав", "Бородюк"));
		return list;
	}
	
	public static Group searchGroupByName(ArrayList<Group> list, String groupName) {
		for (Group g : list) {
			if (g.getGroupName() == groupName) return g;
		}
		return null;
	}
	
	public static ArrayList<Group> searchGroupsByStudent(ArrayList<Group> groupList, Student student) {
		ArrayList<Group> temp = new ArrayList<Group>();
		for (Group g : groupList) {
			for (Student s : g.getStudentsList()) {
				if (s.equals(student)) {
					temp.add(g);
				}
			}
		}
		return temp;
	}
	
}
