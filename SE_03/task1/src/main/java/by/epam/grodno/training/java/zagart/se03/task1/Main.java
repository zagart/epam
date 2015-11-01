package by.epam.grodno.training.java.zagart.se03.task1;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import static by.epam.grodno.training.java.zagart.se03.task1.Util.*;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {

		CrazyLogger log = new CrazyLogger();
		Date date = createDate(11, 11, 1994, 10, 30);
		log.append(date, "Первый лог.");
		log.append(new Date(), "Второй лог.");
		log.append(new Date(1994 - 1900, 1, 31, 11, 1), "Третий лог.");
		log.print();

		String inputString = "";
		boolean exit = false;
		while (exit == false) {
			int selectedItem = 0;
			System.out.println("\n Выберите действие: ");
			System.out.println("1) Добавить сообщение.");
			System.out.println("2) Найти дату по сообщению.");
			System.out.println("3) Найти сообщение по дате.");
			System.out.println("4) Вывести лог.");
			System.out.println("5) Выход.");

			System.out.println("Введите номер пункта меню: ");
			inputString = rdr.readLine();

			if (isNumber(inputString) != -1) {
				selectedItem = Integer.parseInt(inputString);
			} else {
				while (isNumber(inputString) == -1) {
					System.out.println("Вводите ЧИСЛО... Попробуйте снова:");
					inputString = rdr.readLine();
				}
			}

			selectedItem = Integer.parseInt(inputString);

			switch (checkMenuItemNumber(selectedItem)) {
			case 1:
				System.out.println("Введите новое сообщение:");
				inputString = rdr.readLine();
				log.append(new Date(), checkMsgLength(inputString));
				break;
			case 2:
				System.out.println("Введите сообщение для поиска по датам:");
				findDate(log);
				break;
			case 3:
				System.out.println("Пункт меню не реализован динамически...");
				System.out.println("Результат для даты  {26-12-1994 : 10-30}:");
				System.out.println("Сообщение найдено по дате: " + log.findMsgByDate(createDate(11, 11, 1994, 10, 30)));
				break;
			case 4:
				System.out.println("Уже сохраненные сообщения:");
				log.print();
				break;
			case 5:
				System.out.println("\nПриложение завершило работу...");
				exit = true;
				break;
			}
		}

	}

}
