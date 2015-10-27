package by.epam.grodno.training.java.zagart.se01.task5;

public class Main {
	public static void main(String[] args) {
		
		int dim = 5;
		int count = 0;
		int[][] array = new int [dim][dim];
		
		for (int j = 0; j < dim; j++) {
			for (int i = 0; i < dim; i++) {
				if (count == i || count == dim - i - 1)
					array[j][i] = 1;
				else 
					array[j][i] = 0;
				}
				count++;
			}
		
		for (int j = 0; j < dim; j++) {
			for (int i = 0; i < dim; i++) {
				System.out.print(array[j][i] + " ");
			}
			System.out.println();
		}
	}
}
