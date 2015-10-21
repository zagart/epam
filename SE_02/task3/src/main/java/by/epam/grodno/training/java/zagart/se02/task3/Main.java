package by.epam.grodno.training.java.zagart.se02.task3;

import by.epam.grodno.training.java.zagart.se02.task3.office.Eraser;
import by.epam.grodno.training.java.zagart.se02.task3.office.Ruler;
import by.epam.grodno.training.java.zagart.se02.task3.writing.Pen;
import by.epam.grodno.training.java.zagart.se02.task3.writing.Pensil;

public class Main {

	public static void main(String[] args) {
		
		Kit<Stationery> newbieKit = new Kit<Stationery>();
		
		newbieKit.addStationery(new Pen("Ручка MAXWELL", 1000));
		newbieKit.addStationery(new Pensil("Карандаш Tone", 500));
		newbieKit.addStationery(new Pen("Ручка TUKZAR", 3000));
		newbieKit.addStationery(new Eraser("Ластик Style", 1000));
		Ruler ruler = new Ruler();
		ruler.setName("Линейка TUKZAR");
		ruler.setCost(5000);
		ruler.setLength(10);
		newbieKit.addStationery(ruler);
		
		newbieKit.getStationeryList();
		System.out.println();
		newbieKit.getKitCost();
		
		System.out.println();
		System.out.println(ruler);
		
		
	}

}
