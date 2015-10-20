package by.epam.grodno.training.java.zagart.se02.task2;

public class Main {

	public static void main(String[] args) {
		
		NewbieKit<Stationery> obj = new NewbieKit<Stationery>();
		
		obj.addStationery(new Pen("Ручка MAXWELL", 1000));
		obj.addStationery(new Pensil("Карандаш Tone", 500));
		obj.addStationery(new Pen("Ручка TUKZAR", 3000));
		Ruler ruler = new Ruler();
		ruler.setName("Линейка TUKZAR");
		ruler.setCost(5000);
		ruler.setLength(10);
		obj.addStationery(ruler);
		
		obj.getStationeryList();
		
		System.out.println();
		System.out.println(ruler);
		
	}

}
