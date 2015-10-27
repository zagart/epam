package by.epam.grodno.training.java.zagart.se03.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;
import static by.epam.grodno.training.java.zagart.se03.task1.Util.*;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {

		CrazyLogger log = new CrazyLogger();
		log.append(createDate(1, 1, 1994, 10, 30), "Первый лог.");
		log.append(new Date(), "Второй лог.");
		log.append(createDate(26, 5, 2000, 11, 30), "Третий лог.");
		log.print();

		System.out.println("Сообщение найдено по дате: " + log.findMsgByDate(createDate(26, 5, 2000, 11, 30)));
		System.out.println("\n Выберите действие: ");
		System.out.println("1) Добавить сообщение.");
		System.out.println("2) Найти дату по сообщению.");
		System.out.println("3) Найти сообщение по дате.");
		System.out.println("4) Вывести лог.");

		int selectedItem = Integer.parseInt(rdr.readLine());
		while ((selectedItem > 4) || (selectedItem < 1)) {
			System.out.println("Номер варианта выбран неверно. Попробуйте снова: ");
			selectedItem = Integer.parseInt(rdr.readLine());
		}

		switch (selectedItem) {
		case 1:
		case 2:
		case 3:
		case 4:
		}
		
		System.out.println(log.findDateByMsg(tookMsg()));

	}

}
