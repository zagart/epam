package by.epam.grodno.training.java.zagart.se04.task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class with static methods.
 */
public class Util {

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Method for creating new output stream and writing films collection in
	 * file data.dat
	 * 
	 * @throws IOException
	 */
	public static void saveCollectionInDataFile(Collection<Film> films) throws IOException {
		File data = new File("data.dat");
		try {
			if (!data.exists()) {
				data.createNewFile();
			}
			ObjectOutputStream dataFile = new ObjectOutputStream(new FileOutputStream(data));
			dataFile.writeObject(films);
			dataFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден.");
		}
	}

	/**
	 * Method for creating new film collection from reading file data.dat
	 */
	public static Collection<Film> getDataFileCollection() {
		File data = new File("data.dat");
		try {
			ObjectInputStream dataFile = new ObjectInputStream(new FileInputStream(data));
			@SuppressWarnings("unchecked")
			Collection<Film> films = (Collection<Film>) dataFile.readObject();
			dataFile.close();
			return films;
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден.");
			return null;
		} catch (IOException e) {
			System.out.println("Неизвестная ошибка.");
		} catch (ClassNotFoundException e) {
			System.out.println("Класс не найден.");
		}
		return null;
	}

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
				selectedItem = itemBoundCheck(selectedItem, maxItemValue);
				exception = false;
			} catch (NumberFormatException e) {
				exception = true;
				System.out.println("Ошибка ввода. Попробуйте снова: ");
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
		}
		return selectedItem;
	}

	/**
	 * Method delete film from films' collection by it's index.
	 * 
	 * @throws IOException
	 */
	public static void deleteFilmFromCollection(Collection<Film> films) throws IOException {
		if (!films.isEmpty()) {
			int selectedItem = 0;
			System.out.println("\nВведите номер фильма для удаления:");
			selectedItem = Util.itemMenuEnter(films.size()) - 1;
			ArrayList<Film> newFilms = (ArrayList<Film>) films;
			newFilms.remove(selectedItem);
			System.out.printf("Фильм под номером %s удален.\n", selectedItem + 1);
			Util.saveCollectionInDataFile(newFilms);
		} else {
			System.out.println("Нечего удалять.");
		}

	}

	/**
	 * Method for print in console saved in data.dat file collection.
	 * Collection's format of read and writing files must match.
	 */
	public static void printFilmsCollection(Collection<Film> films) {
		if (films != null) {
			if (films.isEmpty()) {
				System.out.println("Список фильмов пуст.");
			} else {
				System.out.println("\tСписок фильмов:");
				try {
				} catch (ClassCastException e) {
					System.out.println("Неверный формат коллекции. Работа завершена.");
					System.exit(1);
				}
				for (int i = 0; i < films.size(); i++) {
					String info = String.format("%s) Фильм: \"%s\". Главные роли: ", i + 1,
							((ArrayList<Film>) films).get(i).getTitle());
					for (Actor a : ((ArrayList<Film>) films).get(i).getActorsList()) {
						info += String.format("%s %s; ", a.getName(), a.getSecondName());
					}
					System.out.println(info);
				}
			}
		}
	}

	/**
	 * Method add new film to films' collection.
	 * 
	 * @throws IOException
	 */
	public static void addNewFilm(Collection<Film> films) throws IOException {
		ArrayList<Film> newFilms = (ArrayList<Film>) films;
		System.out.println("\n\tДобавление фильма.");
		newFilms.add(filmEnter());
		Util.saveCollectionInDataFile(newFilms);
		System.out.println("Фильм успешно добавлен.\n");
	}

	/*
	 * Creating new film using information from console.
	 */
	private static Film filmEnter() throws IOException {
		System.out.println("Введите название фильма:");
		String title = reader.readLine();
		System.out.println("Введите имя актера:");
		String name = reader.readLine();
		System.out.println("Введите фамилию актера:");
		String secondName = reader.readLine();
		return new Film(title, new Actor(name, secondName));
	}

	/**
	 * Method for editing records from films' collection.
	 * 
	 * @throws IOException
	 */
	public static void editExistingFilm(Collection<Film> films) throws IOException {
		System.out.println("\n\tРедактирование записи:");
		System.out.println("Введите номер записи, которую хотите отредактировать:");
		int selectedFilmIndex = itemMenuEnter(films.size()) - 1;
		System.out.println("Выберите тип изменений:");
		System.out.println("1) Изменить название фильма.");
		System.out.println("2) Добавить актера.");
		System.out.println("3) Удалить актера.");
		int typeOfEdit = itemMenuEnter(3);
		ArrayList<Film> newFilms = (ArrayList<Film>) films;
		String name = "";
		String secondName = "";
		switch (typeOfEdit) {
		case 1:
			System.out.println("Введите новое название фильма:");
			newFilms.get(selectedFilmIndex).setTitle(reader.readLine());
			Util.saveCollectionInDataFile(newFilms);
			return;
		case 2:
			System.out.println("Добавление актера.");
			System.out.println("Введите имя актера:");
			name = reader.readLine();
			System.out.println("Введите фамилию актера:");
			secondName = reader.readLine();
			newFilms.get(selectedFilmIndex).addActor(name, secondName);
			Util.saveCollectionInDataFile(newFilms);
			return;
		case 3:
			ArrayList<Actor> actorsList = (ArrayList<Actor>) newFilms.get(selectedFilmIndex).getActorsList();
			if (actorsList.size() > 1) {
				System.out.println("Удаление актера.");
				System.out.println("Выберите номер актера, которого хотите удалить:");
				int i = 1;
				for (Actor a : actorsList) {
					System.out.printf("%s) %s %s;\n", i, a.getName(), a.getSecondName());
					i++;
				}
				int actorIndex = itemMenuEnter(actorsList.size()) - 1;
				actorsList.remove(actorIndex);
				newFilms.get(selectedFilmIndex).setActorsList(actorsList);
				Util.saveCollectionInDataFile(newFilms);
			} else {
				System.out.print("Некого удалять. Фильм не может быть ");
				System.out.println("вообще без актеров!");
			}
			return;
		}

	}

}
