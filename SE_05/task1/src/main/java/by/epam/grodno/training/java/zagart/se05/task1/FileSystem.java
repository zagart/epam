package by.epam.grodno.training.java.zagart.se05.task1;

import java.io.File;
import java.util.ArrayList;

/**
 * Utility class for resolving tasks connected with file system.
 */
public class FileSystem {

	/**
	 * Method take list of available roots on current moment and put writable
	 * ones into ArrayList.
	 */
	public static ArrayList<File> getFileRoots() {
		File[] temp = File.listRoots();
		ArrayList<File> fileRoots = new ArrayList<File>();
		for (File f : temp) {
			if (f.canWrite()) {
				fileRoots.add(f);
			}
		}
		return fileRoots;
	}

	/**
	 * Method print current folder files.
	 */
	public static void printCurrentPosition(ArrayList<File> currentPosition) {
		System.out.println("\t--Меню--");
		byte count = 0;
		for (File f : currentPosition) {
			count++;
			System.out.printf("%s) %s\n", count, f);
		}
		count++;
		String info = "Создать, удалить или дозаписать текстовый файл.";
		System.out.printf("%s) %s\n", count, info);	
		if (!isMainRoot(currentPosition)) {
			count++;
			System.out.printf("%s) %s\n", count, "Назад.\n");	
		} else {
			count++;
			System.out.printf("%s) %s\n", count, "Выход.\n");	
		}

	}
	
	/**
	 * Method check is it already main root.
	 */
	public static boolean isMainRoot(ArrayList<File> currentPosition) {
		if (currentPosition.equals(getFileRoots())) {
			return true;
		}
		return false;
	}

	/**
	 * Method which open chosen directory. In fact it rewrite files' list with
	 * next in hierarchy files' list.
	 */
	public static ArrayList<File> nextDirectory(byte selectedItem, ArrayList<File> currentPosition) {
		return makeArrayCopy(currentPosition.get(selectedItem).listFiles());
	}

	/**
	 * In fact method rewrite files' list with previous in hierarchy files'
	 * list.
	 */
	public static ArrayList<File> previousDirectory(ArrayList<File> currentPosition) {
		try {
			File parent = currentPosition.get(0).getParentFile().getParentFile();
			currentPosition = makeArrayCopy(parent.listFiles());
		} catch (NullPointerException e) {
			currentPosition = getFileRoots();
		}
		return currentPosition;
	}

	/**
	 * Method make copy of files' array and put it into ArrayList.
	 */
	public static ArrayList<File> makeArrayCopy(File[] fileArray) {
		ArrayList<File> fileList = new ArrayList<File>();
		for (File f : fileArray) {
			fileList.add(f);
		}
		return fileList;
	}

}
