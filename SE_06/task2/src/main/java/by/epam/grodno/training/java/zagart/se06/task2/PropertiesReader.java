package by.epam.grodno.training.java.zagart.se06.task2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {

	private static Map<String, String> map = new HashMap<String, String>();

	/**
	 * Method loads properties-file using path from input parameter. If only
	 * name in parameter, then opens file from directory with project.
	 * 
	 * @param path
	 */
	private static Properties loadPropertiesFile(String path) {
		Properties pFile = new Properties();
		try {
			File file = new File(path + ".properties");
			InputStream inStream = new BufferedInputStream(new FileInputStream(file));
			pFile.load(inStream);
			inStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден!");
		} catch (IOException e) {
			System.out.println("Ошибка при работе с файлом.");
		}
		return pFile;
	}

	/**
	 * Method view properties-file content in Map object.
	 * 
	 * @param path
	 * @return
	 */
	public static Map<String, String> getPropertiesMap(String path) {
		Properties pFile = loadPropertiesFile(path);
		Enumeration<?> keys = pFile.keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement().toString();
			String value = pFile.getProperty(key);
			map.put(key, value);
		}
		return map;
	}

	/**
	 * Method return
	 * 
	 * @param path
	 * @param key
	 * @return
	 */
	public static String getValueOfKey(String key) {
		if (!map.isEmpty()) {
			return map.get(key);
		} else {
			System.out.println("Сначала нужно прочитать файл!");
			return "";
		}
	}

}
