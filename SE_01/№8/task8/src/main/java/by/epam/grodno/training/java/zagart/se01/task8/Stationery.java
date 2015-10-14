package by.epam.grodno.training.java.zagart.se01.task8;

public class Stationery extends Workers {

	private int penValue = 0;
	private int pensilValue = 0;
	private int eraserValue = 0;
	
	public int getPenValue() {
		return penValue;
	}

	public void setPenValue(int penValue) {
		this.penValue = penValue;
	}

	public int getPensilValue() {
		return pensilValue;
	}

	public void setPensilValue(int pensilValue) {
		this.pensilValue = pensilValue;
	}

	public int getEraserValue() {
		return eraserValue;
	}

	public void setEraserValue(int eraserValue) {
		this.eraserValue = eraserValue;
	}

		public Stationery(String name, int penValue, int pensilValue, int eraserValue) {
			super(name);
			this.penValue = penValue;
			this.pensilValue = pensilValue;
			this.eraserValue = eraserValue;
		}
		
		public void checkStationery () {
			System.out.println("У работника " + this.getName() + 
					" есть: ");
			if (this.getPenValue() != 0) System.out.println("- ручка;");
			if (this.getPensilValue() != 0) System.out.println("- карандаш;");
			if (this.getEraserValue() != 0) System.out.println("- ластик;");
		}
		
		@Override
		public String toString() {
			return "Имя работника - " + super.getName() +
					". Общая стоимость канцтоваров на рабочем месте - " +
					(int) (penValue + pensilValue + eraserValue) + ".";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + eraserValue;
			result = prime * result + penValue;
			result = prime * result + pensilValue;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Stationery other = (Stationery) obj;
			if (eraserValue != other.eraserValue)
				return false;
			if (penValue != other.penValue)
				return false;
			if (pensilValue != other.pensilValue)
				return false;
			return true;
		}

		public Stationery () {
			super();
		}
}
