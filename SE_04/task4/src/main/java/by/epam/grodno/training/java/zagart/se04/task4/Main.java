package by.epam.grodno.training.java.zagart.se04.task4;

import static by.epam.grodno.training.java.zagart.se04.task4.Util.addNewFilm;
import static by.epam.grodno.training.java.zagart.se04.task4.Util.deleteFilmFromCollection;
import static by.epam.grodno.training.java.zagart.se04.task4.Util.printFilmsCollection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Main class of the application.
 */
public class Main {

	/**
	 * Application enter point.
	 */
	public static void main(String[] args) {

		ArrayList<Film> films = new ArrayList<Film>();
		films.add(new Film("Пираты Карибского Моря", new Actor("Джонни", "Депп")));
		films.add(new Film("Сказка", new Actor("Робин", "Гуд")));
		Util.saveCollectionInDataFile(films);
		Collection<Film> films2 = Util.getDataFileCollection();
		filmsMenu(films2);

	}

	private static void filmsMenu(Collection<Film> films) {
		while (true) {
			System.out.println("\n\t Меню");
			System.out.println("1) Вывести список фильмов с актерами.");
			System.out.println("2) Добавить фильм.");
			System.out.println("3) Редактировать фильм.");
			System.out.println("4) Удалить фильм.");
			System.out.println("5) Выход.");
			switch (Util.itemMenuEnter(5)) {
			case 1:
				printFilmsCollection(films);
				continue;
			case 2:
				addNewFilm(films);
				continue;
			case 3:
				continue;
			case 4:
				deleteFilmFromCollection(films);
				continue;
			case 5:
				System.out.println("Работа завершена, данные сохранены.");
				Util.saveCollectionInDataFile(films);
				System.exit(0);
				continue;
			}
		}
	}

}
