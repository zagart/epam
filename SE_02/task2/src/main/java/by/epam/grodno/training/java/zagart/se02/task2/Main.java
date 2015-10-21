package by.epam.grodno.training.java.zagart.se02.task2;

public class Main {

	public static void main(String[] args) {
		
		Kit<Stationery> newbieKit = new Kit<Stationery>();
		
		newbieKit.addStationery(new Pen("Ручка MAXWELL", 1000));
		newbieKit.addStationery(new Pensil("Карандаш Tone", 500));
		newbieKit.addStationery(new Pen("Ручка TUKZAR", 3000));
		Ruler ruler = new Ruler();
		ruler.setName("Линейка TUKZAR");
		ruler.setCost(5000);
		ruler.setLength(10);
		newbieKit.addStationery(ruler);
		
		newbieKit.getStationeryList();
		
		System.out.println();
		System.out.println(ruler);
		
	}

}
