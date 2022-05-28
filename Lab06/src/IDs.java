import java.util.*;
import java.io.*;

public class IDs {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream instream = new FileInputStream("IDsWithDuplicates.txt");
			Scanner reader = new Scanner(instream);
			FileOutputStream outstream = new FileOutputStream("IDsWithoutDuplicates.txt");
			ArrayList<Integer> idList = new ArrayList<>(); // create new Array list.
			while (reader.hasNextInt())// Search for IDs.
			{
				int id = reader.nextInt(); // read the file
				if (!idList.contains(id)) // check if the id is already in the list.
					idList.add(id);// Add the IDs.
			}
			reader.close();
			PrintWriter printer = new PrintWriter(outstream);
			for (int i = 0; i < idList.size(); i++)

			{
				printer.println(idList.get(i) + " ");
			}
			printer.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: No such file or directory.");
		}
	}

}
