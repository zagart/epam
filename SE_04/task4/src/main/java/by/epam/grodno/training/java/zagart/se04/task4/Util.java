package by.epam.grodno.training.java.zagart.se04.task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

/**
 * Class with static methods.
 */
public class Util {

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	final public static int lowerBound = 1;
	final public static int upperBound = 2;

	/**
	 * Method for creating new output stream and writing films collection in
	 * file data.dat
	 */
	public static void saveCollectionInDataFile(Collection<Film> films) {
		File data = new File("data.dat");
		try {
			ObjectOutputStream dataFile = new ObjectOutputStream(new FileOutputStream(data));
			dataFile.writeObject(films);
			dataFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Неизвестная ошибка.");
			System.exit(1);
		}
	}

	/**
	 * Method for creating new collection from reading file data.dat
	 */
	public static Collection getDataFileCollection() {
		File data = new File("data.dat");
		try {
			ObjectInputStream dataFile = new ObjectInputStream(new FileInputStream(data));
			@SuppressWarnings("unchecked")
			Collection<Film> films = (Collection<Film>) dataFile.readObject();
			dataFile.close();
			return films;
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Неизвестная ошибка.");
			System.exit(1);
		} catch (ClassNotFoundException e) {
			System.out.println("Класс не найден.");
			System.exit(1);
		}
		return null;
	}

	/**
	 * Method for entering value from console which will cause action according
	 * to item of menu. Also take under control possible exceptional situations.
	 */
	public static int itemMenuEnter(int selectedItem) {
		boolean exception = true;
		while (exception) {
			try {
				selectedItem = Integer.parseInt(reader.readLine());
				selectedItem = itemBoundCheck(selectedItem);
				exception = false;
			} catch (IOException e) {
				exception = true;
				System.out.println("Неизвестная ошибка. Попробуйте снова: ");
				System.exit(1);
			} catch (NumberFormatException e) {
				exception = true;
				System.out.println("Ошибка ввода. Попробуйте снова: ");
			}
		}
		return selectedItem;
	}

	/*
	 * Method responsible directly for checking entered item bounds.
	 */
	private static int itemBoundCheck(int selectedItem) throws NumberFormatException, IOException {
		while ((selectedItem < lowerBound) || (selectedItem > upperBound)) {
			System.out.print("Неверный номер пункта меню. ");
			System.out.println("Попробуйте снова: ");
			selectedItem = Integer.parseInt(reader.readLine());
		}
		return selectedItem;
	}

}
