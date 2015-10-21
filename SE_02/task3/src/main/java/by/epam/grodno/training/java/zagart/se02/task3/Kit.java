package by.epam.grodno.training.java.zagart.se02.task3;

import java.util.LinkedList;

public class Kit<CLASS extends Stationery> {

	LinkedList<Stationery> list = new LinkedList<Stationery>();

	public void addStationery(CLASS obj) {
		list.add((Stationery) obj);
	}

	public LinkedList<Stationery> getStationeryList() {
		return list;
	}
	
	public void printList() {
		for (Stationery i : list) {
			System.out.println(i.getName() + " " + i.getCost());
		}
	}

	public int getKitCost() {
		int sum = 0;
		for (Stationery i : list) {
			sum += i.getCost();
		}
		System.out.println("Стоимость набора: " + sum + " руб.");
		return sum;
	}

}
