package by.epam.grodno.training.java.zagart.se05.newtask1;

import static by.epam.grodno.training.java.zagart.se05.newtask1.Common.itemMenuEnter;
import static by.epam.grodno.training.java.zagart.se05.newtask1.FileExplorer.getRoots;
import static by.epam.grodno.training.java.zagart.se05.newtask1.FileExplorer.isMainRoot;
import static by.epam.grodno.training.java.zagart.se05.newtask1.FileExplorer.nextDirectory;
import static by.epam.grodno.training.java.zagart.se05.newtask1.FileExplorer.previousDirectory;
import static by.epam.grodno.training.java.zagart.se05.newtask1.FileExplorer.printCurrentPosition;
import static by.epam.grodno.training.java.zagart.se05.newtask1.TextFiles.fileEditMenu;
import static by.epam.grodno.training.java.zagart.se05.newtask1.TextFiles.reloadMenu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {

		try {
			ArrayList<File> currentPosition = getRoots();
			fileExplorer(currentPosition);
		} catch (Exception e) {
			System.out.println("Оп-па... Смотрим стэк-трейс.");
			e.printStackTrace();
		}

	}

	private static void fileExplorer(ArrayList<File> currentPosition) throws IOException {
		int selectedItem = 0;
		printCurrentPosition(currentPosition);
		while (true) {
			if (isMainRoot(currentPosition)) {
				selectedItem = itemMenuEnter(currentPosition.size());
				currentPosition = nextDirectory(currentPosition, selectedItem);
				printCurrentPosition(currentPosition);

			} else {
				selectedItem = itemMenuEnter(currentPosition.size() + 2);
				if (selectedItem == 1) {
					currentPosition = previousDirectory(currentPosition);
					printCurrentPosition(currentPosition);
				}
				if (selectedItem == 2) {
					fileEditMenu(selectedItem, currentPosition);
					currentPosition = reloadMenu(selectedItem, currentPosition);
				}
				if (selectedItem > 2) {
					currentPosition = nextDirectory(currentPosition, selectedItem);
					printCurrentPosition(currentPosition);
				}
			}

		}
	}

}
