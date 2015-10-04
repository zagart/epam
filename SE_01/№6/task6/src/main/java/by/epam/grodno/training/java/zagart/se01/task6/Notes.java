package by.epam.grodno.training.java.zagart.se01.task6;

public class Notes {
	private int quan = 0;
	private String notes[] = new String[100];

	public void addNote(String value) {
		notes[quan] = value;
		quan++;
	}
	
	public void editNote(int index, String value) {
		notes[index - 1] = value;
	}
	
	public void deleteNote(int index) {
		notes[index - 1] = null;
		for (int i = index - 1; i < notes.length - 1; i++) {
			notes[i] = notes[i + 1];
		}
	}
	
	public void showNotes() {
		for (int i = 0; i < notes.length; i++) {
			if (!(notes[i] == null)) System.out.println(notes[i] + " index " + i);
		}
		System.out.println();
	}
}
