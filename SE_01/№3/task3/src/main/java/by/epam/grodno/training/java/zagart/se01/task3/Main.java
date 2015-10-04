package by.epam.grodno.training.java.zagart.se01.task3;

public class Main {
	public static void main(String[] args) {
		int a = 1;
		int b = 10;
		int h = 3;	
		System.out.println("Функция F(x) = tg(2x) - 3 на отрезке [" + a + "; " + b +"] с шагом, равным " + h + ", принимает значения:" );
		for (int i = a; i <= b; i++) if (i % h == 0) System.out.println("x = " + i + " | F(x) = " + (Math.tan(2 * i * (Math.PI / 180)) - 3) + ";");
	}
}
