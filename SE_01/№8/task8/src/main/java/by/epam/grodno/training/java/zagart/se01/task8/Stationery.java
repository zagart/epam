package by.epam.grodno.training.java.zagart.se01.task8;

public class Stationery {
	public Pen pen = new Pen();
	public Pensil pensil = new Pensil();
	public Eraser eraser = new Eraser();
	public Ruler ruler = new Ruler();
	
	public Stationery(Pen pen, Pensil pensil, Eraser eraser, Ruler ruler) {
		super();
		this.pen = pen;
		this.pensil = pensil;
		this.eraser = eraser;
		this.ruler = ruler;
	}
	
	public Stationery() {
	}
	
	
}
