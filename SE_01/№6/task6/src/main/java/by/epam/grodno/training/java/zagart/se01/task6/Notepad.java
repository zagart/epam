package by.epam.grodno.training.java.zagart.se01.task6;

public class Notepad {
	public static void main(String[] args) {
		Notes obj = new Notes();
		obj.addNote("Запись 1");
		obj.addNote("Запись 2");
		obj.addNote("Запись 3");
		obj.showNotes();
		obj.deleteNote(1);
		obj.showNotes();
		obj.editNote(1, "Уже не запись 2");
		obj.showNotes();
	}
}
