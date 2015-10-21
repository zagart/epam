package by.epam.grodno.training.java.zagart.se02.task4;

public enum Subject {

	MATH("Математика"), ENG("Английский"), PHYS("Физика");
	
	private String subjectName;
	
	private Subject (String subjectName) {
		this.subjectName = subjectName;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
}
