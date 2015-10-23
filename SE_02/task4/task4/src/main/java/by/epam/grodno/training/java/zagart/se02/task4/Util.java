package by.epam.grodno.training.java.zagart.se02.task4;

public class Util {
	
	public static String[] names = {"Иван", "Петр", "Николай", "Саша", "Миша"};
	public static String[] secondNames = {"Иванов", "Петров", "Соколов", "Рамазанов", "Бейтюк"};
	
	public static Group<?> createGroup(String marksType, String name, Subject subject){
		if (marksType.equals("Integer")) {
			return new Group<Integer>(name, subject, new Integer(0));	
		}
		if (marksType.equals("Double")) {
			return new Group<Double>(name, subject, new Double(0));	
		}
		return null;
	} 
	
}
