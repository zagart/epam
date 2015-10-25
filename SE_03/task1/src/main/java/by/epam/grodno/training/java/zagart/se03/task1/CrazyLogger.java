package by.epam.grodno.training.java.zagart.se03.task1;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CrazyLogger {

	private StringBuilder log = new StringBuilder(" ");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-YYYY : hh-mm");

	public void Append(Date date, String msg) {
		log.append(String.valueOf(String.format("{%s}", dateFormat.format(date))));
		log.append(String.format("[%s]; ", msg));
	}

	public void Print() {
		System.out.println(log.substring(0, log.length()));
		System.out.println();
	}

	public String findDateByMsg(String byMsg) {
		StringBuilder logCopy = new StringBuilder(log); 
		int index = logCopy.lastIndexOf(byMsg) - 2;
		if (index != -3) {
			logCopy.delete(index, logCopy.length());
			index = logCopy.lastIndexOf(";") + 3;
			String date = logCopy.substring(index, logCopy.length());
			return date;
		}
		return "Не найдено.";
	}

	public String findMsgByDate(Date byDate) {
		String date = String.valueOf(dateFormat.format(byDate));
		String msg = "не найдено.";
		if (log.indexOf(date) != -1) {
			Integer startIndex = log.indexOf("[", log.indexOf(date)) + 1;
			Integer endIndex = log.indexOf("]", startIndex) - 1;
			msg = log.substring(startIndex, endIndex);
			return msg;
		}
		return msg;
	}

}
