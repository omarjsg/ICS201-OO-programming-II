import java.io.*;
import java.util.*;

public class QuadraticEquationDriver
{
	public static void main(String[] args) 
	{
		try {
			Scanner KeyBoard = new Scanner(System.in);
			System.out.println("Please enter x^2 coefficient value:");
			double a = KeyBoard.nextDouble();
			System.out.println("Please enter x coefficient value:");
			double b = KeyBoard.nextDouble();
			System.out.println("Please enter c value");
			double c = KeyBoard.nextDouble();
			QuadraticEquation QE = new QuadraticEquation(a,b,c);
			System.out.printf("The quadratic equation created is: %.2fx^2 %+.2fx %+.2f%n",a,b,c);
			if (QE.getDiscriminant() == 0)
			{
				System.out.printf("The quadratic equation has a root only and it is x = %.2f",QE.getRoot1());
			}
			else if (QE.getDiscriminant() > 0)
			{
				System.out.printf("The quadratic equation has 2 roots and they are: %nx1 = %.2f%nx2 = %.2f", QE.getRoot1(), QE.getRoot2());
			}
			else
			{

				System.out.print("The equation has no roots");
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Error: Invalid input.");
		}
		catch (IllegalArgumentException j)
		{
			System.out.println("Error: a should not be zero");
		}
	}
}
