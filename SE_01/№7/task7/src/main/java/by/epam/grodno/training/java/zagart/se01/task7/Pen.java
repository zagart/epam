package by.epam.grodno.training.java.zagart.se01.task7;

public class Pen {

	private int size;
	private String color;
	private String incColor;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((incColor == null) ? 0 : incColor.hashCode());
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pen other = (Pen) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (incColor == null) {
			if (other.incColor != null)
				return false;
		} else if (!incColor.equals(other.incColor))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	public Pen(int size, String color, String incColor) {
		this.size = size;
		this.color = color;
		this.incColor = incColor;
	}

	@Override
	public String toString() {
		return "Ручка имеет размер " + size + " см, цвет - " + color +
				", цвет чернил - " + incColor + ".";
	}
	
	
	
}
