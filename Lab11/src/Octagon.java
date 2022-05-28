
public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
	private double side;
	static int number = 1;
	public Octagon(double side) {
		// TODO Auto-generated constructor stub
		this.side = side;
	}

	public Octagon() {
		// TODO Auto-generated constructor stub
		side = 0;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (2 + (4 / Math.sqrt(2))) * side * side;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return side * 8;
	}

	@Override
	public int compareTo(Octagon octagon) {
		// TODO Auto-generated method stub
		if (side < octagon.side) {
			return -1;
		} else if (side > octagon.side) {
			return 1;
		} else {
			return 0;
		}
	}

	public Object clone() throws CloneNotSupportedException {
		Octagon copy = (Octagon) super.clone();
		return copy;
	}

}
