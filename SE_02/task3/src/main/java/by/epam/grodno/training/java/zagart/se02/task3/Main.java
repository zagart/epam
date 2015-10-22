package by.epam.grodno.training.java.zagart.se02.task3;

import java.util.Collections;
import java.util.Comparator;

import by.epam.grodno.training.java.zagart.se02.task3.office.Eraser;
import by.epam.grodno.training.java.zagart.se02.task3.office.Ruler;
import by.epam.grodno.training.java.zagart.se02.task3.writing.Pen;
import by.epam.grodno.training.java.zagart.se02.task3.writing.Pensil;

public class Main {

	public static void main(String[] args) {
		
		Kit<Stationery> newbieKit = new Kit<Stationery>();
		testMethod(newbieKit);
		
		Comparator <Stationery> byPrice = new Comparator<Stationery>() {
			public int compare (Stationery a, Stationery b) {
				if (a.getCost() > b.getCost()) return 1;
				if (a.getCost() < b.getCost()) return -1;
				return 0;
			}
		};
		
		Comparator <Stationery> byName = new Comparator<Stationery>() {
			public int compare (Stationery a, Stationery b) {
				return a.getName().compareTo(b.getName());
			}
		};
		
		Comparator <Stationery> byNameAndByPrice = new Comparator<Stationery>() {
			public int compare (Stationery a, Stationery b) {
				if (a.getName().compareTo(b.getName()) == 0) {
					if (a.getCost() > b.getCost()) return 1;
					if (a.getCost() < b.getCost()) return -1;
					return 0;
				}
					return a.getName().compareTo(b.getName());
			}
		};
		
		System.out.println("Not sorted:");
		newbieKit.printList();
		System.out.println();
		
		System.out.println("Sorted by name:");
		sortMethod(newbieKit, byName);
		
		System.out.println("Sorted by price:");
		sortMethod(newbieKit, byPrice);		
		
		System.out.println("Sorted by name and by price:");
		sortMethod(newbieKit, byNameAndByPrice);	
	
	}
	
	public static void testMethod(Kit<Stationery> kit) {
		
		kit.addStationery(new Pen("Ручка MAXWELL", 1000));
		kit.addStationery(new Pen("Ручка MAXWELL", 300));
		kit.addStationery(new Pensil("Карандаш Tone", 1000));
		kit.addStationery(new Pensil("Карандаш Tone", 500));
		kit.addStationery(new Pen("Ручка TUKZAR", 3000));
		kit.addStationery(new Pen("Ручка TUKZAR", 2900));
		kit.addStationery(new Eraser("Ластик Style", 1000));
		Ruler ruler = new Ruler();
		ruler.setName("Линейка TUKZAR");
		ruler.setCost(5000);
		ruler.setLength(10);
		kit.addStationery(ruler);		
		
	}

	public static void sortMethod(Kit<Stationery> kit, Comparator<Stationery> comparator) {
		Collections.sort(kit.getStationeryList(), comparator);
		kit.printList();
		System.out.println();
	}
	
}
