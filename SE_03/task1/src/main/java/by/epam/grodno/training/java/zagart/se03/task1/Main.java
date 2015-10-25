package by.epam.grodno.training.java.zagart.se03.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws IOException {

		CrazyLogger log = new CrazyLogger();
		BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
		
		log.Append(createDate(1, 1, 1994, 22, 30), "Первый лог.");
		log.Append(new Date(), "Второй лог.");
		log.Append(createDate(26, 5, 2000, 22, 30), "Третий лог.");
		log.Print();
		System.out.println("Сообщение найдено по дате: " + log.findMsgByDate(createDate(26, 5, 2000, 22, 30)));
		
		System.out.println("Введите сообщение для поиска даты: ");
		System.out.println(log.findDateByMsg(rdr.readLine()));

	}

	public static Date createDate(int day, int month, int year, int hour, int minute) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-YYYY : hh-mm");
		String strDate = String.format("%s-%s-%s : %s-%s", day, month, year, hour, minute);
		Date date = new Date();
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
