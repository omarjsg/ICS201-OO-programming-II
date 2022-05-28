import java.io.*;
import java.util.*;

public class Driver {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File bFile = new File("Lab21.dat");
		ArrayList<Student> sList1 = new ArrayList<>(Arrays.asList(new Student("Omar", 201855000),
				new Student("Naif", 20186340), new Student("Sami", 201887910)));
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(bFile))) {
			output.writeObject(sList1);
		}
		try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("Lab21.dat")))
		{
			ArrayList<Student> sList2 = (ArrayList<Student>) (input.readObject());
			System.out.println(sList2);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
