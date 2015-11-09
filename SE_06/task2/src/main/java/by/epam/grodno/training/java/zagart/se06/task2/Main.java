package by.epam.grodno.training.java.zagart.se06.task2;

import static by.epam.grodno.training.java.zagart.se06.task2.PropertiesReader.getPropertiesMap;
import static by.epam.grodno.training.java.zagart.se06.task2.PropertiesReader.getValueOfKey;

import java.io.IOException;
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

		Map<String, String> map = getPropertiesMap("newFile");
		printMap(map);
		System.out.println(getValueOfKey("key2"));

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
