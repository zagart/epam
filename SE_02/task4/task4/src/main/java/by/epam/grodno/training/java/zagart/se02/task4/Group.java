package by.epam.grodno.training.java.zagart.se02.task4;

import java.util.ArrayList;

public class Group {
	
	private String groupName = null;
	private ArrayList<Student> studentsList = new ArrayList<Student>();
	private Subject subject = null;

	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public ArrayList<Student> getStudentsList() {
		return studentsList;
	}
	public void setStudentsList(ArrayList<Student> studentsList) {
		this.studentsList = studentsList;
	}
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public void addStudent(Student student) {
		studentsList.add(student);
	}
	
	public void printGroupList() {
		System.out.println("Список студентов группы по дисциплине " + subject.getSubjectName() + ", " + groupName + ".");
		for (Student s : studentsList) {
			System.out.println(s.getSecondName() + " " + s.getName());
		}
		System.out.println();
	}

	public Group(String name, Subject subject) {
		groupName = name;
		this.subject = subject;
	}

	public Group() {
		
	}
	
}
