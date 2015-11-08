package by.epam.grodno.training.java.zagart.se05.newtask1;

import static by.epam.grodno.training.java.zagart.se05.newtask1.Common.itemMenuEnter;
import static by.epam.grodno.training.java.zagart.se05.newtask1.Common.reader;
import static by.epam.grodno.training.java.zagart.se05.newtask1.FileExplorer.getPath;
import static by.epam.grodno.training.java.zagart.se05.newtask1.FileExplorer.isMainRoot;
import static by.epam.grodno.training.java.zagart.se05.newtask1.FileExplorer.makeList;
import static by.epam.grodno.training.java.zagart.se05.newtask1.FileExplorer.nextDirectory;
import static by.epam.grodno.training.java.zagart.se05.newtask1.FileExplorer.previousDirectory;
import static by.epam.grodno.training.java.zagart.se05.newtask1.FileExplorer.printCurrentPosition;
import static by.epam.grodno.training.java.zagart.se05.newtask1.TextFiles.reloadMenu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

/**
 * Class with static methods for work with text files.
 */
public class TextFiles {

	/**
	 * Method creates menu for actions with text files.
	 */
	public static void fileEditMenu(int selectedItem, ArrayList<File> currentPosition) throws IOException {
		boolean exit = false;
		while (!exit) {
			System.out.println("\t--Работа с текстовыми файлами.--");
			System.out.println("1) <==");
			System.out.println("2) Создать новый файл.");
			System.out.println("3) Удалить файл.");
			System.out.println("4) Дозаписать файл.");
			int itemsMaxValue = 4;
			int menuItem = itemMenuEnter(itemsMaxValue);
			switch (menuItem) {
			case 1:
				currentPosition = previousDirectory(currentPosition);
				currentPosition = nextDirectory(currentPosition, selectedItem);
				System.out.println("\nМеню обновлено...");
				printCurrentPosition(currentPosition);
				exit = true;
				continue;
			case 2:
				createFile(getPath(currentPosition.get(selectedItem)));
				currentPosition = reloadMenu(selectedItem, currentPosition);
				exit = true;
				continue;
			case 3:
				deleteTextFile(currentPosition);
				currentPosition = reloadMenu(selectedItem, currentPosition);
				exit = true;
				continue;
			case 4:
				writeInFile(currentPosition);
				exit = true;
				continue;
			}
		}
	}

	/*
	 * Method for creating new text file.
	 */
	private static void createFile(String directory) {
		File file;
		System.out.println("Введите название файла:");
		boolean exception = true;
		while (exception) {
			try {
				String name = reader.readLine();
				file = new File(directory + File.separator + name + ".txt");
				System.out.println(file);
				file.createNewFile();
				exception = false;
			} catch (IOException e) {
				System.out.print("Убедитесь, что имя файла не содержит ");
				System.out.println("запрещенных символов и попробуйте снова:");
			}
		}

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
			System.out.println("В каталоге нет текстовых файлов!\n");
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

	/**
	 * Method for reloading currently opened directory after it's changing.
	 * 
	 * @throws IOException
	 */
	public static ArrayList<File> reloadMenu(int selectedItem, ArrayList<File> currentPosition) throws IOException {
		if (!isMainRoot(currentPosition)) {
			currentPosition = previousDirectory(currentPosition);
			currentPosition = nextDirectory(currentPosition, selectedItem);
			printCurrentPosition(currentPosition);
		}
		return currentPosition;
	}

}
