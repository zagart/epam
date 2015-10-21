package by.epam.grodno.training.java.zagart.se02.task4;

import java.util.ArrayList;
import static by.epam.grodno.training.java.zagart.se02.task4.UtilClass.*;

public class Main {

	public static void main(String[] args) {

		ArrayList<Group> groupsList = new ArrayList<Group>();
		createGroups(groupsList);
		
		try { 
			searchGroupByName(groupsList, "Группа №2").printGroupList();
		} catch (NullPointerException e) { 
			System.out.println("Группа не найдена."); 
		}
		
			ArrayList<Group> foundedGroups = searchGroupsByStudent(groupsList, new Student("Владислав", "Званкович"));
			if (foundedGroups.isEmpty() == true) {
				System.out.println("Совпадений не найдено."); 	
			} else {
				System.out.println("Студент числится в следующих групах:");
				for (Group g : foundedGroups) {
					System.out.println(g.getGroupName());
				}
			}
		
	}

}
