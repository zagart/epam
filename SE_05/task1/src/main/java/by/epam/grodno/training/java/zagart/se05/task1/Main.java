package by.epam.grodno.training.java.zagart.se05.task1;

import static by.epam.grodno.training.java.zagart.se05.task1.Common.itemMenuEnter;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.getFileRoots;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.isMainRoot;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.makeArrayCopy;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.nextDirectory;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.previousDirectory;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.printCurrentPosition;
import static by.epam.grodno.training.java.zagart.se05.task1.TextFiles.fileEditMenu;
import static by.epam.grodno.training.java.zagart.se05.task1.TextFiles.reloadMenu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class of the application.
 */
public class Main {

	/**
	 * Entry point of the application.
	 */
	public static void main(String[] args) {

		ArrayList<File> currentPosition = getFileRoots();
		try {
			rootsTree(currentPosition);
		} catch (IOException e) {
			System.out.println("Ошибка потока ввода-вывода...Смотрим стэйк-трейс.");
			e.printStackTrace();
		}

	}

	/*
	 * Method which realize file system explorer imitation.
	 */
	private static void rootsTree(ArrayList<File> currentPosition) throws IOException {
		printCurrentPosition(currentPosition);
		while (true) {

			byte selectedItem = 0;
			int itemsMaxValue = currentPosition.size() + 2;
			selectedItem = (byte) (itemMenuEnter(itemsMaxValue));
			if (selectedItem == itemsMaxValue) {

				if (isMainRoot(currentPosition)) {
					System.out.println("Работа приложения завершена.");
					Common.reader.close();
					System.exit(1);
				}

				currentPosition = previousDirectory(currentPosition);
				printCurrentPosition(currentPosition);

			} else if ((selectedItem < itemsMaxValue - 1)) {
				if (currentPosition.get(selectedItem - 1).isDirectory()) {

					currentPosition = nextDirectory((byte) (selectedItem - 1), currentPosition);
					printCurrentPosition(currentPosition);

				} else {

					System.out.print("Запускать файлы нельзя. Попробуйте открыть папку ");
					System.out.println("или вернитесь назад.\n");

				}
			} else {
				if (!isMainRoot(currentPosition)) {
					int previousItem =  previousDirectory(currentPosition).indexOf(currentPosition.get(0).getParentFile());
					fileEditMenu(currentPosition, selectedItem);
					currentPosition = reloadMenu(previousItem, currentPosition);
				} else {
					System.out.println("Тут нельзя работать с файлами...");
					System.out.println("Выберите другой пункт меню.");
				}
				
			}

		}
	}

}
