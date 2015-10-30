package by.epam.grodno.training.java.zagart.se04.task1;

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

	private static int countKeywordIterations(String source, String keyword) {
		int count = 0;
		int startIndex = 0;
		keyword = keyword + " ";
		while (source.indexOf(keyword, startIndex) != -1) {
			startIndex = source.indexOf(keyword, startIndex) + 1;
			count++;
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
