
public abstract class GeometricObject {
	private String color;
	private String filled;

	public GeometricObject(String color, boolean fill) {
		this.color = color;
		if (fill == true) {
			filled = "is filled";
		} else {
			filled = "is not filled";
		}
	}

	public String getColor() {
		return this.color;
	}

	public String getFillStatus() {
		return this.filled;
	}

	public abstract double getArea();

	public abstract double getParameter();

	public abstract String toString();
}
