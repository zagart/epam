package by.epam.grodno.training.java.zagart.se02.task1;

public class Main {

	public static void main(String[] args) {
		
		Pen obj = new Pen(10, "зеленый", "синий");
		Pen obj1 = new Pen(10, "зеленый", "синий");
		Pen obj2 = new Pen(8, "красный", "черный");
		
		System.out.println(obj.equals(obj1));
		System.out.println(obj.hashCode());
		System.out.println(obj1.hashCode());
		System.out.println(obj);
		System.out.println(obj1);
		
		System.out.println();
		
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj1);
		System.out.println(obj2);
	}

}
