package application;

import java.io.*;
import java.io.PrintWriter;
import java.util.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main extends Application {
	BorderPane borderpane = new BorderPane(); // the Scene pane.
	TextArea textArea = new TextArea(); // where the text will be displayed for the user.
	HBox hbox = new HBox(); // the pane for the buttons.
	StackPane pane = new StackPane(); // the pane for the Label.
	Student[] students; // New undeclared Array
	boolean sorted = false; // The indicator for sorting.

	public void start(Stage primaryStage) {
		textArea.setEditable(false); // To prevent the user from edit the text displayed on the text area.
		borderpane.setPadding(new Insets(10)); // To set the spacing between the BorderPane border and the inner
												// nodes.
		hbox.setAlignment(Pos.CENTER); // To arrange the buttons alignment.
		hbox.setPadding(new Insets(10)); // To set the spacing between the HBox border and the inner nodes.
		hbox.setSpacing(20); // To set the spaces between the buttons.
		pane.getChildren().add(textArea); // To add the TextArea in the StackPane.
		borderpane.setCenter(pane); // To add the StackPane in the center of the BorderPane.
		borderpane.setBottom(hbox); // To add the HBox in the bottom of the BorderPane.
		Button btLoad = new Button("Load"), btSort = new Button("Sort"), btSave = new Button("Save"); // Declaring three
		// buttons (Load, Sort, Save).
		hbox.getChildren().addAll(btLoad, btSort, btSave); // Adding the three buttons to HBox.
		btLoad.setPrefWidth(100); // to set the width for the Load button.
		btSort.setPrefWidth(100); // to set the width for the Sort button.
		btSave.setPrefWidth(100); // to set the width for the Save button.
		btLoad.setOnAction(e -> { // To play actions by clicking on load button.
			System.out.println("Load button is clicked.");
			try {
				int i = 0;
				textArea.clear(); // To clear for further loadings.
				System.out.println("Textarea has been cleared.");
				System.out.println("Invoking load method...");
				load(); // To call the load button.
				for (Student student : students) { // Loop to display every object contents on the TextArea.
					textArea.appendText(student.toString() + "\n");

					System.out.println("Student#" + i++ + " has been added to Textarea.");
				}
			} catch (FileNotFoundException e1) {
				System.err.println( // To display the error message in the console.
						"Error: File not found. \nPlease add the file to the java project file then click \"Load\" to proceed.");

			}
		});
		btSort.setOnAction(e -> { // To play actions by clicking on Sort button.
			if (students == null) { // To check if the Students array is created.
				System.out.println("Warining: please upload add \"unsortedStudents.txt\" file to the project folder.");
				notification(1); // to call notification method.
			} else {
				notification(2); // to call notification method.
				System.out.println("Sort button is clicked");
				textArea.clear(); // To clear the TextArea to add sorted objects in it.
				System.out.println("Textarea has been cleared.");
				Arrays.sort(students); // To sort students array.
				System.out.println("Students array has been sorted.");
				int i = 0;
				for (Student student : students) { // for loop to add the sorted object from the array to the
													// TextArea.
					textArea.appendText(student.toString() + "\n");
					System.out.println("Student#" + i++ + " has been added to Textarea.");
				}
				sorted = true; // To change the sorted value from false to true
			}
		});
		btSave.setOnAction(e -> { // To play actions by clicking on Save button.
			System.out.println("Save button is clicked");
			if (students == null) { // To check if the Students array is created.
				System.out.println("Warining: please upload add \"unsortedStudents.txt\" file to the project folder.");
				notification(1); // to call notification method.
			} else {
				if (sorted == true) { // To check if the array is sorted before adding it to the file.
					try {
						PrintWriter printer = new PrintWriter("StudentsSortedByID.txt");
						System.out.println("New file with name \"StudentsSortedByID.txt\" to the project file");
						int i = 0;
						for (Student student : students) { // for loop to add the sorted objects to the file.
							printer.println(student.toString());
							System.out.println(
									"Sorted student#" + i++ + " has been added to \"StudentsSortedByID.txt\" file");
						}
						printer.close();
						System.out.println("All resources have been added to the file.");
						notification(3); // to call notification method.
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					}
				} else {
					System.out.println("Warining: please sort the file.");
					notification(4); // to call notification method.
				}
			}
		});
		Scene scene = new Scene(borderpane, 400, 400); // Creating the scene and adding the BorderPane in it.
		primaryStage.setScene(scene); // Adding the scene to the stage.
		primaryStage.setMinWidth(400); // setting the stage minimum width.
		primaryStage.setMinHeight(400); // setting the stage minimum height.
		primaryStage.setTitle("Sorting Students"); // setting the title of the stage.
		primaryStage.show(); // Display the stage.
	}

	// To load the IDs and names to the array of type Student (students).
	public void load() throws FileNotFoundException {
		sorted = false; // If the user loaded the file for the second time after sorting it it will
						// return to unsorted status.
		System.out.println("load method is invoked");
		File file = new File("unsortedStudents.txt"); // creating new file object.
		System.out.println("New File object has been generated from path: " + file.getAbsolutePath() + ".");
		if (file.exists()) { // To check if the file exists.
			int size = 0; // Initialize the size of the array.
			Scanner reader1 = new Scanner(file); // To read the contents of the file. (This Scanner is to get size of
													// the array).
			while (reader1.hasNextLine()) { // while loop to determine the size of the array.
				reader1.nextLine(); // To move the scanner pointer to lower line.
				size++; // Increment the size by one.
			}
			reader1.close(); // Closing the scanner.
			students = new Student[size]; // Create new array of students.
			System.out.printf("New Array of Students has been generated with size %d%n", size);
			Scanner reader2 = new Scanner(file); // To read the contents of the file.
			int i = 0;
			while (reader2.hasNextLine()) { // while loop to add the contents of the file to the array.
				students[i] = new Student(reader2.nextInt(), reader2.next()); // Adding ID and name for each student
																				// object in the array.
				System.out.printf("Student#%d added to the array%n", i + 1);
				i++;
			}
			reader2.close(); // Closing the scanner.

		} else {
			notification(0); // to call notification method.
			throw new FileNotFoundException(""); // throw FileNotFoundException.
		}
	}

	// This method is to display the application notification.
	public void notification(int number) {
		BorderPane pane = new BorderPane(); // Create new BorderPane for notification scene.
		pane.setPrefWidth(300); // Define the BorderPane width.
		pane.setPrefHeight(100); // Define the BorderPane height.
		Stage stage = new Stage(); // Create new stage.
		stage.setResizable(false); // To prevent the user from resizing the notification window.
		stage.setTitle("Notification"); // Setting the title of the notification window.
		Scene scene = new Scene(pane); // Create a scene and adding the BorderPane in it.
		stage.setScene(scene); // Adding the stage
		pane.setPadding(new Insets(10)); // To set the spacing between the BorderPane border and the inner nodes.
		Button btOk = new Button("Ok"); // Creating new button object.
		btOk.setPrefWidth(100); // Define the width of the button.
		pane.setBottom(btOk); // Add the button in the bottom of the BorderPane.
		btOk.setOnAction(e -> { // Playing an action by clicking on OK button.
			stage.close(); // Closing the stage.
		});
		BorderPane.setAlignment(btOk, Pos.CENTER); // To align the button to the center of the bottom of the BorderPane.
		Label label = new Label(); // Creating new empty label.
		if (number == 0) { // To select the notification massage according to the number that came from the
							// caller method.
			label.setText(
					"File is not found. \nPlease add the file to the java project file then click \"Load\" to proceed.");
		} else if (number == 1) {
			label.setText("Warining: please add \"unsortedStudents.txt\" file to the project folder.");
			pane.setPrefWidth(500);

		} else if (number == 2) {
			label.setText("All resources have been sorted.");
		} else if (number == 3) {
			label.setText("All resources have been added to the file.");
		} else if (number == 4) {
			label.setText("Warining: please sort the file.");
		}
		pane.setCenter(label); // Adding the label to the center of the BorderPane.
		stage.show(); // Display the stage.

	}

	public static void main(String[] args) {
		launch(args);
	}
}
