import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		System.out.println("This program will calculate the number of characters inside a string");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string");
		String str = input.nextLine();
		System.out.println("Enter a character:");
			char a = input.next().charAt(0);
		input.close();
		System.out.println(count(str, a));
	}

	public static int count(String str, char a) {
		if(str.length() == 0)
		{
			return 0;
		} else if (str.charAt(0) == a)
		{
			return count(str.substring(1), a)+1;
		} else
		{
			return count(str.substring(1), a);
		}

	}
}
