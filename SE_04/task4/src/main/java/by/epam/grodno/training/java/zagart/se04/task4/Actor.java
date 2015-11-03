package by.epam.grodno.training.java.zagart.se04.task4;

import java.io.Serializable;

/**
 * Class let create actor personality object using their name and second name.
 * Have only getters. Changing name fields possible only when object created
 * (using constructor). Serializable.
 */
public class Actor implements Serializable {

	private static final long serialVersionUID = 8047265766115964359L;
	private String name;
	private String secondName;

	public Actor(String name, String secondName) {
		this.name = name;
		this.secondName = secondName;
	}

	public String getName() {
		return name;
	}

	public String getSecondName() {
		return secondName;
	}

}
