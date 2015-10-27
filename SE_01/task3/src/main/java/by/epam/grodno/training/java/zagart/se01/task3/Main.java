package by.epam.grodno.training.java.zagart.se01.task3;

public class Main {
	public static void main(String[] args) {
		int a = 1;
		int b = 10;
		int h = 3;
		final String functionStr = "Функция F(x) = tg(2x) - 3";

		System.out.printf("%s на отрезке [%s, %s] c шагом, равным %s принимает значения: \n", functionStr, a, b, h);

		for (int i = a; i <= b; i++) {
			if (i % h == 0) {
				double functionValue = (Math.tan(2 * i * (Math.PI / 180)) - 3);
				System.out.printf("x = %s | F(x) = %.5s; \n", i, functionValue);
			}
		}

	}
}
