package application;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Main extends Application {
	int index = 1;

	public void start(Stage primaryStage) throws FileNotFoundException {
		BorderPane bpane = new BorderPane();
		HBox box = new HBox(10);
		box.setAlignment(Pos.CENTER);
		bpane.setBottom(box);
		box.setPadding(new Insets(20));
		Image[] images = { new Image("1.jpg"), new Image("2.jpg"), new Image("3.jpg"), new Image("5.jpg") };
		ImageView imageView = new ImageView(images[0]);
		imageView.setFitHeight(400);
		imageView.setFitWidth(600);
		bpane.setCenter(imageView);
		Button btNext = new Button("Next"), btBack = new Button("Back");
		btNext.setOnAction(e -> {
			if (index < images.length) {
				imageView.setImage(images[index++]);
				if (index == images.length) {
					index = 0;
				}
			}
		});
		btBack.setOnAction(e -> {
			if (index > 0) {
				imageView.setImage(images[index--]);
				if (index <= 0) {
					index = images.length - 1;
				}
			}
		});
		box.getChildren().addAll(btBack, btNext);
		Scene scene = new Scene(bpane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Show image");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
