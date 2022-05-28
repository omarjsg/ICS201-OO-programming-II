//import java.util.*;
public class Driver {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		//Scanner input = new Scanner(System.in);
		Octagon o1 = new Octagon((double)5);
		Octagon o2 = (Octagon) o1.clone();
		System.out.println(o1);
		System.out.println(o2);
		if (o1.compareTo(o2) == 0)
		{
			System.out.println("The octagons are equal");
		}else if (o1.compareTo(o2) < 0)
		{
			System.out.println("The second octagon is larger");
		}
		else
		{
			System.out.println("The first octagon is larger");
		}
		
	}

}
