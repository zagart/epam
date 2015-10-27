package by.epam.grodno.training.java.zagart.se03.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		
		CrazyLogger log = new CrazyLogger();
		BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));

		log.append(createDate(1, 1, 1994, 10, 30), "Первый лог.");
		log.append(new Date(), "Второй лог.");
		log.append(createDate(26, 5, 2000, 11, 30), "Третий лог.");
		log.print();
		System.out.println("Сообщение найдено по дате: " + log.findMsgByDate(createDate(26, 5, 2000, 11, 30)));

		System.out.println("Введите сообщение для поиска даты: ");
		String msg = rdr.readLine();
		while ((msg.length() > 18) || (msg.length() < 1)) {
			System.out.print("Сообщение не должно быть пустым и не должно ");
			System.out.printf("иметь длину более %s символов. \n", CrazyLogger.logMaxLength);
			System.out.println("Попробуйте снова: ");
			msg = rdr.readLine();
		}
		System.out.println(log.findDateByMsg(msg));

	}

	public static Date createDate(int day, int month, int year, int hour, int minute) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-YYYY : hh-mm");
		String strDate = String.format("%s-%s-%s : %s-%s", day, month, year, hour, minute);
		Date objDate = dateFormat.parse(strDate);
		return objDate;
	}

}
