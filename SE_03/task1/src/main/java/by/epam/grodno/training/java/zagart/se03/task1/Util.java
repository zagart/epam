package by.epam.grodno.training.java.zagart.se03.task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Util {
	
	public static BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
	
	public static Date createDate(int day, int month, int year, int hour, int minute) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-YYYY : hh-mm");
		String strDate = String.format("%s-%s-%s : %s-%s", day, month, year, hour, minute);
		Date objDate = dateFormat.parse(strDate);
		return objDate;
	}
	
	public static String tookMsg() throws IOException {
		System.out.println("Введите сообщение для поиска даты: ");
		String msg = rdr.readLine();
		while ((msg.length() > 18) || (msg.length() < 1)) {
			System.out.print("Сообщение не должно быть пустым и не должно ");
			System.out.printf("иметь длину более %s символов. \n", CrazyLogger.logMaxLength);
			System.out.println("Попробуйте снова: ");
			msg = rdr.readLine();
		}
		return msg;
	}
	
}
