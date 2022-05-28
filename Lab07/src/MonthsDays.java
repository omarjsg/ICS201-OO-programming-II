import java.util.*;

public class MonthsDays {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int[] dom = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		boolean correct = true;
		Scanner input = new Scanner(System.in);
		do {
		try {
			System.out.println("Enter the month's number (integer from 1 - 12)");
			int month = input.nextInt() - 1;
			System.out.printf("Month name: %s, month's number of days = %d", months[month], dom[month]);
			correct = false;
			
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Wrong number.");
			correct = true;
			continue;
		} catch (InputMismatchException ex) {
			System.out.println("Error: Invalid Input.");
			input.nextLine();
			correct = true;
			continue;
		}
		} while(correct);
		input.close();
	}

}
