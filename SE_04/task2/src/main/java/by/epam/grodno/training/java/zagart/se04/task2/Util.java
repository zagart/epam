package by.epam.grodno.training.java.zagart.se04.task2;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Class with static methods.
 */
public class Util {

	/**
	 * Method which can find all keys iterations in source file. Keys taken from
	 * Keywords.properties file.
	 */
	public static HashMap<String, Integer> findKeywordsIterations(String source) {
		HashMap<String, Integer> keywords = new HashMap<String, Integer>();
		ResourceBundle bundle = ResourceBundle.getBundle("Keywords");
		Enumeration<?> bundleKeys = bundle.getKeys();
		while (bundleKeys.hasMoreElements()) {
			String key = (String) bundleKeys.nextElement();
			key = bundle.getString(key);
			int count = countKeywordIterations(source, key);
			keywords.put(key, count);
		}
		return keywords;
	}
	
	/**
	 * Method save HashMap content to StringBuilder object with common
	 * information to let use information more effective.
	 */
	public static StringBuilder saveKeywordsIterations(HashMap<String, Integer> keywords) {
		Iterator<Map.Entry<String, Integer>> itr = keywords.entrySet().iterator();
		StringBuilder savedResult = new StringBuilder();
		while (itr.hasNext()) {
			Map.Entry<String, Integer> pair = itr.next();
			if (pair.getValue() != 0) {
				savedResult.append(String.format("%s встречается %s раз(-a).\n", pair.getKey(), pair.getValue()));
			}
		}
		return savedResult;
	}

	/*
	 * Method which can count all keywords entries in source file. Also he save
	 * this keywords and their previous and subsequent chars in ArrayList
	 * object.
	 */
	private static int countKeywordIterations(String source, String keyword) {
		int count = 0;
		int startIndex = 1;
		ArrayList<String> list = new ArrayList<String>();
		source += " ";
		while (source.indexOf(keyword, startIndex) != -1) {
			if (startIndex > 0) {
				int substrPosition = source.indexOf(keyword, startIndex);
				String value = source.substring(substrPosition - 1, substrPosition + keyword.length() + 1);
				list.add(list.size(), value);
				count++;
			}
			startIndex = source.indexOf(keyword, startIndex) + 1;
		}

		count = editListKeywords(list, count);
		return count;
	}

	/*
	 * Method check is all iterated substrings are keywords. If not, it delete
	 * wrong substrings and decrease keywords count.
	 */
	private static int editListKeywords(ArrayList<String> list, int count) {
		for (int i = 0; i < list.size(); i++) {
			char[] arr = list.get(i).toCharArray();
			char firstChar = arr[0];
			boolean boolPrefix = (firstChar == ' ') || (firstChar == '\t') || (firstChar == '\n') || (firstChar == ';');
			char lastChar = arr[arr.length - 1];
			boolean boolPostfix = (lastChar == ' ') || (lastChar == '\t') || (lastChar == '\n');
			if (!(boolPrefix && boolPostfix)) {
				list.remove(i);
				count--;
				i--;
			}
		}
		return count;
	}

}
