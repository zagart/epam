package by.epam.grodno.training.java.zagart.se02.task2;

public class Main {

	public static void main(String[] args) {
		
		NewbieKit obj = new NewbieKit();
		obj.addStationery(new Pen("Ручка MAXWELL", 1000));
		obj.addStationery(new Pen("Ручка Tone", 1500));
		obj.addStationery(new Pen("Ручка TUKZAR", 3000));
		obj.getList();
		
	}

}
