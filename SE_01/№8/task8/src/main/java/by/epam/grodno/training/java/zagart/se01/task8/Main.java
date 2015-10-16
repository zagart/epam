package by.epam.grodno.training.java.zagart.se01.task8;

public class Main {

	public static void main(String[] args) {
		Worker wrk = new Worker("Артем", 10, 15, 20, 25);
		Worker wrk1 = new Worker();
		wrk1.setName("Дмитрий");
		wrk1.stationery.pen.setValue(20);
		wrk1.stationery.pensil.setValue(30);
		
		System.out.println(wrk);
		wrk.checkStationery();
		System.out.println();
		
		System.out.println(wrk1);
		wrk1.checkStationery();
		System.out.println();
	}

}
