package by.epam.grodno.training.java.zagart.se01.task2;

public class Loops {
	public int[] forLoop(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (isOdd(i)) {
				array[i] = array[i] * array[i - 1];
			}
		}
		System.out.println("forLoop done.");
		return array;
	}
	
	public int[] forEachLoop(int[] array) {
		int[] new_array = array;
		int temp = 0;
		int i = 0;
		for (int each : array) {
			if (isOdd(i)) {
				new_array[i] = new_array[i] * temp;
			}
			temp = each;
			i++;
		}
		System.out.println("forEachLoop done.");
		return new_array;
	}
	
	public int[] whileLoop(int[] array) {
		int i = 0;
		while (!(i == array.length)) {
			if (isOdd(i)) {
				array[i] = array[i] * array[i - 1];
			}
			i++;
		}
		System.out.println("whileLoop done.");
		return array;
	}
	
	public int[] doWhileLoop(int[] array) {
		int i = 0;
		do {
			if (isOdd(i)) {
				array[i] = array[i] * array[i - 1];
			}
			i++;
		} while (!(i == array.length));
		System.out.println("doWhileLoop done.");
		return array;
	}
	
	public static Boolean isOdd(int i) {
    	return (i % 2) == 1;
    }
	
}
