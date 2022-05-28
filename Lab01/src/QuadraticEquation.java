class QuadraticEquation 
{
	private double a;
	private double b;
	private double c;
	public QuadraticEquation(double a, double b, double c) throws IllegalArgumentException
	{
		if (a == 0) {
			throw new IllegalArgumentException();
		}
		else 
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	public double getDiscriminant() 
	{
		return Math.pow(b,2)-4*a*c;
	}
	public double getRoot1()
	{
		if (getDiscriminant() >= 0)
		{
			return (-this.b+Math.sqrt(getDiscriminant()))/(2.0*this.a);
		} 
		else
		{
			return 0;
		}
	}
	public double getRoot2()
	{
		if (getDiscriminant() >= 0)
		{
			return ((-1*this.b)-Math.sqrt(getDiscriminant()))/2.0*this.a;
		} 
		else
		{
			return 0;
		}
	}
}
