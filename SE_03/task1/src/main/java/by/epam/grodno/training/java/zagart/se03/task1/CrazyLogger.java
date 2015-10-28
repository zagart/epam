package by.epam.grodno.training.java.zagart.se03.task1;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CrazyLogger {

	final static byte dateMaxLength = 18; 
	final static byte msgMaxLength = 18;	
	final static public SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY : hh-mm");
	private StringBuilder log = new StringBuilder(" ");

	public void append(Date date, String msg) {
		log.append(String.valueOf(String.format("{%s}", dateFormat.format(date))));
		log.append(String.format("[%s]; ", msg));
	}

	public void print() {
		System.out.println(log.substring(0, log.length()));
		System.out.println();
	}

	public String findDateByMsg(String msg) {
		int msgStartIndex = log.lastIndexOf(msg);
		if (msgStartIndex != -1) {
			int logEndIndex = log.indexOf("]", msgStartIndex) - 1;
			int logStartIndex = log.indexOf("[", logEndIndex - msgMaxLength - 1) + 1;		
			int dateEndIndex = logStartIndex - 2;
			int dateStartIndex = log.indexOf("{", dateEndIndex - dateMaxLength - 1) + 1;
			return log.substring(dateStartIndex, dateEndIndex);
		}		
		return "Сообщение не найдено. \n\n";
	}
	

	public String findMsgByDate(Date byDate) {
		String date = String.valueOf(dateFormat.format(byDate));
		String msg = "";
		if (log.indexOf(date) != -1) {
			Integer startIndex = log.indexOf("[", log.indexOf(date)) + 1;
			Integer endIndex = log.indexOf("]", startIndex) - 1;
			msg = log.substring(startIndex, endIndex);
			return msg;
		}
		return "Дата не найдена.";
	}

}
