import java.io.*;
import java.util.Random;

public class Lab20 {

	public static void main(String[] args) throws IOException {
		File bFile = new File("Lab20.dat"), tFile = new File("Lab20.txt");

		try (DataOutputStream binaryFileStream = new DataOutputStream(new FileOutputStream(bFile))) {
			PrintWriter printer = new PrintWriter(tFile);
			Random random = new Random();
			int rNumber;
			for (int i = 0; i < 1000000; i++) {
				rNumber = random.nextInt(1000000) + 1;
				binaryFileStream.writeInt(rNumber);
				printer.println(rNumber);
			}
			printer.close();
			System.out.printf("Text file size = %d.%n", tFile.length());
			System.out.printf("Binary file size = %d.", bFile.length());

		}

	}

}
