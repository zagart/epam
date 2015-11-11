package by.epam.grodno.training.java.zagart.se06.task2;

import static by.epam.grodno.training.java.zagart.se06.task2.PropertiesReader.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Main class.
 * 
 * @author zagart
 *
 */
public class Main {

	/**
	 * Entry point of the application.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Map<String, String> map = getMapFromFile("newFile", "UTF-8");
		printMap(map);
		
		String value = getValueByKey("newFile", "UTF-8","1");
		System.out.println("\nРезультат поиска по ключу:");
		if (value != null) {
			System.out.println(value);
		} else {
			System.out.println("Ключ не найден.");
		}
		
	}

	/*
	 * Method for printing Map object.
	 */
	private static void printMap(Map<String, String> map) {
		Iterator<Entry<String, String>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> pair = itr.next();
			System.out.printf("Ключ: %s, значение: %s.\n", pair.getKey(), pair.getValue());
		}
	}

}
