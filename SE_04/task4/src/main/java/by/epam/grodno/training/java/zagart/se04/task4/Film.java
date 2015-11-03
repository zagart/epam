package by.epam.grodno.training.java.zagart.se04.task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class let create film's objects with actors list collection. Class have several
 * setter and getters and overloaded constructor.
 */
public class Film implements Serializable {

	private static final long serialVersionUID = -1204136510133319707L;
	private Collection<Actor> actorsList = new ArrayList<Actor>();
	@SuppressWarnings("unused")
	private String title;

	public Film(String title, Actor actor) {
		this.title = title;
		actorsList.add(actor);
	}

	public Film(String title, Collection<Actor> actors) {
		this.title = title;
		actorsList = actors;
	}

	public void addActor(String name, String secondName) {
		actorsList.add(new Actor(name, secondName));
	}

	public Collection<Actor> getActorsList() {
		return actorsList;
	}

	public void setActorsList(Collection<Actor> actors) {
		this.actorsList = actors;
	}

}
