package by.epam.grodno.training.java.zagart.se01.task8;

public class Main {

	public static void main(String[] args) {
		Worker wrk = new Worker();
		wrk.setName("Артем");
		wrk.pen.setValue(10);
		wrk.pen.setQuantity(1);
		wrk.pensil.setValue(5);
		wrk.pensil.setQuantity(3);
		wrk.eraser.setValue(6);
		wrk.eraser.setQuantity(1);
		
		Worker wrk1 = new Worker("Дмитрий");
		wrk1.pen.setValue(5);
		wrk1.pen.setQuantity(4);
		
		Worker wrk2 = 
				new Worker("Александра", new Pen(5, 2, "голубой"), new Pensil(5, 1, "твердый"),
						new Ruler(10, 1, 10), new Eraser(5, 1, "белый"));
		
		wrk.getStationery();
		wrk1.getStationery();
		wrk2.getStationery();
		
	}

}
