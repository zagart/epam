package by.epam.grodno.training.java.zagart.se06.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;

public class PropertiesReader {

	/**
	 * Method view properties-file content in Map object. Firstly it loads
	 * properties-file strings into List object using Apache's library's method.
	 * After it happens separating strings on keys and values and putting them
	 * into map object.
	 * 
	 * @param path
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static Map<String, String> getMapFromFile(String path, String encoding) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		try {
			File file = new File(path + ".properties");
			@SuppressWarnings("unchecked")
			List<String> list = FileUtils.readLines(file, encoding);
			if (list.get(0).length() != 1) {
				for (String s : list) {
					int equalSignIndex = s.indexOf("=");
					if (equalSignIndex != -1) {
						String temp = s.substring(equalSignIndex - 1, equalSignIndex + 2);
						s = s.replaceFirst(temp, temp.trim());
						equalSignIndex = s.indexOf("=");
						String key = s.substring(0, equalSignIndex);
						String value = s.substring(equalSignIndex + 1, s.length());
						map.put(key, value);
					} else {
						map.put(s, "");
					}
				}
			} else {
				System.out.println("Файл пуст.");
			}
		} catch (FileNotFoundException e) {
			System.out.print("Указанный файл с расширением");
			System.out.println(" *.properties не найден!");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Неизвестная кодировка!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * Method returns value by key from read properties-file.
	 * 
	 * @param path
	 * @param key
	 * @return
	 */
	public static String getValueByKey(String path, String encoding, String key) {
		Map<String, String> map = new LinkedHashMap<String, String>(getMapFromFile(path, encoding));
		return map.get(key);
	}

}
