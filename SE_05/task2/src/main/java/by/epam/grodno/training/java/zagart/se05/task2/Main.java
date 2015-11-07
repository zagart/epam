package by.epam.grodno.training.java.zagart.se05.task2;

import static by.epam.grodno.training.java.zagart.se05.task2.PropertyReader.getValueByKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class of the application.
 */
public class Main {

	/*
	 * Reader for getting value from console.
	 */
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Entry point of the application.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) {

		String fileName = "";
		String searchKey = "";
		try {
			while (true) {
				System.out.println("\n_________________________________");
				System.out.println("Введите название properties-файла.");
				System.out.println("Если файл расположен вне корневой");
				System.out.println("директории, укажите полный путь:");
				readInput(fileName);
				System.out.println("Введите ключ:");
				readInput(searchKey);
				System.out.println("Значение ключа:\n" + getValueByKey(fileName, searchKey));
			}
		} catch (IOException e) {
			System.out.println("Ошибка потока ввода/вывода. Смотрим стэк-трэйс...");
			e.printStackTrace();
		}

	}

	/*
	 * Method which execute input value reading function.
	 */
	private static String readInput(String value) throws IOException {
		value = reader.readLine();
		if (value.isEmpty()) {
			reader.close();
			System.exit(0);
		}
		return value;
	}

}
