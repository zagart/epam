package by.epam.grodno.training.java.zagart.se01.task7;

public class Pen {

	private int size;
	private String color;
	private String incColor;
	
	@Override
	public boolean equals(Object obj) {
		System.out.print("Отработал метод equals(); ");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pen other = (Pen) obj;
		if (size != other.size)
			return false;
		if (color != other.color)
			return false;
		if (incColor != other.incColor)
			return false;
		return true;
	}

	public Pen(int size, String color, String incColor) {
		this.size = size;
		this.color = color;
		this.incColor = incColor;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Отработал метод toString(); Ручка имеет размер " + size + " см, цвет - " + color +
				", цвет чернил - " + incColor + ".";
	}
	
	
	
}
