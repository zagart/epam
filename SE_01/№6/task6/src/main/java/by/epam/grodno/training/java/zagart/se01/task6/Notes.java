package by.epam.grodno.training.java.zagart.se01.task6;

/**
 * Class for operations with note records.
 *
 */
public class Notes {
	private int quan = 0;
	private String notes[] = new String[100];

	/**
	 * Method add new note to notepad.
	 */
	public void addNote(String value) {
		notes[quan] = value;
		quan++;
	}
	
	/**
	 * The method of editing note which already saved in notepad.
	 * Method require existing note, note's index and new note's value.  
	 */
	public void editNote(int index, String value) {
		notes[index - 1] = value;
	}
	
	/**
	 * The method of removing the existing note under the specified index.
	 */
	public void deleteNote(int index) {
		notes[index - 1] = null;
		for (int i = index - 1; i < notes.length - 1; i++) {
			notes[i] = notes[i + 1];
		}
	}
	
	/**
	 * The method of printing all existing notes.
	 */
	public void showNotes() {
		for (int i = 0; i < notes.length; i++) {
			if (!(notes[i] == null)) System.out.println(notes[i] + " index " + i);
		}
		System.out.println();
	}
}
