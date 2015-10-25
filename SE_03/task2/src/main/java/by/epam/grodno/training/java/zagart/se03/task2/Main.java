package by.epam.grodno.training.java.zagart.se03.task2;

import static by.epam.grodno.training.java.zagart.se03.task2.Util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

	public static void main(String[] args) throws IOException {

		int numberChecker = 0;
		boolean checker = false;
		int questionsNumber = 3;
		BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Выберите язык: \n1)Русский\n2)Английский\n");
		localeSelection(rdr.readLine());
		printQuestions();

		while ((numberChecker < 1) || (numberChecker > questionsNumber)) {
			if (!checker) {
				System.out.println("Введите номер вопроса, чтобы узнать ответ:");
				numberChecker = Integer.parseInt(rdr.readLine());
			} else {
				System.out.println("Номер вопроса введен неверно! Попробуйте снова: ");
				numberChecker = Integer.parseInt(rdr.readLine());
			}
			checker = true;
		}

		printAnswer(String.valueOf(numberChecker));

	}

	static {
		Locale.setDefault(new Locale("ru"));
	}

}
