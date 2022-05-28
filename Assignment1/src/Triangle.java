import java.util.Arrays;

public class Triangle extends GeometricObject implements Comparable<Triangle> {
	private double side1, side2, side3;

	public Triangle(double side1, double side2, double side3, String color, boolean fill)
			throws IllegalTriangleException {
		super(color, fill);
		double[] temp = { side1, side2, side3 };
		Arrays.sort(temp); // to rearrange the sides from smallest to largest.
		if ((temp[0] + temp[1]) <= temp[2]) {
			throw new IllegalTriangleException(
					"Error: the sum of the smallest sides is less than or equal to the largest side");
		}
		this.side1 = temp[0];
		this.side2 = temp[1];
		this.side3 = temp[2];

	}

	// no-argument constructor "default constructor.
	public Triangle() throws IllegalTriangleException {
		this(1.0, 1.0, 1.0, "Black", false);
	}

	@Override
	// compare between the values between different Triangle classes.
	public int compareTo(Triangle o) {
		if (this.getArea() < o.getArea()) {
			return -1;
		} else if (this.getArea() > o.getArea()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	// to get the area of the triangle.
	public double getArea() {
		double s = getPerimeter() / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}

	@Override
	// To get the Perimeter of the triangle.
	public double getPerimeter() {
		return side1 + side2 + side3;
	}

	@Override
	// to deep copy Triangle object.
	public Object clone() throws CloneNotSupportedException {
		Triangle copy = (Triangle) super.clone();
		return copy;
	}

	@Override
	// To check if the attributes of the different Triangle objects are equal.
	public boolean equals(Object o) {
		if (o instanceof Triangle) {
			Triangle triangle = (Triangle) o;
			return compareTo(triangle) == 0;
		}
		return false;
	}

}
