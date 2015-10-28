package by.epam.grodno.training.java.zagart.se03.task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.InputStreamReader;

import static by.epam.grodno.training.java.zagart.se03.task1.Util.rdr;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {

	public static BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));

	public static Date createDate(int day, int month, int year, int hour, int minute) throws ParseException {
		String strDate = String.format("%s-%s-%s : %s-%s", day, month, year, hour, minute);
		Date objDate = CrazyLogger.dateFormat.parse(strDate);
		return objDate;
	}

	public static void findDate(CrazyLogger log) throws IOException {
		String msg = checkMsgLength(rdr.readLine());
		System.out.printf("Результат поиска даты: \n %s \n", log.findDateByMsg(msg));
	}

	public static String checkMsgLength(String msg) throws IOException {
		while ((msg.length() > 18) || (msg.length() < 1)) {
			System.out.print("Сообщение не должно быть пустым и не должно ");
			System.out.printf("иметь длину более %s символов. \n", CrazyLogger.msgMaxLength);
			System.out.println("Попробуйте снова: ");
			msg = rdr.readLine();
		}
		return msg;
	}
	
	public static int checkMenuItemNumber(int selectedItem) throws NumberFormatException, IOException {
		int item = selectedItem;
		while ((item > 4) || (item < 1)) {
			System.out.println("Номер пункта меню выбран неверно. Попробуйте снова: ");
			selectedItem = Integer.parseInt(rdr.readLine());
		}
		return item;
	}

}
