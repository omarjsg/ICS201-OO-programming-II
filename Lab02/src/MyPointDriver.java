public class MyPointDriver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPoint spoint = new MyPoint(10.0,30.5);
		System.out.printf("Distance 1 = %.1f%n", spoint.distance(0, 0));
		MyPoint origin = new MyPoint();
		System.out.printf("Distance 2 = %.1f%n", spoint.distance(origin));
		System.out.printf("Distance 3 = %.1f", MyPoint.distance(spoint,origin));
	}

}