import java.io.File;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the directory path: ");
		File file = new File(keyboard.nextLine());
		if (file.exists()) {
			System.out.println("Number of files in entered directory is: " + countFiles(file));
		} else {
			System.out.println("File does not exist");
		}
		keyboard.close();
	}

	public static int countFiles(File file) {
		int fileNumber = 0;
		if (file.isDirectory()) {
			File[] fileList = file.listFiles();
			for (int index = 0; index < fileList.length && file != null; index++) {
				fileNumber += countFiles(fileList[index]);
			}

		} else {
			fileNumber++;
		}
		return fileNumber;
	}
}
