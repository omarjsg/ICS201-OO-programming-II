import java.util.*;

// Name: Omar Jarallah S. Alghamdi.
// ID: 201855000.
public class Driver {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner input = new Scanner(System.in);
		double[] sides = new double[3];
		boolean fill = false;
		try {
			for (int i = 1; i <= 3; i++) { // sides values input.
				System.out.printf("Enter the #%d side of the triangle%n", i);
				sides[i - 1] = input.nextDouble();
			}
			System.out.println("Enter the color of the Tringle");
			input.nextLine();
			String color = input.nextLine(); // color input
			boolean choice = true;
			System.out.println("Do you want to fill the triangle? ( Enter 1 if yes, 0 if no )");
			while (choice) {
				switch (input.nextInt()) { // choose between filled or not.
				case 0: // not filled.
					fill = false;
					choice = false;
					break;
				case 1: // filled.
					fill = true;
					choice = false;
					break;
				default:
					System.out.println("Please choose between zero and one.");
					break;
				}
			}
			Triangle triangle = new Triangle(sides[0], sides[1], sides[2], color, fill);
			Triangle triangle2 = new Triangle();
			System.out.println(triangle);
			System.out.println(triangle2);
			input.close();
		} catch (InputMismatchException ex) {
			System.err.println("Error: Invalid Input.");
			System.exit(0);
		} catch (IllegalTriangleException e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}
	}

}
