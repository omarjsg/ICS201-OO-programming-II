import java.io.*;
// ID: s20185000
public class Test3Binary {
	static int numberOfGrades;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		try (DataInputStream dataInputStream1 = new DataInputStream(new FileInputStream("Test3Binary.dat"));) {
			double GPA = sum(dataInputStream1) / numberOfGrades;
			System.out.println("GPA = " + GPA);
		}

	}

	private static double sum(DataInputStream dataInputStream) throws IOException { // to calculate the sum of the
																					// grades.
		if (dataInputStream.available() > 0) {
			String grade = dataInputStream.readUTF();
			numberOfGrades++; // Increment the number of grades for each reading.
			if (grade.equals("A+")) {
				return 4 + sum(dataInputStream);
			} else if (grade.equals("A")) {
				return 3.75 + sum(dataInputStream);
			} else if (grade.equals("B+")) {
				return 3.5 + sum(dataInputStream);
			} else if (grade.equals("B")) {
				return 3 + sum(dataInputStream);
			} else if (grade.equals("C+")) {
				return 2.5 + sum(dataInputStream);
			} else if (grade.equals("C")) {
				return 2 + sum(dataInputStream);
			} else if (grade.equals("D+")) {
				return 1.5 + sum(dataInputStream);
			} else if (grade.equals("D")) {
				return 1 + sum(dataInputStream);
			} else if (grade.equals("F")) {
				return 0 + sum(dataInputStream);
			}
		}
		return 0;
	}
}
