package application;

//ID: s201855000
import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Test3GUI extends Application {
	BorderPane borderpane = new BorderPane();
	TextArea textArea = new TextArea();
	HBox statusBox = new HBox();
	StackPane pane = new StackPane();
	Label status = new Label("Status: ");
	TextField url = new TextField();
	FlowPane upper = new FlowPane();
	Button btLoad = new Button("Open"), btClear = new Button("Clear"), btSave = new Button("Save");

	@Override
	public void start(Stage primaryStage) {
		url.setPrefWidth(230);
		borderpane.setPadding(new Insets(10));
		statusBox.setAlignment(Pos.CENTER_LEFT);
		statusBox.setPadding(new Insets(10));
		pane.getChildren().add(textArea);
		borderpane.setTop(upper);
		borderpane.setCenter(pane);
		borderpane.setBottom(statusBox);
		statusBox.getChildren().add(status);
		upper.getChildren().addAll(url, btLoad, btSave, btClear);
		btLoad.setPrefWidth(50);
		btClear.setPrefWidth(50);
		btSave.setPrefWidth(50);
		btLoad.setOnAction(e -> {
			System.out.println("Open button is clicked.");
			try {
				textArea.clear();
				System.out.println("Textarea has been cleared.");
				System.out.println("Invoking load method...");
				load();
				status.setText("Status: File loaded");
			} catch (FileNotFoundException e1) {
				status.setText("Status: File Does not Exist");

			}
		});
		btClear.setOnAction(e -> {
			if (textArea.getText().length() == 0) {
				System.out.println("Clear button is clicked");
				status.setText("Status: no text please upload a text file");
			} else {
				System.out.println("Clear button is clicked");
				textArea.clear();
				status.setText("Status: cleared");
				System.out.println("Textarea has been cleared.");

			}
		});
		btSave.setOnAction(e -> {
			System.out.println("Save button is clicked");
			if (textArea.getText().length() == 0) {
				System.out.println("Warining: please upload a file path in the text field.");
				status.setText("Status: no text please upload a text file");
			} else {
				try {
					PrintWriter printer = new PrintWriter(url.getText());
					System.out.println("The file with name " + url.getText() + " has been saved");
					printer.print(textArea.getText());
					status.setText("Status: File saved");
					printer.close();
					System.out.println("All resources have been added to the file.");
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				}
			}
		});
		Scene scene = new Scene(borderpane, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(400);
		primaryStage.setMinHeight(400);
		primaryStage.setTitle("Loading files");
		primaryStage.show();
	}

	public void load() throws FileNotFoundException {
		File file = new File(url.getText());
		System.out.println("New File object has been generated from path: " + file.getAbsolutePath() + ".");
		if (file.exists()) {
			int size = 0;
			Scanner reader1 = new Scanner(file);
			while (reader1.hasNextLine()) {
				textArea.appendText(reader1.nextLine() + "\n");
			}
			reader1.close();
		} else {
			throw new FileNotFoundException("");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
