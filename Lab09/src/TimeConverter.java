import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeConverter {
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		File file = new File("times.txt");
		int i = 1;
		if (file.exists()) {
			Scanner reader = new Scanner(file);
			PrintWriter printer = new PrintWriter("Converted.txt");
			//System.out.println("#\t24-hour\t\t12-hour\n---------------------------------"); //test
			printer.println("#\t24-hour\t\t12-hour\n---------------------------------");
			while (reader.hasNext()) {
				String time = reader.next();
				try {
					if (Integer.parseInt(time.substring(0, 2)) < 24 && Integer.parseInt(time.substring(3)) < 60
							&& time.charAt(2) == ':') {
						SimpleDateFormat Time24 = new SimpleDateFormat("HH:mm");
						SimpleDateFormat Time12 = new SimpleDateFormat("hh:mm a");
						Date date = Time24.parse(time);
						//System.out.println(i + "\t" + Time24.format(date) + "\t\t" + Time12.format(date)); //test
						printer.println(i + "\t" + Time24.format(date) + "\t\t" + Time12.format(date));
						i++;
					} else {
						throw new TimeException("Error: Invalid Time input");
					}
				} catch (TimeException ex) {
					//System.out.println(i + "\t" + time + "\t\tTime Exception");//test
					printer.println(i + "\t" + time + "\t\tTime Exception");
					i++;
				} catch (NumberFormatException ex) {
					//System.out.println(i + "\t" + time + "\t\tTime Exception"); //test
					printer.println(i + "\t" + time + "\t\tTime Exception");
					i++;
				}
			}
			reader.close();
			printer.close();
			System.out.println("File has been created.");
		} else {
			System.out.println("Error: file does not exist");
		}
	}

}
