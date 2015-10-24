package by.epam.grodno.training.java.zagart.se02.task6;

@SubmarineAnnotation(decription = "Class which contains submarine stucture.")
public class Submarine {

	private boolean isMoving = false;
	private Hull hull = new Hull();
	private Engine engine = new Engine();
	private Reactor reactor = new Reactor();
	private Weaponry weaponry = new Weaponry();

	public void checkStatus() {
		if (isMoving)
			System.out.println("Атомная подводная лодка в плавании.");
		else
			System.out.println("Атомная подводная лодка не движется.");
	}

	public void Start() {
		engine.startEngine();
	}

	public void Stop() {
		engine.stopEngine();
	}

	public class Engine {

		public void startEngine() {
			isMoving = true;
		}

		public void stopEngine() {
			isMoving = false;
		}

	}

	public class Hull {

	}

	public class Reactor {

	}

	public class Weaponry {

	}

}
