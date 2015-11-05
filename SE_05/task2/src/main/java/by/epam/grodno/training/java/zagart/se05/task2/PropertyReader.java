package by.epam.grodno.training.java.zagart.se05.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.TreeSet;

/**
 * Class for work with *.properties files.
 */
public class PropertyReader {

	private static Properties propFile;

	/*
	 * Method gets keys from file and put them into TreeSet object.
	 */
	private static TreeSet<String> getKeys() {
		TreeSet<String> sortedPairs = new TreeSet<String>(propFile.stringPropertyNames());
		return sortedPairs;
	}

	/*
	 * Method loads file with pointed name and properties type.
	 */
	private static Properties loadFile(String fileName) throws IOException {
		Properties file = new Properties();
		File propFile = new File(fileName);
		FileInputStream propFileIStream = new FileInputStream(propFile);
		file.load(propFileIStream);
		propFileIStream.close();
		return file;
	}

	/*
	 * Method gets first (for now just first) value of the first key from
	 * pointed file, if this file exists. If not and pointed file's name
	 * correct, then new file with such name will be created.
	 */
	public static void getKeyFromFileName(String fileName) throws IOException {
		propFile = null;
		try {
			propFile = loadFile(fileName + ".properties");
		} catch (FileNotFoundException e) {
			boolean skip = false;
			try {
				new File(fileName + ".properties").createNewFile();
			} catch (IOException e1) {
				System.out.println("Невозможно создать файл с данным именем.");
				skip = true;
			}
			if (!skip) {
				propFile = loadFile(fileName + ".properties");
				System.out.println("Указанный файл не был найден, потому создан новый.");
			}
		}

		if (propFile != null) {
			try {
				String firstElem = propFile.getProperty(getKeys().first());
				if (firstElem.isEmpty()) {
					System.out.println("Ключ не содержит значения!");
				} else {
					System.out.println("Значение первого ключа: " + firstElem);
				}

			} catch (NoSuchElementException e) {
				System.out.println("Файл не содержит ключей!");
			}
		}

	}
	
}
