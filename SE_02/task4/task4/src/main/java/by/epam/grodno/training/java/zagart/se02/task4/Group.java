package by.epam.grodno.training.java.zagart.se02.task4;

import java.util.ArrayList;
import java.util.Random;

public class Group<T extends Number> {

	private T mark;
	private int dim = 5;
	private String groupName;
	private Subject groupSubject;
	private ArrayList<Student> studentsList = new ArrayList<Student>();
	private ArrayList<ArrayList<T>> studentsMarksList = new ArrayList<ArrayList<T>>();

	public Group(String groupName, Subject groupSubject, T mark) {
		this.groupName = groupName;
		this.groupSubject = groupSubject;
		this.mark = mark;
	}
	
	public ArrayList<Student> getStudentsList() {
		return studentsList;
	}

	public ArrayList<Student> createRandomStudent() {
		Student student;
		if (!studentsList.isEmpty()) {
			Random n = new Random();
			Random sn = new Random();
			student = new Student(Util.names[n.nextInt(dim)], Util.secondNames[sn.nextInt(dim)]);
			for (Student s : studentsList) {
				if (s.equals(student)) {
					return studentsList;
				} 
			}
			studentsList.add(student);
			studentsMarksList.add((ArrayList<T>) randomMarks());
		} else {
			Random n = new Random();
			Random sn = new Random();
			student = new Student(Util.names[n.nextInt(dim)], Util.secondNames[sn.nextInt(dim)]);
			studentsList.add(student);
			studentsMarksList.add((ArrayList<T>) randomMarks());
		}
		return studentsList;
	}
	
	public void addRandomStudents(Integer n) {
		for (int i = 0; i < n; i++) {
			createRandomStudent();
		}
	}
	
	public void addStudent(Student student) {
		this.studentsList.add(student);
		this.studentsMarksList.add(new ArrayList<T>());
	}

	public void addStudentMark(Student student, T mark) {
		for (int i = 0; i < studentsList.size(); i++) {
			if (studentsList.get(i).equals(student)) {
				studentsMarksList.get(i).add(mark);
			}
		}
	}

	public void setStudentMarks(Student student, ArrayList<T> marks) {
		for (int i = 0; i < studentsList.size(); i++) {
			if (studentsList.get(i).equals(student)) {
				studentsMarksList.remove(i);
				studentsMarksList.add(i, marks);
			}
		}
	}
	
	public void printStudentMarks(Student student) {
		for (int i = 0; i < studentsList.size(); i++) {
			if (studentsList.get(i).equals(student)) {
				if (studentsMarksList.get(i).isEmpty()) System.out.println("Оценок нет.");
				else {
					for (T m : studentsMarksList.get(i)) {
						System.out.print(m + " ");
					}
					System.out.println();
				}
			}
		}
	}
	
	public ArrayList<?> randomMarks() {
		if (mark instanceof Double) {
			ArrayList<Double> marks = new ArrayList<Double>();
			Random r = new Random();
			for (int i = 0; i < 5; i++) {
				Double n = (int) r.nextInt(9) + ((double)(((int)(r.nextDouble()*100))))/100;
				marks.add(n);
				return marks;
			}	
		} else {
			ArrayList<Integer> marks = new ArrayList<Integer>();
			Random r = new Random();
			for (int i = 0; i < 5; i++) {
				Integer n = r.nextInt(10);
				marks.add(n);
				return marks;
			}	
		}
		System.out.println("Рандом не отработал.");
		return null;
	}
	
	public void printStudents() {
		for (Student s : studentsList) {
			System.out.print(s);
			printStudentMarks(s);
		}
	}
	
}
