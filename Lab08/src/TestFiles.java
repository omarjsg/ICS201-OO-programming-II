import java.io.*;
import java.util.*;

public class TestFiles {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Name.txt");
		if (file.exists()) {
			Scanner reader = new Scanner(file);
			PrintWriter printer = new PrintWriter("Arranged Names.txt");
			while (reader.hasNext()) {
				printer.println(reader.next() + " " + reader.next());
			}
			reader.close();
			printer.close();
			System.out.println("Names has been arranged.");
		} else {
			System.out.println("Error: file is not exist");
		}
	}
}
