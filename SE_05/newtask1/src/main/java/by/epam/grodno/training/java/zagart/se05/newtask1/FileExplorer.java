package by.epam.grodno.training.java.zagart.se05.newtask1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class with methods for browsing file system.
 */
public class FileExplorer {

	/**
	 * Method returns current file path without it's filename.
	 * 
	 * @param file
	 * @return
	 */
	public static String getPath(File file) {
		String path = file.getAbsolutePath();
		int cutter = path.lastIndexOf(File.separator.toString());
		path = path.substring(0, cutter);
		return path;
	}

	/**
	 * Method returns ArrayList with file system roots.
	 * 
	 * @return
	 */
	public static ArrayList<File> getRoots() {
		File[] roots = File.listRoots();
		ArrayList<File> rootsInArray = new ArrayList<File>();
		for (File f : roots) {
			if (f.canRead()) {
				rootsInArray.add(f);
			}
		}
		return rootsInArray;
	}

	/**
	 * Method print in console current position relatively ArrayList's content.
	 * 
	 * @param currentPosition
	 */
	public static void printCurrentPosition(ArrayList<File> currentPosition) {
		System.out.println("\n\t----Меню----");
		int count = 0;
		if (isMainRoot(currentPosition)) {
			while (count < currentPosition.size()) {
				printString(currentPosition.get(count).toString(), count + 1);
				count++;
			}
		} else {
			count = 1;
			printString("<==", count);
			count++;
			printString("Файлы", count);
			while (count < currentPosition.size() + 2) {
				printString(currentPosition.get(count - 2).toString(), count + 1);
				count++;
			}
		}
	}

	/*
	 * Formatted print by value and count.
	 */
	private static void printString(String value, int count) {
		System.out.printf("%s) %s\n", count, value);
	}

	/**
	 * Method execute moving to next directory.
	 * 
	 * @param currentPosition
	 * @param selectedItem
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<File> nextDirectory(ArrayList<File> currentPosition, int selectedItem) throws IOException {
		ArrayList<File> filesList;
		if (!isMainRoot(currentPosition)) {
			selectedItem -= 3;
		} else {
			selectedItem -= 1;
		}
		File directory = currentPosition.get(selectedItem);
		try {
			if (directory.isDirectory()) {
				filesList = makeList(directory.listFiles());
				return filesList;
			} else {
				System.out.printf("Нельзя открывать файлы!(%s)\n", directory);
			}
		} catch (NullPointerException e) {
			System.out.printf("Нельзя открывать файлы!(%s)\n", directory);
		}
		return currentPosition;
	}

	/**
	 * Method which execute moving to previous directory.
	 * 
	 * @param currentPosition
	 * @return
	 * @throws IOException 
	 */
	public static ArrayList<File> previousDirectory(ArrayList<File> currentPosition) throws IOException {
		try {
			String path = getPath(currentPosition.get(0));
			try {
				File[] filesArray = new File(path).getParentFile().listFiles();
				currentPosition = makeList(filesArray);
			} catch (NullPointerException e) {
				return getRoots();
			}
		} catch (IndexOutOfBoundsException e) {
			return getRoots();
		}
		return currentPosition;
	}

	/**
	 * Method create ArrayList of files using array of files.
	 * 
	 * @param filesArray
	 * @return
	 */
	public static ArrayList<File> makeList(File[] filesArray) {
		ArrayList<File> list = new ArrayList<File>(10);
		for (File f : filesArray) {
			if (f.canWrite()) {
				list.add(f);
			}
		}
		return list;
	}

	/**
	 * Method check is currently opened files directory system roots.
	 * 
	 * @param currentPosition
	 * @return
	 */
	public static boolean isMainRoot(ArrayList<File> currentPosition) {
		if (currentPosition.equals(getRoots())) {
			return true;
		}
		return false;
	}

}
