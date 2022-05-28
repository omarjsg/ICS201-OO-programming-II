import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] sides = new double[3];
		boolean fill = false;
		try {
			for (int i = 1; i <= 3; i++) {
				System.out.printf("Enter the #%d side of the triangle%n", i);
				sides[i - 1] = input.nextDouble();
			}
			System.out.println("Enter the color of the Tringle");
			input.nextLine();
			String color = input.nextLine();
			boolean choice = true;
			System.out.println("Do you want to fill the triangle? ( Enter 1 if yes, 0 if no )");
			while (choice) {
				switch (input.nextInt()) {
				case 0:
					fill = false;
					choice = false;
					break;
				case 1:
					fill = true;
					choice = false;
					break;
				default:
					System.out.println("Please choose between zero and one!.");
					break;
				}
			}
			Triangle triangle = new Triangle(sides, color, fill);
			System.out.println(triangle);
			input.close();
		} catch (InputMismatchException ex) {
			System.out.println("Error: Invalid Input.");
		}
	}

}
