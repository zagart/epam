package by.epam.grodno.training.java.zagart.se02.task5;

public class Submarine {

	private boolean isMoving = false;
	private Engine engine = new Engine();
	
	public void checkStatus() {
		if (isMoving) System.out.println("Лодка плывет."); 
		else System.out.println("Лодка не движется.");
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
	
}
