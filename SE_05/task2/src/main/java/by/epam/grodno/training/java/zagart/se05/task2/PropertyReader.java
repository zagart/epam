package by.epam.grodno.training.java.zagart.se05.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.TreeSet;

/**
 * Class for work with *.properties files.
 */
public class PropertyReader {

	private static Properties propFile;

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
	 * Method gets key from pointed file, if this file exists. If not, and
	 * pointed file's name correct, then new file with such name will be
	 * created.
	 */
	public static String getValueByKey(String fileName, String key) throws IOException  {
		propFile = null;
		try {
			propFile = loadFile(fileName + ".properties");
		} catch (FileNotFoundException e) {
			try {
				new File(fileName + ".properties").createNewFile();
				propFile = loadFile(fileName + ".properties");
				return "Указанный файл не был найден, потому создан новый.";
			} catch (IOException e1) {
				return "Невозможно создать файл с таким именем.";
			}
		}

		if (propFile != null) {
			String value = propFile.getProperty(key);
			if (value != null) {
				return value;
			}
		}
		return "Ключ не найден.";
	}

}
