package by.epam.grodno.training.java.zagart.se06.task2;

import static by.epam.grodno.training.java.zagart.se06.task2.PropertiesReader.getMapFromFile;
import static by.epam.grodno.training.java.zagart.se06.task2.PropertiesReader.getValueByKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> map = getMapFromFile("newFile", "UTF-8");
		printMap(map);
		
		while (true) {
			String console = reader.readLine();
			if (console.isEmpty()) {
				System.out.println("Работа приложения завершена.");
				System.exit(0);
			} else {
				String value = getValueByKey("newFile", "UTF-8", console);
				System.out.println("\nРезультат поиска по ключу:");
				if (value != null) {
					System.out.println(value + "\n");
				} else {
					System.out.println("Ключ не найден.\n");
				}
			}
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
