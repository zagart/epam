package by.epam.grodno.training.java.zagart.se05.task1;

import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.getFileRoots;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.isMainRoot;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.nextDirectory;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.previousDirectory;
import static by.epam.grodno.training.java.zagart.se05.task1.FileSystem.printCurrentPosition;
import static by.epam.grodno.training.java.zagart.se05.task1.Util.itemMenuEnter;

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
	public static void main(String[] args) throws IOException {

		ArrayList<File> currentPosition = getFileRoots();
		rootsTree(currentPosition);

	}

	/*
	 * Method which realize file system explorer imitation.
	 */
	private static void rootsTree(ArrayList<File> currentPosition) throws IOException {
		printCurrentPosition(currentPosition);
		while (true) {
			byte selectedItem = 0;
			int itemsMaxValue = currentPosition.size() + 1;
			selectedItem = (byte) (itemMenuEnter(itemsMaxValue));
			if (selectedItem == itemsMaxValue) {
				if (isMainRoot(currentPosition)) {
					System.out.println("Работа приложения завершена.");
					System.exit(1);
				}
				currentPosition = previousDirectory(currentPosition);
				printCurrentPosition(currentPosition);
			} else if (currentPosition.get(selectedItem - 1).isDirectory()) {
				currentPosition = nextDirectory((byte) (selectedItem - 1), currentPosition);
				printCurrentPosition(currentPosition);
			} else {
				System.out.print("Запускать файлы нельзя. Попробуйте открыть другую папку ");
				System.out.println("или вернитесь назад.\n");
			}
		}
	}

}
