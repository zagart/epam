package by.epam.grodno.training.java.zagart.se04.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Class with static methods.
 *
 */
public class Util {

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

	public static int countKeywordIterations(String source, String keyword) {
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

	public static int editListKeywords(ArrayList<String> list, int count) {
		for (int i = 0; i < list.size(); i++) {
			char[] arr = list.get(i).toCharArray();
			char firstChar = arr[0];
			boolean boolPrefix = (firstChar == ' ') || (firstChar == '\t') || (firstChar == '\n') || (firstChar == ';') ;
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

	public static void printKeywordsIterations(HashMap<String, Integer> keywords) {
		Iterator<Map.Entry<String, Integer>> itr = keywords.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, Integer> pair = itr.next();
			if (pair.getValue() != 0) {
				System.out.println(String.format("%s встречается %s раз(-a).", pair.getKey(), pair.getValue()));
			}
		}
	}

}
