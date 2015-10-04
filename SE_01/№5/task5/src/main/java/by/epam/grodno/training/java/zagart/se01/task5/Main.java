package by.epam.grodno.training.java.zagart.se01.task5;

public class Main {
	public static void main(String[] args) {
		int dim = 5;
		int count = 0;
		for (int j = 0; j < dim; j++) {
			for (int i = 0; i < dim; i++) {
				if (count == i || count == dim - i - 1) {
					System.out.print("1 ");
				} else System.out.print("0 ");
			}
			count++;
			System.out.println();
		}
	}
}
