package by.epam.grodno.training.java.zagart.se04.task4;

/**
 * Main class of the application.
 */
public class Main {

	/**
	 * Application enter point.
	 */
	public static void main(String[] args) {

		int selectedItem = 0;
		
		while (true) {
			System.out.println("\t Меню");
			System.out.println("1) Вывести список фильмов с актерами.");
			System.out.println("2) Выход.");
			selectedItem = Util.itemMenuEnter(selectedItem);
			switch (selectedItem) {
			case 1:
				return;
			case 2:
				System.out.println("Работа завершена.");
				System.exit(0);
			}
		}

	}

}
