package by.epam.grodno.training.java.zagart.se02.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

public class Group<T extends Number> {

	private T mark;
	private int dim = 5;
	private String groupName;
	private Subject groupSubject;
	public static ArrayList<Group<?>> groupsList = new ArrayList<Group<?>>();
	private ArrayList<Student> studentsList = new ArrayList<Student>();
	private ArrayList<ArrayList<T>> studentsMarksList = new ArrayList<ArrayList<T>>();
	private ArrayList<T> countAverageMark = new ArrayList<T>();

	Comparator<T> comparator = new Comparator<T>() {

		public int compare(T o1, T o2) {
			if (o1 instanceof Number) {
				if (o1.floatValue() > o2.floatValue())
					return -1;
				if (o1.floatValue() < o2.floatValue())
					return 1;
			}
			return 0;
		}

	};

	public ArrayList<ArrayList<T>> getStudentsMarksList() {
		return studentsMarksList;
	}

	public void setStudentsMarksList(ArrayList<ArrayList<T>> studentsMarksList) {
		this.studentsMarksList = studentsMarksList;
	}

	public Group(String groupName, Subject groupSubject, T mark) {
		this.groupName = groupName;
		this.groupSubject = groupSubject;
		this.mark = mark;
	}

	public ArrayList<T> getCountAverageMark() {
		return countAverageMark;
	}

	public void setCountAverageMark(ArrayList<T> countAverageMark) {
		this.countAverageMark = countAverageMark;
	}

	public String getGroupName() {
		return groupName;
	}

	public static ArrayList<Group> findGroupsByStudent(Student student) {
		ArrayList<Group> list = new ArrayList<Group>();
		for (Group g : groupsList) {
			for (int i = 0; i < g.studentsList.size(); i++) {
				if (g.studentsList.get(i).equals(student)) {
					list.add(g);
					break;
				}
			}
		}
		return list;
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

	private void printStudentMarks(Student student) {
		for (int i = 0; i < studentsList.size(); i++) {
			if (studentsList.get(i).equals(student)) {
				if (studentsMarksList.get(i).isEmpty())
					System.out.println("Оценок нет.");
				else {
					for (T m : studentsMarksList.get(i)) {
						if (mark instanceof Integer)
							System.out.printf("%4d ", m);
						if (mark instanceof Float)
							System.out.printf(" %.2f  ", m);
					}
					if (!countAverageMark.isEmpty()) {
						if (mark instanceof Integer) {
							System.out.printf("| %4d", countAverageMark.get(i));
							System.out.println();
						}
						if (mark instanceof Float) {
							System.out.printf("| %.2f", countAverageMark.get(i));
							System.out.println();
						}
					} else
						System.out.println();
				}
			}
		}
	}

	private ArrayList<?> randomMarks() {
		if (mark instanceof Float) {
			ArrayList<Float> marks = new ArrayList<Float>();
			Random r = new Random();
			for (int i = 0; i < 5; i++) {
				Float n = r.nextInt(9) + r.nextFloat();
				marks.add(n);
			}
			return marks;
		} else {
			ArrayList<Integer> marks = new ArrayList<Integer>();
			Random r = new Random();
			for (int i = 0; i < 5; i++) {
				Integer n = r.nextInt(10);
				marks.add(n);
			}
			return marks;
		}
	}

	public void printStudents() {
		System.out.println(
				String.format("                %s (дисциплина \"%s\"):", groupName, groupSubject.getSubjectName()));
		for (Student s : studentsList) {
			System.out.print(String.format("%12s %12s :", s.getName(), s.getSecondName()));
			printStudentMarks(s);
		}
		System.out.println();
	}

	public T getMark() {
		return mark;
	}


	public void findStudentResult(String name, String secondName) {
		Student student = new Student(name, secondName);
		float temp = (float) 0;
		
		for (int i = 0; i < countAverageMark.size(); i++) {
			if (studentsList.get(i).equals(student)) {
				temp = countAverageMark.get(i).floatValue();
			}
		}
		
		HashSet<T> list = new HashSet<T>(countAverageMark);
		ArrayList<T> newList = new ArrayList(list);
		Collections.sort(newList, comparator);
		
		for (int i = 0; i < newList.size(); i++) {
			if ((newList.get(i).floatValue() <= temp + 0.001) && ((newList.get(i).floatValue() >= temp - 0.001))) {
				System.out.println("Студент на " + (i + 1) + " месте по среднему баллу в своей группе.");
			}
		}
	}
	
	public void findStudentResult(Student student) {
		float temp = (float) 0;
		
		for (int i = 0; i < countAverageMark.size(); i++) {
			if (studentsList.get(i).equals(student)) {
				temp = countAverageMark.get(i).floatValue();
			}
		}
		
		HashSet<T> list = new HashSet<T>(countAverageMark);
		ArrayList<T> newList = new ArrayList(list);
		Collections.sort(newList, comparator);
		
		for (int i = 0; i < newList.size(); i++) {
			if ((newList.get(i).floatValue() <= temp + 0.001) && ((newList.get(i).floatValue() >= temp - 0.001))) {
				System.out.println("Студент на " + (i + 1) + " месте по среднему баллу в своей группе.");
			}
		}
	}


}
