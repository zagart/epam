package by.epam.grodno.training.java.zagart.se04.task1;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class Util {
	
	public static void iterateKeywords(String source) {
		ResourceBundle bundle = ResourceBundle.getBundle("Keywords");
		Enumeration<?> bundleKeys = bundle.getKeys();
		while (bundleKeys.hasMoreElements()) {
			String key = (String) bundleKeys.nextElement();
			findKeyword(source, bundle.getString(key));
		}
		System.out.println();
	}
	
	public static int findKeyword(String source, String keyword) {
		int startIndex = 0;
		int condition = 0;
		int iteration = 0;
		while (condition != -1) {
			condition = source.indexOf(keyword, startIndex);
			startIndex += source.indexOf(keyword, startIndex);
			iteration += 1;
		}
		return iteration;
	}

}
