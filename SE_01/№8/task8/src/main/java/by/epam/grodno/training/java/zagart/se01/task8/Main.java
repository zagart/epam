package by.epam.grodno.training.java.zagart.se01.task8;

public class Main {

	public static void main(String[] args) {
		Stationery worker = new Stationery("Артем", 10, 15, 20);
		Stationery worker1 = new Stationery();
		worker1.setName("Дмитрий");
		worker1.setEraserValue(10);
		
		System.out.println(worker);
		worker.checkStationery();
		System.out.println();
		System.out.println(worker1);
		worker1.checkStationery();
		System.out.println();
	}

}
