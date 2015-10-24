package by.epam.grodno.training.java.zagart.se02.task4;

import java.util.ArrayList;

public class Util {

	public static String[] names = { "Иван", "Петр", "Николай", "Саша", "Миша" };
	public static String[] secondNames = { "Иванов", "Петров", "Соколов", "Рамазанов", "Бейтюк" };

	public static Group<?> createGroupIntegerMarks(String name, Subject subject) {
		Group<Integer> group = new Group<Integer>(name, subject, new Integer(0));
		Group.groupsList.add(group);
		return group;
	}

	public static Group<?> createGroupFloatMarks(String name, Subject subject) {
		Group<Float> group = new Group<Float>(name, subject, new Float(0));
		Group.groupsList.add(group);
		return group;
	}

	@SuppressWarnings("rawtypes")
	public static void getGroupsByStudent(Student student) {
		ArrayList<Group> list = Group.findGroupsByStudent(student);
		System.out
				.println(String.format("Студент %s %s учится в группах: ", student.getName(), student.getSecondName()));
		if (!list.isEmpty()) {
			for (Group g : list) {
				System.out.println(g.getGroupName());
			}
		} else
			System.out.println("Не учится ни в одной из групп.");
	}

	@SuppressWarnings("rawtypes")
	public static void getGroupsByStudent(String name, String secondName) {
		ArrayList<Group> list = Group.findGroupsByStudent(new Student(name, secondName));
		System.out.println(String.format("Студент %s %s учится в группах: ", name, secondName));
		if (!list.isEmpty()) {
			for (Group g : list) {
				System.out.println(g.getGroupName());
			}
		} else
			System.out.println("Не учится ни в одной из групп.");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void countAverageMarks(Group group) {
		ArrayList<Float> list = new ArrayList<Float>();
		if (group.getMark() instanceof Float) {
			for (ArrayList<Float> marks : (ArrayList<ArrayList<Float>>) group.getStudentsMarksList()) {
				float average = (float) 0;
				for (float mark : marks) {
					average += mark;
				}
				average /= marks.size();
				list.add(average);
			}
			group.setCountAverageMark(list);
		} else {
			ArrayList<Integer> intList = new ArrayList<Integer>();
			for (ArrayList<Integer> marks : (ArrayList<ArrayList<Integer>>) group.getStudentsMarksList()) {
				int average = 0;
				for (int mark : marks) {
					average += mark;
				}
				average /= marks.size();
				intList.add(average);
			}
			group.setCountAverageMark(intList);
		}
	}
	

}
