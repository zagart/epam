package by.epam.grodno.training.java.zagart.se03.task2;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class Util {

	public static void localeSelection(String langKey) {
		if (langKey.equals("2"))
			Locale.setDefault(Locale.ENGLISH);
		else if (!langKey.equals("1"))
			System.out.println("Выбран язык по умолчанию (Русский)");
		;
	}

	public static void printQuestions() {
		ResourceBundle bundle = ResourceBundle.getBundle("Questions", Locale.getDefault());
		Enumeration<?> bundleKeys = bundle.getKeys();
		while (bundleKeys.hasMoreElements()) {
			String key = (String) bundleKeys.nextElement();
			System.out.println(String.format("%s)%s", key, bundle.getString(key)));
		}
		System.out.println();
	}

	public static void printAnswer(String inputKey) {
		ResourceBundle bundle = ResourceBundle.getBundle("Answers", Locale.getDefault());
		System.out.println(String.format("%s)%s", inputKey, bundle.getString(inputKey)));
	}

}
