import java.io.*;

public class Driver {
	public static void main(String args[]) throws IOException {
		File binaryFile = new File("Assignment3.dat");
		if (binaryFile.exists()) {
			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(binaryFile));
			System.out.println("The sum of the double values in the binary file is: " + sum(dataInputStream));
		} else {
			System.err.println("Error: file does not exist.");
		}

	}

	// Calculate the sum of the double values in the binary file.
	private static double sum(DataInputStream dataInputStream) throws IOException {
		// TODO Auto-generated method stub
		if (dataInputStream.available() > 0) {
			return dataInputStream.readDouble() + sum(dataInputStream); // It will read a double value then it will send
																		// the remaining to the same method.
		} else {
			return 0; // If there is no data remaining on the file to read, it will return a zero.
		}
	}

}
