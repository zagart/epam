package by.epam.grodno.training.java.zagart.se05.task1;

import static by.epam.grodno.training.java.zagart.se05.task1.Common.itemMenuEnter;
import static by.epam.grodno.training.java.zagart.se05.task1.Common.reader;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.isMainRoot;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.nextDirectory;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.previousDirectory;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.printCurrentPosition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

/**
 * Utility class for work with text files.
 */
public class TextFiles {

	/**
	 * Method for creating file in chosen directory.
	 */
	public static File createTextFile(ArrayList<File> currentPosition) throws IOException {
		String path = String.valueOf(currentPosition.get(0).getParentFile());
		String name = "";
		File newFile = null;
		boolean exception = true;
		while (exception) {
			try {
				name = Common.reader.readLine();
				newFile = new File(path + name + ".txt");
				exception = false;
				if (!isMainRoot(currentPosition)) {
					if (!newFile.exists()) {
						newFile.createNewFile();
					} else {
						System.out.print("Файл не был создан. Такой файл");
						System.out.println(" уже существует.");
					}
				} else {
					System.out.println("Тут нельзя файл создать нельзя!");
				}
			} catch (IOException e) {
				exception = true;
				System.out.print("Скорее всего в имени файла запрещенный символ. ");
				System.out.println("Попробуйте снова:");
			}
		}
		return newFile;
	}

	/**
	 * Method for deleting file from chosen directory.
	 * 
	 * @throws IOException
	 */
	public static void deleteTextFile(ArrayList<File> currentPosition) throws IOException {
		ArrayList<File> textFiles = new ArrayList<File>();
		if (isTextFilesExists(currentPosition, textFiles)) {
			System.out.println("Выберите номер файла, который хотите удалить.");
			int selectedFileIndex = fileSelect(textFiles) - 1;
			textFiles.get(selectedFileIndex).delete();
		}
	}

	/**
	 * Method for writing text into file in chosen directory.
	 * 
	 * @throws IOException
	 */
	public static void writeInFile(ArrayList<File> currentPosition) throws IOException {
		ArrayList<File> textFiles = new ArrayList<File>();
		if (isTextFilesExists(currentPosition, textFiles)) {
			System.out.println("Выберите номер файла, который хотите дозаписать.");
			int selectedFileIndex = fileSelect(textFiles) - 1;
			File fileForEdit = textFiles.get(selectedFileIndex);
			System.out.println("Введите текст, который хотите добавить:");
			String text = reader.readLine();
			writeStrInFile(fileForEdit, text);
		}
	}

	/*
	 * Using Apache's library FileUtils for writing text in file.
	 */
	private static void writeStrInFile(File fileForEdit, String text) throws IOException {
		String fileContent = FileUtils.readFileToString(fileForEdit);
		FileUtils.writeStringToFile(fileForEdit, fileContent + text);
	}

	/*
	 * Methods checks is in current directory exist text files.
	 */
	private static boolean isTextFilesExists(ArrayList<File> currentPosition, ArrayList<File> textFiles) {
		for (File f : currentPosition) {
			if (f.getName().indexOf(".txt") != -1) {
				textFiles.add(f);
			}
		}
		if (textFiles.isEmpty()) {
			System.out.println("Нечего изменять!");
			return false;
		}
		return true;
	}

	/*
	 * Method allows get list of files for next actions with them.
	 */
	private static int fileSelect(ArrayList<File> textFiles) throws IOException {
		int count = 0;
		System.out.println("Файлы, доступные для изменения:");
		for (File f : textFiles) {
			count++;
			System.out.printf("%s) %s\n", count, f.getName());
		}
		return itemMenuEnter(count);
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
				createTextFile(currentPosition);
				exit = true;
				continue;
			case 2:
				deleteTextFile(currentPosition);
				exit = true;
				continue;
			case 3:
				writeInFile(currentPosition);
				exit = true;
				continue;
			case 4:
				exit = true;
			}
		}
	}

}
