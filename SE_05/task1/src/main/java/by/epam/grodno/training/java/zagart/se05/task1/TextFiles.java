package by.epam.grodno.training.java.zagart.se05.task1;

import static by.epam.grodno.training.java.zagart.se05.task1.Common.itemMenuEnter;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.isMainRoot;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.nextDirectory;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.previousDirectory;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.printCurrentPosition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Utility class for work with text files.
 */
public class TextFiles {

	/**
	 * Method for creating file in chosen directory.
	 */
	public static File createTextFile(ArrayList<File> currentPosition, String name) throws IOException {
		String path = String.valueOf(currentPosition.get(0).getParentFile());
		File newFile = new File(path + name + ".txt");
		if (!isMainRoot(currentPosition)) {
			newFile.createNewFile();
			printCurrentPosition(currentPosition);
		} else {
			System.out.println("Тут нельзя файл создать нельзя!");
		}

		return newFile;
	}

	/**
	 * Method for deleting file from chosen directory.
	 * @throws IOException 
	 */
	public static void deleteTextFile(ArrayList<File> currentPosition) throws IOException {
		ArrayList<File> textFiles = new ArrayList<File>();
		for (File f : currentPosition) {
			if (f.getName().indexOf(".txt") != -1) {
				textFiles.add(f);
			}
		}
		if (textFiles.isEmpty()) {
			System.out.println("Нечего удалять!");
		} else {
			int count = 0;
			System.out.println("Файлы, доступные для удаления.");
			for (File f : textFiles) {
				count++;
				System.out.printf("%s) %s\n", count, f.getName());
			}
			System.out.println("Выберите номер файла, который хотите удалить:");
			int menuItem = itemMenuEnter(count);
			textFiles.get(menuItem - 1).delete();
		}
	}

	/**
	 * Method for writing text into file in chosen directory.
	 */
	public static void writeInFile(File textFile) {

	}

	/**
	 * Method for reloading currently opened directory after it's changing.
	 */
	public static ArrayList<File> reloadMenu(int selectedItem, ArrayList<File> currentPosition) {
		if (!isMainRoot(currentPosition)) {
			currentPosition = previousDirectory(currentPosition);
			currentPosition = nextDirectory((byte) selectedItem, currentPosition);
			System.out.println("\nМеню обновлено...");
			printCurrentPosition(currentPosition);
		}
		return currentPosition;
	}

	/**
	 * Method creates menu for actions with text files.
	 */
	public static void fileEditMenu(ArrayList<File> currentPosition, byte selectedItem) throws IOException {
		boolean exit = false;
		while (!exit) {
			System.out.println("\t--Работа с текстовыми файлами.--");
			System.out.println("1) Создать новый файл.");
			System.out.println("2) Удалить файл.");
			System.out.println("3) Дозаписать файл.");
			System.out.println("4) Назад.");
			int itemsMaxValue = 4;
			int menuItem = (byte) (itemMenuEnter(itemsMaxValue));
			switch (menuItem) {
			case 1:
				System.out.println("Введите название файла:");
				String name = Common.reader.readLine();
				createTextFile(currentPosition, name);
				exit = true;
				continue;
			case 2:
				deleteTextFile(currentPosition);
				exit = true;
				continue;
			case 3:
//				writeInFile();
				exit = true;
				continue;
			case 4:
				exit = true;
			}
		}
	}

}
