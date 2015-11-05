package by.epam.grodno.training.java.zagart.se05.task2;

import static by.epam.grodno.training.java.zagart.se05.task2.PropertyReader.getKeyFromFileName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class of the application.
 */
public class Main {

	/**
	 * Entry point of the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) {
	
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = "";
		try {
			while (true) {
				System.out.println("\n_______________________");
				System.out.println("Введите название файла:");
				fileName = reader.readLine();
				if (fileName.equals("")) {
					System.exit(0);
				}
				getKeyFromFileName(fileName);
			}
		} catch (IOException e) {
			System.out.println("Ошибка потока ввода/вывода. Смотрим стэк-трэйс...");
			e.printStackTrace();
		}
			
	}

	

	

}
