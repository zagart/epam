package by.epam.grodno.training.java.zagart.se04.task4;

import static by.epam.grodno.training.java.zagart.se04.task4.Util.addNewFilm;
import static by.epam.grodno.training.java.zagart.se04.task4.Util.deleteFilmFromCollection;
import static by.epam.grodno.training.java.zagart.se04.task4.Util.editExistingFilm;
import static by.epam.grodno.training.java.zagart.se04.task4.Util.printFilmsCollection;

import java.io.IOException;
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

		ArrayList<Film> films = (ArrayList<Film>) Util.getDataFileCollection();
		filmsMenu(films);

	}

	/*
	 * Method which create menu for films' collection.
	 */
	private static void filmsMenu(Collection<Film> films) {
		try {
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
					editExistingFilm(films);
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
		} catch (IOException e) {
			System.out.println("Что-то пошло не так:");
			e.printStackTrace();
		}

	}

}
