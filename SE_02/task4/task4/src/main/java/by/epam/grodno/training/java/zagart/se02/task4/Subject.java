package by.epam.grodno.training.java.zagart.se02.task4;

public enum Subject {

	
	MATH("Математика"), PHYS("Физика"), ENG("Английский");
	private String subjectName;

	
	private Subject(String name) {
		subjectName = name;
	}

	
	public String getSubjectName() {
		return subjectName;
	}

	
}
