package by.epam.grodno.training.java.zagart.se05.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Utility class with static methods for common goals.
 */
public class Common {

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Method for entering value from console which will cause action according
	 * to item of menu. Also take under control possible exceptional situations.
	 * 
	 * @throws IOException
	 */
	public static int itemMenuEnter(int maxItemValue) throws IOException {
		int selectedItem = 0;
		boolean exception = true;
		while (exception) {
			try {
				selectedItem = Integer.parseInt(reader.readLine());
				reader.close();
				selectedItem = itemBoundCheck(selectedItem, maxItemValue);
				exception = false;
			} catch (NumberFormatException e) {
				exception = true;
				System.out.println("Неверный формат ввода. Попробуйте снова: ");
			}
		}
		return selectedItem;
	}

	/*
	 * Method responsible directly for checking entered item bounds.
	 */
	private static int itemBoundCheck(int selectedItem, int upperBound) throws NumberFormatException, IOException {
		int lowerBound = 1;
		while ((selectedItem < lowerBound) || (selectedItem > upperBound)) {
			System.out.print("Неверный номер пункта меню. ");
			System.out.println("Попробуйте снова: ");
			selectedItem = Integer.parseInt(reader.readLine());
			reader.close();
		}
		return selectedItem;
	}

}
