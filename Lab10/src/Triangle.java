
public class Triangle extends GeometricObject {
	private double[] sides;

	public Triangle(double[] sides, String color, boolean fill) {
		super(color, fill);
		this.sides = sides;
	}

	@Override
	public double getArea() {
		double s = getParameter() / 2;
		return Math.sqrt(s * (s - sides[0]) * (s - sides[1]) * (s - sides[2]));
	}

	@Override
	public double getParameter() {
		return sides[0] + sides[1] + sides[2];
	}

	@Override
	public String toString() {
		return String.format("The area of the triangele is %.2f, its color is %s and it %s.", getArea(),
				super.getColor(), super.getFillStatus());
	}

}
