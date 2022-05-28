public class MyPoint {
	private double x, y; 
	public MyPoint(double x, double y) 
	{
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	public MyPoint() {
		// TODO Auto-generated constructor stub
		this(0,0);
	}
	private double getX()
	{
		return this.x;
	}
	private double getY()
	{
		return this.y;
	}
	public double distance(double x, double y)
	{
		return Math.sqrt(Math.pow(this.x-x, 2)+Math.pow(this.y-y, 2));
	}
	public double distance(MyPoint obj)
	{
		return Math.sqrt(Math.pow(this.x-obj.getX(), 2)+Math.pow(this.y-obj.getY(), 2));
	}
	public static double distance(MyPoint obj1,MyPoint obj2)
	{
		return Math.sqrt(Math.pow(obj2.getX()-obj1.getX(), 2)+Math.pow(obj2.getY()-obj1.getY(), 2));
	}
}
